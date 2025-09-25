class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int[][] dp = new int[n][n];
        for(int[] list: dp)
            Arrays.fill(list, -1);
        for(int i=n-1;i>=0;i--){
            for(int j=t.get(i).size()-1; j>=0;j--){
                if(i == t.size()-1)
                    dp[i][j] = t.get(i).get(j);
                else
                    dp[i][j] = t.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}