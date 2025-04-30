package javaconcepts;

import java.util.*;

/*
Design an in-memory file system to simulate the following functions:

ls:                     Given a path in string format. If it is a file path, return a list that only contains this file's name.
                        If it is a directory path, return the list of file and directory names in this directory. 
                        Your output (file and directory names together) should in lexicographic order.

mkdir:                  Given a directory path that does not exist, you should make a new directory according to the path. 
                        If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

addContentToFile:       Given a file path and file content in string format. 
                        If the file doesn't exist, you need to create that file containing given content.
                        If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile:    Given a file path, return its content in string format.*/

class FileNode{
    String name;
    boolean isFile;
    StringBuilder content = new StringBuilder();
    HashMap<String, FileNode> children = new HashMap<>();

    public FileNode insert(FileNode root, String path, boolean isFile){
        String[] paths = path.split("/");
        for(String pathName: paths){
            if(pathName==""){continue;}
            if(!root.children.containsKey(pathName)){
                root.children.put(pathName,new FileNode());  
            }
            root = root.children.get(pathName);
        }
        if(isFile){
            root.isFile = true;
            root.name = paths[paths.length-1];
        }
        return root;
    }

    public FileNode search(FileNode root, String path){
        String[] paths = path.split("/");
        for(String pathName: paths){
            if(pathName==""){continue;}
            if(root.children.containsKey(pathName)){
                root = root.children.get(pathName);
            }else{
                return null;
            }
        }
        return root;
    }
}

class FileSystem {
    
    FileNode root = new FileNode();

    public List<String> ls(String path) {
        System.out.println("ls: "+path);
        FileNode cur = root.search(root,path);
        if(cur==null){return null;}

        List<String> li = new ArrayList<>();
        if(cur.isFile==true){
            li.add(cur.name);
            return li;
        }
        for(String child: cur.children.keySet()){
            li.add(child);
        }
        return li;
    }

    public void mkdir(String path) {
        System.out.println("mkdir: "+path);
        root.insert(root,path,false);
    }

    public void addContentToFile(String filePath, String content) {
        System.out.println("addContentToFile: "+filePath);
        FileNode node = root.insert(root,filePath,true);
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        System.out.println("readContentFromFile: "+filePath);
        FileNode node = root.search(root,filePath);
        if(node==null){return null;}
        return node.content.toString();
    }

    public static void main(String[] args) {
        // Test cases
        FileSystem fs = new FileSystem();

        // Test case 1: List contents of the root directory
        System.out.println("----------1----------");
        List<String> ouput = fs.ls("/");
        System.out.println(ouput== null || ouput.isEmpty() ? "Success" : "Fail");

        // Test case 2: Create nested directories
         System.out.println("----------2----------");
        fs.mkdir("/a/b/c");
        System.out.println("Success");

        // Test case 3: Add content to a file
         System.out.println("----------3----------");
        fs.addContentToFile("/a/b/c/d", "hello");
        System.out.println("Success");

        // Test case 4: Check contents of the root directory after mkdir
         System.out.println("----------4----------");
        List<String> expectedLs = List.of("a");
        List<String> actualLs = fs.ls("/");
        System.out.println(expectedLs.equals(actualLs) ? "Success" : "Fail");

        // Test case 5: Read content from a file
         System.out.println("----------5----------");
        String expectedContent = "hello";
        String actualContent = fs.readContentFromFile("/a/b/c/d");
        System.out.println(expectedContent.equals(actualContent) ? "Success" : "Fail");

        // Additional Test case 6: Add more content to the same file
         System.out.println("----------6----------");
        fs.addContentToFile("/a/b/c/d", " world");
        String expectedUpdatedContent = "hello world";
        String actualUpdatedContent = fs.readContentFromFile("/a/b/c/d");
        System.out.println(expectedUpdatedContent.equals(actualUpdatedContent) ? "Success" : "Fail");

        // Additional Test case 7: List contents of a subdirectory
         System.out.println("----------7----------");
        List<String> expectedSubdirLs = List.of("b");
        List<String> actualSubdirLs = fs.ls("/a");
        System.out.println(expectedSubdirLs.equals(actualSubdirLs) ? "Success" : "Fail");

        // Additional Test case 8: Check contents of a newly created empty directory
         System.out.println("----------8----------");
        fs.mkdir("/x/y/z");
        List<String> expectedEmptyDir = List.of("z");
        List<String> actualEmptyDir = fs.ls("/x/y");
        System.out.println(expectedEmptyDir.equals(actualEmptyDir) ? "Success" : "Fail");
    }
}