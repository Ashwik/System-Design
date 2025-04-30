package javaconcepts;

import java.util.*;

public class HighFive{
    
    public void highFive(int[][] items){
        
        HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();

        for(int i=0;i<items.length;i++){
            int key = items[i][0];
            int value = items[i][1];
            if(mp.containsKey(key)){
                mp.get(key).add(value);
            }else{
                ArrayList<Integer> li = new ArrayList<>();
                li.add(value);
                mp.put(key,li);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        for(Map.Entry<Integer, ArrayList<Integer>> entry: mp.entrySet()){
            int key = entry.getKey();
            ArrayList<Integer> list = entry.getValue();
            Collections.sort(list,Collections.reverseOrder());
            int average = 0;
            for(int i=0;i<5;i++){
                average += list.get(i);
            }
            average = average/5;
            List<Integer> temp = new ArrayList<>();
            temp.add(key);
            temp.add(average);
            ans.add(temp);
        }

        for(int i=0;i<ans.size();i++){
            System.out.println("Id: "+ans.get(i).get(0)+ " Avg: "+ans.get(i).get(1));
        }
    
    }

    public static void main(String[] args){
        int[][] input = {
            {1, 91},
            {1, 92},
            {2, 93},
            {2, 97},
            {1, 60},
            {2, 77},
            {1, 65},
            {1, 87},
            {1, 100},
            {2, 100},
            {2, 76}
        };
        HighFive s = new HighFive();
        s.highFive(input);
        // Print the input to verify
        // for (int i = 0; i < input.length; i++) {
        //     System.out.println("[" + input[i][0] + ", " + input[i][1] + "]");
        // }
    }
}