class Solution {
    public int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int range = 0;
        for (int i = 0; i < n; i++) {
            range += arr[i];
        }

        int s = d + range;
        if (s % 2 != 0) {
            return 0;
        }

        int target = s / 2;

        Integer[][] dp = new Integer[n + 1][target + 1];
        return solve(arr, target, n, dp);
    }

    private int solve(int[] arr, int target, int n, Integer[][] dp) {
        if (n == 0 && target == 0) return 1;
        if (n == 0) return 0;

        if (dp[n][target] != null) return dp[n][target];

        if (arr[n - 1] <= target) {
            dp[n][target] = solve(arr, target - arr[n - 1], n - 1, dp) + solve(arr, target, n - 1, dp);
        } else {
            dp[n][target] = solve(arr, target, n - 1, dp);
        }

        return dp[n][target];
    }
}
