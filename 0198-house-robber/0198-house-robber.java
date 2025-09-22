class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return robbing(nums, nums.length-1, dp);
    }
    public int robbing(int[] nums, int i, int[] dp) {
        if(i == 0)  return nums[0];
        else if(i == 1) return Math.max(nums[0], nums[1]);
        if(dp[i] != -1) return dp[i];
        int left =robbing(nums, i-1, dp);
        int right = Integer.MIN_VALUE;
        if(i-2 >= 0)
            right = nums[i] + robbing(nums, i-2, dp);
        dp[i] = Math.max(left, right); 
        return dp[i];
    }
}