class Solution {
    public int minFallingPathSum(int[][] m) {
        int len = m.length;
        int[][] dp = new int[len][len];
        
        int min = Integer.MAX_VALUE;
        for(int i=0;i < len; i++){
            for(int[] list: dp)
                Arrays.fill(list, 20000);
            min = Math.min(min, minFalling(m, 0, i, dp));
        }
        return min;
    }

    public int minFalling(int[][] m, int row, int col, int[][] dp){
        if(row == m.length || col < 0 || col == m.length) return 200000;
        if(row == m.length-1 && col < m.length) return m[row][col];
        if(dp[row][col] != 20000)
            return dp[row][col];
        int left = minFalling(m, row+1, col-1, dp); 
        int right = minFalling(m, row+1, col+1, dp);
        int centre = minFalling(m, row+1, col, dp);
        dp[row][col] = m[row][col] + Math.min(left, Math.min(right, centre));
        return dp[row][col];
    }
}