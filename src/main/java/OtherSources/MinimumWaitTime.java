package OtherSources;

import java.util.Arrays;

public class MinimumWaitTime {

    /**
     *
     * You're given a non-empty array of positive integers representing the amounts of time that specific queries
     * take to execute. Only one query can be executed ata  time, but the queries can be executed in any order.
     * A query's waiting time is defined as the amount of time that it must wait before its execution starts. In other
     * words, if a query is executed second, then its waiting time is the duration of the first query; if a query is
     * executed third, then its waiting time is the sum of the durations of the first two queries.
     *
     * Sample Input
     * queries = [3, 2, 1, 2, 6]
     *
     * Sample Output
     * 17 // 1 + (1 + 2) + (1 + 2 + 2) + (1 + 2 + 2 + 3)
     *
     */

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        int totalWaitTime = 0;

        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int queriesLeft = queries.length - (i + 1);
            totalWaitTime += duration * queriesLeft;
        }
        return totalWaitTime;
    }

    // O(n log n)
}
