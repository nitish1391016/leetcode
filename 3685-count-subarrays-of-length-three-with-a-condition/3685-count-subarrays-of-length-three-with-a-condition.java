class Solution {
    public int countSubarrays(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int res = 0;
        while(j < n) {
            if(j-i+1<3){
                j++;
            }
            else if(j-i+1 == 3) {
                if((nums[j]+nums[i])*2 == nums[i+1]){
                    res++;
                }
                i++;
                j++;
            }
        }
        return res;
    }
}