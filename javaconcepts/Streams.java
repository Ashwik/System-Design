package javaconcepts;

import java.util.*;
import java.util.stream.*;
class Streams {

    public static void main(String[] args){
        // List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // List<Integer> even = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
        // for(int i=0;i<even.size();i++){
        //     System.out.println(even.get(i));
        // }
        List<String> list = Arrays.asList("apple", "banana", "orange", "apple", "banana", "grape");
        Set<String> seen = new HashSet<>();

        Set<String> duplicates = list.stream().filter(n -> !seen.add(n)).collect(Collectors.toSet());
        Set<String> originals = list.stream().filter(n -> !duplicates.contains(n)).collect(Collectors.toSet());
        Iterator<String> itr = duplicates.iterator();
        // while(itr.hasNext()){
        //     System.out.println(itr.next());
        // }
        // itr = originals.iterator();
        // while(itr.hasNext()){
        //     System.out.println(itr.next());
        // }

        
    }
}