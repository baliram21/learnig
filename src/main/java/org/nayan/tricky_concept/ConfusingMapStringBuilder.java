package org.nayan.tricky_concept;

import java.util.*;

public class ConfusingMapStringBuilder {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("hello");
        Map<String, StringBuilder> map = new HashMap<>();

        map.put("key", sb);

        sb.append(" world");  // mutate same object

        System.out.println(map.get("key"));
    }
}
