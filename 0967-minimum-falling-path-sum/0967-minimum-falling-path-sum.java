class Solution {
    public int minFallingPathSum(int[][] m) {
        int len = m.length;
        int[][] dp = new int[len][len];
        for(int row = len-1; row>=0; row--){
            for(int col = len-1;col >=0; col--){
                if(row == len-1){
                    dp[row][col] = m[row][col];
                }
                else{
                    int right = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(col-1 >=0)
                        left = dp[row+1][col-1];
                    if(col+1 < len)
                        right = dp[row+1][col+1];
                    int centre = dp[row+1][col];
                    dp[row][col] = m[row][col]+ Math.min(left, Math.min(right, centre));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            min = Math.min(min, dp[0][i]);
        }
        return min;
    }
}