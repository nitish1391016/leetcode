class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i=0,j=0;j < n;j++) {
            if(j-i+1 == 3) {
                if((nums[j]+nums[i])*2 == nums[i+1]){
                    res++;
                }
                i++;
            }
        }
        return res;
    }
}