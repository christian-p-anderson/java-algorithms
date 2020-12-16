package SearchAlgorithms;

public class BubbleSort {

    public int[] bubbleSort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
            if(array[j] > array[j+1]){
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
        }
        return array;
    }
}
