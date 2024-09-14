class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int x: nums)
            if(max<x)   max = x;

        int res =0;
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == max){
                cnt++;
            }
            else{
                res = res<cnt?cnt:res;
                cnt = 0;
            }
        }
        res = res<cnt?cnt:res;
        return res;
        
    }
}