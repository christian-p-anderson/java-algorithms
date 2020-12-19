package SearchAlgorithms;

public class BinarySearch {

    /**
     * Write a function that takes in a sorted array of ints as well as a target integer. The fn should use
     * the binary search algo to determine if the target int is contained in the array and should return its
     * index if it is, otherwise -1
     *
     * Recursive Binary Search (if target is not found, return -1, but ask interviewer what
     * they would like to be returned)
     */

    public int binarySearchRecursive(int[] array, int target){
        return binarySearchHelperRecursive(array,target, 0, array.length - 1);
    }

    public int binarySearchHelperRecursive(int[] array, int target, int left, int right){
        if( left > right){
            return -1;
        }
        int middle = Math.round((left + right)/2);
        int potentialMatch = array[middle];

        if(potentialMatch == target){
            return middle;
        } else if(potentialMatch > target ){
            return binarySearchHelperRecursive(array, target, left, middle - 1);
        } else{
            return binarySearchHelperRecursive(array, target, middle + 1, right);
        }
    }


    /**
     * Iterative Binary Search (helper fn not needed)
     */

    public int iterativeBinarySearch(int[] array, int target){
        int left = 0;
        int right = array.length -1;

        while(left <= right){
            int middle = Math.round((left + right) / 2);
            int potentalMatch = array[middle];

            if(potentalMatch == target){
                return middle;
            } else if(potentalMatch > target){
                right = middle - 1;
            } else{
                left = middle + 1;
            }
        }
        return -1;
    }

}
