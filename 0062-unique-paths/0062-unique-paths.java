class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] list:dp){
            Arrays.fill(list, -1);
        }
        return unique(m, n,dp);
    }
    public int unique(int m, int n, int[][] dp) {
        if(m == 1 && n == 1) return 1;
        if(m<1 || n<1) return 0;
        if(dp[m][n] != -1)  return dp[m][n];
        int left = unique(m-1, n, dp);
        int right = unique(m, n-1, dp);
        dp[m][n] = left+right; 
        return dp[m][n];
    }
}