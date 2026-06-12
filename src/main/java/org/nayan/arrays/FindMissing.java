package org.nayan.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindMissing {
    public static void main(String[] args) {

        int[] arr ={1,3,5,7};

        List<Integer> list= new ArrayList<>();
        for (int j = 0; j < arr.length-1; j++) {
            if (arr[j]!=(j+1) ){
                list.add(arr[j]);
            }
        }
        System.out.println(list);
    }
}
