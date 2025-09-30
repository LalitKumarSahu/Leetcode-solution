class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(values, 0, n - 1, dp);

    }

    public int solve(int[] values, int i, int j, int dp[][]) {
        // if less than 3 parameter then return 0
        if (j - i < 2)
            return 0;

        // if already is calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minScore = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int score = values[i] * values[j] * values[k] + solve(values, i, k, dp) + solve(values, k, j, dp);
            minScore = Math.min(minScore, score);
        }
        dp[i][j] = minScore;

        return minScore;
    }
}
