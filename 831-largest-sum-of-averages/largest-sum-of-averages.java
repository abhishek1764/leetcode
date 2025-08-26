class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        
        // Build prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        double[][] dp = new double[n + 1][k + 1];

        // Base case: only 1 partition
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }

        // Fill DP
        for (int groups = 2; groups <= k; groups++) {
            for (int i = groups; i <= n; i++) {
                for (int j = groups - 1; j < i; j++) {
                    double avg = (prefix[i] - prefix[j]) / (i - j);
                    dp[i][groups] = Math.max(dp[i][groups], dp[j][groups - 1] + avg);
                }
            }
        }

        return dp[n][k];
    }
}