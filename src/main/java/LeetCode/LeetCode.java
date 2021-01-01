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

}
