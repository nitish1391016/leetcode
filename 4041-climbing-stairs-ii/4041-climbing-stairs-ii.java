class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] nums = new int[costs.length+1];
        int[] dp = new int[costs.length+1];
        Arrays.fill(dp, -1);
        for(int i=1;i<=costs.length;i++){
            nums[i] = costs[i-1];
        }
        return jump(nums, 0, n, dp);        
    }
    public int jump(int[] costs, int ind, int n, int[] dp){
        if(ind == n) return 0;
        if(ind > n) return Integer.MAX_VALUE/2;
        int min = Integer.MAX_VALUE/2;
        if(dp[ind] != -1)   return dp[ind];
        for(int tr =1;tr<4;tr++){
            if(ind+tr<=n){
                int resfun = jump(costs, ind+tr, n, dp);
                if(resfun == Integer.MAX_VALUE/2) return Integer.MAX_VALUE/2;
                min = Math.min(cost(ind, ind+tr, costs) + resfun, min);
            }
        }

        return dp[ind] = min;
            
    }
    public int cost(int i, int j, int[] costs){
        if(j == costs.length){
            return (int)Math.pow(j-i, 2);
        }
        return costs[j] + (int)Math.pow(j-i, 2);
    }
}