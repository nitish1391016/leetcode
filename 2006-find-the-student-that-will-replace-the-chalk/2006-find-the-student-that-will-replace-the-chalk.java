class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        long sum[] = new long[len];
        sum[0] = chalk[0];
        for (int i = 1; i < len; i++) {
            sum[i] = chalk[i] + sum[i - 1];
        }
        k = (int) (k % sum[len - 1]);

        int i = 0, j = len - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (sum[mid] > k) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}