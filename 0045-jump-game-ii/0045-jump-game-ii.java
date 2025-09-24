class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return jump2(nums, 0, dp);
    }

    public int jump2(int[] j, int curr, int[] dp) {
        if (curr >= j.length - 1) return 0;
        if(dp[curr] !=-1)   return dp[curr];
        int min = Integer.MAX_VALUE;
        int validcurr = j[curr];

        for (int i = 1; i <= validcurr; i++) {
            int next = jump2(j, curr + i, dp);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + next);
            }
        }
        dp[curr] = min;
        return min;
    }
}
