package OtherSources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysCommonIntegers {

    /**
     * This is from a practice whiteboard interview.
     * You have two arrays of integers. Return an array that contains integers unique to both arrays.
     */

//    public static void main(String[] args) {
//        Integer[] arr1 = {1, 3, 4, 5};
//        Integer[] arr2 = {9, 3, 4, 11};
//
//        ArraysCommonIntegers commonIntegers = new ArraysCommonIntegers();
//        Integer[] result = commonIntegers.commonArray(arr1, arr2);
//        System.out.println(Arrays.toString(result));
//    }

    public Integer[] commonArray(Integer[] arr1, Integer[] arr2) {
        // convert Arrays to ArrayLists
        List<Integer> arrList1 = new ArrayList<>(Arrays.asList(arr1));
        List<Integer> arrList2 = new ArrayList<>(Arrays.asList(arr2));

        // merge the 2 arrays
        arrList1.addAll(arrList2);

        // remove duplicates from the merged arraylists
        List<Integer> noDupes = arrList1.stream()
                                .distinct()
                                .collect(Collectors.toList());

        // return array
        return noDupes.toArray(new Integer[noDupes.size()]);

    }
}
