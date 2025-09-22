class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        if(n == 1)
            return nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if(n == 2) { 
            return dp[1];
        }
        for(int i=2;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
}