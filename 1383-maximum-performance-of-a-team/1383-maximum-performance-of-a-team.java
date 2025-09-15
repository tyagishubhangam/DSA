import java.util.*;

public class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int)1e9 + 7;

        // Pair engineer efficiency and speed
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }

        // Sort by efficiency descending
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> speedHeap = new PriorityQueue<>();
        long speedSum = 0;
        long maxPerf = 0;

        for (int[] eng : engineers) {
            int currEff = eng[0];
            int currSpeed = eng[1];

            speedHeap.offer(currSpeed);
            speedSum += currSpeed;

            // Maintain top k speeds
            if (speedHeap.size() > k) {
                speedSum -= speedHeap.poll();
            }

            long performance = speedSum * currEff;
            maxPerf = Math.max(maxPerf, performance);
        }

        return (int)(maxPerf % MOD);
    }
}
