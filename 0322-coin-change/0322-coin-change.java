class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        int res = coin(coins, amount, coins.length-1, dp);
        if(res == Integer.MAX_VALUE/2)
            return -1;
        else
            return res;
    }
    public int coin(int[] coins, int amount, int ind, int[][] dp){
        if(amount == 0){
            return 0;
        }
        if(ind < 0) return Integer.MAX_VALUE/2;
        if(dp[ind][amount] !=-1) return dp[ind][amount];
        if(amount - coins[ind] >= 0){
            return dp[ind][amount] = Math.min(1+coin(coins, amount-coins[ind], ind, dp), coin(coins, amount, ind-1, dp));
        }
        else
            return dp[ind][amount] = coin(coins, amount, ind-1, dp);
    }
}