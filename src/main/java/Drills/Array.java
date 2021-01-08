package Drills;

public class Array {

    /**
    *
    *@param array an array of String objects
     * @return the first element in the array
     */
    public String getFirstElement(String[] array){
        return array[0];
    }

    /**
     * @param stringArray an array of String objects
     * @return the second element in the array
     */
    public String getSecondElement(String[] stringArray){
        return stringArray[1];
    }

    /**
     * @param stringArray an array of String objects
     * @return the last element in the array
     */
    public String getLastElement(String[] stringArray){
        return stringArray[stringArray.length - 1];
    }

    /**
     * @param stringArray an array of String objects
     * @return the second to last element in the array
     */
    public String getSecondToLastElement(String[] stringArray){
        String secondToLastElement = stringArray[stringArray.length - 2];
        return secondToLastElement;
    }

}
