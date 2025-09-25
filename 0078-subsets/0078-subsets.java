class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        sub(nums,result,0,new ArrayList<>());
        return result;
    }
    public void sub(int []nums,List<List<Integer>>result , int ind , List<Integer> temp){
        if(ind == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        } 
        temp.add(nums[ind]);
        sub(nums,result,ind+1,temp);
        temp.remove(temp.size()-1);
        sub(nums, result, ind + 1, temp);


    }
}