

package OtherSources;

public class ReverseString {

    /**
     * reverse a string using StringBuilder()
     */

    public String reverseString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);

        StringBuilder reverseString = stringBuilder.reverse();

        return reverseString.toString();

    }
}
