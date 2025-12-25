package org.nayan.dsa.map_heap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MethodsOfMap {
    public static void main(String[] args) {

        // Creating a HashMap that stores key-value pairs (String → Integer)
        // Map is an interface; HashMap is its implementation.
        Map<String, Integer> map = new HashMap<>();

        /* --------------------- put() -------------------------
           put(K key, V value)
           → Adds a new key-value pair into the map
           → If key already exists, value gets replaced
        -------------------------------------------------------*/
        map.put("nayan", 29);
        map.put("sonu", 25);
        map.put("monu", 21);
        map.put("toni", 20);

        /* --------------------- entrySet() ---------------------
           entrySet()
           → Returns a Set containing all key-value pairs
           → Each entry is represented as Map.Entry<K, V>
        --------------------------------------------------------*/
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);  // Prints entire map as entries

        /* ---------------- Looping on entrySet() ----------------
           for(Map.Entry<K,V> e : map.entrySet())
           → Best way to iterate over both keys & values
        ----------------------------------------------------------*/
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }

        /* --------------------- keySet() -------------------------
           keySet()
           → Returns a Set of only the keys
           → Useful when we need only keys
        ----------------------------------------------------------*/
        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        /* --------------------- get() ----------------------------
           get(Object key)
           → Returns value mapped with the given key
           → Returns null if key not present
        -----------------------------------------------------------*/
        Integer nayan = map.get("nayan");
        System.out.println(nayan);   // Output: 29

        Integer abc = map.get("abc");
        System.out.println(abc);     // Output: null (key not found)

        /* ---------------- containsKey() -------------------------
           containsKey(Object key)
           → Returns true if key exists in the map
        -----------------------------------------------------------*/
        boolean sonu = map.containsKey("sonu");
        System.out.println(sonu);    // true

        boolean lalu = map.containsKey("lalu");
        System.out.println(lalu);    // false

        /* --------------------- values() --------------------------
           values()
           → Returns a Collection of all values in the map
           → Does NOT return keys
        ------------------------------------------------------------*/
        Collection<Integer> values = map.values();
        System.out.println(values); // [29,25,21,20]

        /* ----------------- Additional Useful Methods -----------------

           size()
           → Returns number of key-value pairs in the map

           isEmpty()
           → Returns true if map has no entries

           remove(Object key)
           → Deletes the given key and returns its removed value

           remove(Object key, Object value)
           → Removes entry only if BOTH match

           replace(K key, V newValue)
           → Replaces value for given key

           replace(K key, V oldValue, V newValue)
           → Replaces only if oldValue matches

           clear()
           → Removes all entries from map
        ----------------------------------------------------------------*/

        System.out.println("Map size = " + map.size());  // 4
        System.out.println("Is map empty? " + map.isEmpty()); // false

        // Removing a key
        map.remove("monu");  // Removes key "monu"
        System.out.println(map);

        // Replacing value
        map.replace("sonu", 30);
        System.out.println(map);

        // clear()
        map.clear();
        System.out.println("After clear(): " + map); // {}
    }
}
