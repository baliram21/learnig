package org.nayan.tricky_concept;

import java.util.*;

public class ConfusingArrayAsList {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        
        List<Integer> list = Arrays.asList(arr);

        arr[0] = 99;     // modify the array
        // list.add(10);  // uncomment → throws UnsupportedOperationException

        System.out.println(list);
    }
}
