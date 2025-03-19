package org.example.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] arr = {1,2,4,2,4,1,1,6,7,7,4,8,9,4,4};

        Map<Integer,Integer> map= new HashMap<>();

        for (int no : arr){
           // map.put(no, map.getOrDefault(no, 0) + 1);
            //map.merge(no, 1, Integer::sum);

            /*Integer count = map.get(no);

            if (count==null){
                map.put(no, 1);
            }else {
                map.put(no,count+1);
            }*/
        }

       // Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (entry.getValue()>1){
                System.out.println(entry.getKey()+" repeat "+entry.getValue()+" times");
            }
        }


    }
}
