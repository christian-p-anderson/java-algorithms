package OtherSources;

public class ReverseString {

    /**
     * reverse a string using StringBuilder()
     */

    public String reverseString(String string) {
        StringBuilder reversedString = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(string[i]);
        }
        return reversedString.toString();
    }
}
