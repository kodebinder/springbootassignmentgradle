package com.company.tester;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GFGMapFlattenning {

    /**
     * To flatten a map containing a list of items as values
     *
     * @param values
     * @param <T>
     * @return
     */
    public static <T> Stream<T> flatten(Collection<List<T>> values) {

        /**
         * Stream.flatMap() method converts Stream<Collection<T>> to the  Stream<T>
         */
        Stream<T> stream = values.stream().flatMap(x -> x.stream());

        /**
         * Return the desired stream
         */
        return stream;
    }

    public static void main(String[] args) {

        /**
         * Creating an object of Map class
         * Declaring object of integer and string type
         */
        Map<Integer, List<String>> map = new HashMap<>();

        /**
         * Adding elements to the above Map object
         * Custom input entries
         */
        map.put(1, Arrays.asList("1", "2", "3"));
        map.put(2, Arrays.asList("4", "5", "6"));

        /**
         * Creating a List class object holding all elements after flattening
         */
        List<String> s = flatten(map.values()).collect(Collectors.toList());

        System.out.println("==============");

        /**
         *  Print and display the above List object
         */
        System.out.println(s);

        System.out.println("==============");
    }
}