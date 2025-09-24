class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length-1;
        int[][] dp = new int[m+1][n+1];
        for(int[] list: dp)
            Arrays.fill(list, -1);
        return minPath(grid, m, n, dp);
    }
    public int minPath(int[][] grid, int m, int n, int[][] dp){
        if(m == 0 && n == 0) return grid[0][0];
        if(m < 0 || n < 0) return Integer.MAX_VALUE;
        if(dp[m][n] != -1) return dp[m][n];
        int up = minPath(grid, m-1, n, dp);
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(up != Integer.MAX_VALUE)
            left = grid[m][n] + up;
        int down = minPath(grid, m, n-1, dp);
        if(down != Integer.MAX_VALUE)
            right =grid[m][n] + down;
        dp[m][n] = Math.min(left, right);
        return dp[m][n];
    }
}