package org.nayan.srings;

import java.util.HashMap;
import java.util.Map;

public class StringProblem2 {
    public static void main(String[] args) {
        String str= "aaabbc";  // o/p- a3b3c1

        Map<Character,Integer> map= new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch= str.charAt(i);
            // map.put(ch, map.getOrDefault(ch,0)+1);
            //map.merge(ch,1,Integer::sum);
            Integer count= map.get(ch);
            if (count==null){
                map.put(ch,1);
            }else {
                map.put(ch,count+1);
            }
        }
        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        System.out.println(sb.toString());

    }
}
