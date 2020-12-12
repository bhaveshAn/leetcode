class Maximal_Square_Q_221 {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;
        int[][] dp = new int[m+1][n+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
