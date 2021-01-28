package Drills;

import java.util.Arrays;

public class ArrayOfWords {

    /**
     * take a sentence and return an array of words
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(returnArrayOfWords("I am hungry")));
    }


    public static String[] returnArrayOfWords(String str) {
        return str.split(" ");
    }

}
