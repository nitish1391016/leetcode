class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int dist = Integer.MAX_VALUE/2;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                if (dist < k) return false;
                dist = 0;
            }
            else {
                dist++;
            }
        }
        return true;
    }
}