package com.karatay.linear.hashmaps;

public class HashMapRunner {
    public static void main(String[] args) {
        String str = "green apple"; // should return 'l'

        HashMapExercises helper = new HashMapExercises();
        char nonRepeated = helper.getFirstNonRepeated(str);
        char repeated = helper.getFirstRepeated(str);
        System.out.println(nonRepeated);
        System.out.println(repeated);
    }
}
