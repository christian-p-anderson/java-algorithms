package SearchAlgorithms;

public class BinarySearch {

    /**
     *
     * This is the iterative approach
     */

    public static int binarySearch (int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - 1) / 2;

            if (arr[middle] == x) {
                return middle;
            } else if (arr[middle] < x) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
