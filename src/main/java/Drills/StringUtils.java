package Drills;

import java.util.Locale;

public class StringUtils {

    /**
     * @param str string input from client
     * @return string with identical content, and the first character capitalized
     */
    public static String camelCase(String str) {

        str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

        return str;
    }

    /**
     * @param str string input from client
     * @return string with identical contents, in the reverse order
     */
    public static String reverse(String str) {
       StringBuilder sb = new StringBuilder();

       sb.append(str).reverse();

       String reversedString =  sb.toString();

       return reversedString;
    }

    public String reverseAlt(String str) {
        if(str == null || str.isEmpty()){
            return str;
        }

        char[] characters = str.toCharArray();
       Integer left = 0;
       Integer right = str.length();

       while(left <= right){
           swap(characters, left, right);
           right++;
           left--;

       }
       return new String(characters);
    }

    public void swap(char[] array, Integer left, Integer right){
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
