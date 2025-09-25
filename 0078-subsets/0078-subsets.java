class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        subset(nums, new ArrayList<Integer>(), nums.length-1);
        return res;
    }
    public void subset(int[] nums, List<Integer> sub, int n){
        if(n == -1) {
            res.add(new ArrayList(sub));
            return;
        }
        sub.add(nums[n]);
        subset(nums, sub, n-1);
        sub.remove(sub.size()-1);
        subset(nums, sub, n-1);
    }
}