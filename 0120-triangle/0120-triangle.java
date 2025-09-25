class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] list: dp)
            Arrays.fill(list, Integer.MAX_VALUE);
        return traverse(triangle, 0, 0, dp);
    }

    public int traverse(List<List<Integer>> t, int level, int ind, int[][] dp) {
        if (level == t.size()-1)
            return t.get(level).get(ind);
        if (dp[level][ind] != Integer.MAX_VALUE)
            return dp[level][ind];
        dp[level][ind] = t.get(level).get(ind) + Math.min(traverse(t, level + 1, ind, dp), traverse(t, level + 1, ind + 1, dp));
        return dp[level][ind];
    }
}