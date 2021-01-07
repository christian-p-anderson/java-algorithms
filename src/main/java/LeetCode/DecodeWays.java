package LeetCode;

public class DecodeWays {
    /**
     * https://www.youtube.com/watch?v=cQX3yHS0cLo
     * LeetCode 91
     *
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * A -> 1
     * B -> 2
     * ...
     * Z -> 26
     *
     * Given a non-empty string containing only digits, determine the total number of ways to decode it
     */

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < s.length(); i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >=10 && twoDigits <= 26) {
                dp[i] = dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
