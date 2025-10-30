class Solution {
    public int minNumberOperations(int[] target) {
        if (target.length == 0) return 0;
        int n = target.length;
        int cnt = target[0];
        for (int i = 1; i < n; i++) {
            cnt += Math.max(0, target[i] - target[i - 1]);
        }
        return cnt;
    }
}