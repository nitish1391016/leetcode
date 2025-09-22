class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        else if(n == 2)
            return Math.max(nums[0], nums[1]);
        
        int secprev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++) {
            int curr = Math.max(secprev+nums[i], prev);
            secprev = prev;
            prev = curr;
        }
        return prev;
    }
}