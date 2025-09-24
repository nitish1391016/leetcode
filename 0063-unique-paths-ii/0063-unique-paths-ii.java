class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        return uniquePaths(o.length, o[0].length, o);
    }
    public int uniquePaths(int m, int n, int[][] o) {
        if(o[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i=m-1;i >=0;i--){
            for(int j=n-1;j >=0;j--){
                if(i ==m-1 && j == n-1) continue;
                dp[i][j] = o[i][j] == 0 ? dp[i+1][j]+dp[i][j+1]: 0;
            }
        }
        return dp[0][0];
    }
}