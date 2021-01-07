package LeetCode;

import Drills.Array;

import java.util.*;

public class LeetCode {

    /**
     * Reverse A String
     * Write a function that reverses a string. The input string is given as an array of characters char[].
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with 0(1) extra memory
     *
     * You may assume all the characters consist of printable ascii characters.
     *
     * Example 1:
     * Input: ["h", "e", "l", "l", "o"]
     * Output: ["o", "l", "l", "e", "h"]
     *
     *
     * Example 2:
     * Input: ["H", "a", "n", "n", "a", "h"]
     * Output: ["h", "a", "n", "n", "a", "h"]
     *
     * Method with two pointers moving in different directions:
     */

    public void reverseString(char[] s){
        int start = 0;
        int end = s.length - 1;

        //start pointer moves forward in the array and the end pointer moves backwards,
        //uses a temp char placeholder to not write over anything
        //flips values until the start pointer and the end pointer converge, at which point the program ends
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Write a program that outputs the string representation of numbers from 1 to n.
     *
     * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
     * For numbers which are multiples of both three and five output “FizzBuzz”.
     *
     * Example:
     * n = 15,
     *
     * Return:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     */

    public List<String> fizzBuzz(int n){

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            String fizz = "Fizz";
            String buzz = "Buzz";
            String fizzBuzz = "FizzBuzz";
            String num = String.valueOf(i);

            if(n % 3 == 0 && n % 15 == 0){
                result.add(fizzBuzz);
            } else if( n % 3 == 0){
                result.add(fizz);
            } else if (n % 5 == 0){
                result.add(buzz);
            } else{
                result.add(num);
            }
        }
        return result;
    }

    /**
     * Majority Element
     *
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     */

    public int majorityElement(int[] nums){
        int majorityNum = 0;
        int half = nums.length / 2;
        Map<Integer, Integer> elementCount = new HashMap<Integer, Integer>();

        if(nums.length == 1){
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            //if the element is already in the map, increment the value by 1 (increase the count of appearances)
            if(elementCount.containsKey(nums[i])){
                elementCount.put(nums[i], 1 + elementCount.get(nums[i]));
            } else{
            // if the element is not already in the map, add it with a value of 1
                elementCount.put(nums[i], 1);
            }
            //check if current element appears more than half the time, if so break from loop and return majority num
            if(elementCount.get(nums[i]) > half){
                majorityNum = nums[i];
                break;
            }
        }
        return  majorityNum;
    }

    /**
     * ALTERNATE SOLUTION TO MAJORITY NUMS PROBLEM
     */

    public int majorityNumWithSort(int [] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * Decode Ways -> Dynamic Programming
     *
     * Bottom up processing: If you're asked to determine all of the ways to decode the length of a string n,
     * use all of the sub problems up until n to actually solve the problem. Start with a base case, determine the
     * answer of the base case, and then build on those base cases to solve the problem for n.
     *
     * dp[i] = dp[i-1] + dp[i-2]
     * We can decode the number at any given position in two ways, we can use it as just itself or as a pair with the
     * previous index.
     *
     A message containing letters from A-Z can be encoded into numbers using the following mapping:

     'A' -> "1"
     'B' -> "2"
     ...
     'Z' -> "26"
     To decode an encoded message, all the digits must be mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "111" can have each of its "1"s be mapped into 'A's to make "AAA", or it could be mapped to "11" and "1" ('K' and 'A' respectively) to make "KA". Note that "06" cannot be mapped into 'F' since "6" is different from "06".

     Given a non-empty string num containing only digits, return the number of ways to decode it.

     The answer is guaranteed to fit in a 32-bit integer.

     Example 1:

     Input: s = "12"
     Output: 2
     Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
     Example 2:

     Input: s = "226"
     Output: 3
     Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     Example 3:

     Input: s = "0"
     Output: 0
     Explanation: There is no character that is mapped to a number starting with 0. The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20".
     Since there is no character, there are no valid ways to decode this since all digits need to be mapped.
     Example 4:

     Input: s = "1"
     Output: 1
     *
     *
     * We initialize our base case to 1 i.e the number of ways to decode a string of length 0 and 1 or 0 for a string of
     * length 1. dp[1] depends on what the character is. If it's equal
     *
     */

        public int numDecodings(String s){
            //account for the number 0 if we have no string and we want to return the num of ways to decode the string
            //if it is of the length s
            int[] dp = new int[s.length() + 1];

            //base case: if we have a length of zero, it will be 1
            //dp stores num of way to decode a string of length x ([x])
            dp[0] = 1;
            //depends on the value of the value of the first character, A maps to 1, there is no mapping for 0
            //we only need to pay attention to if our first character maps to 0, is so there is no way to decode it
            //if its anything else, there is at least 1 way to decode it
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            //start at 2 as we have already accounted for i=0 & i=1
            //we want to know s full length, so it is <=
            //
            for (int i = 2; i <= s.length(); i++) {
                //getting the substring of the current character, taking the current character we are on,
                //converting it, and storing it in oneDigit
                int oneDigit =  Integer.valueOf(s.substring(i - 1, i));
                //we want to get the current digit and the previous digit
                //mapping is between 1-26, so we only care about oneDigit and twoDigit
                //get the last two digits: current and previous digits to combine them
                int twoDigits = Integer.valueOf(s.substring(i-2, i));
                //we know there is a mapping if this is true
                if(oneDigit >= 1){
                    //we want to add to the current sub problem we are solving all of the previous digits
                    //add to our current subproblem, the answer of our previous sub problem
                    dp[i] += dp[i-1];
                }
                //if this is true, then we know it has a mapping
                if(twoDigits >= 10 && twoDigits <= 26){
                    dp[i] += dp[i-2];
                }
            }
            //once we have filled our entire dp array up until the end, we only need to return the index of the length
            //of the input
            //the dp array stores the max num of ways to decode the string up until that index
            //it represents the num of ways to decode a string  of length "index"
            return dp[s.length()];
        }




}
