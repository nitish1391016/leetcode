class Solution {
    public int rob(int[] nums) {
        int prev2 = 0, prev = 0;
        for(int i=0;i<nums.length;i++) {
            int curr = Math.max(prev2 +nums[i], prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}