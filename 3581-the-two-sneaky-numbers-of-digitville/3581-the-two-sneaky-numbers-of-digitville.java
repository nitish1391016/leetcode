class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int ind =0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                res[ind++] = nums[i];
            }
        }
        return res;
    }
}