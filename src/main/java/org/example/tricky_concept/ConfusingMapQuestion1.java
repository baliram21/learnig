package org.example.tricky_concept;

import java.util.*;

public class ConfusingMapQuestion1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
        Map<String, List<Integer>> map = new HashMap<>();

        map.put("nums", list);   // map → {"nums" → same list object}

        // Reassign list variable to a NEW list object
        list = new ArrayList<>(Arrays.asList(99, 88));

        System.out.println("map.get(\"nums\") = " + map.get("nums"));
        System.out.println("list = " + list);
    }
}
