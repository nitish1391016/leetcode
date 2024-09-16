class Solution {

    public int findMinDifference(List<String> t) {
        int[] min = new int[t.size()];
        for (int i = 0; i < t.size(); i++) {
            String time = t.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            min[i] = h * 60 + m;
        }
        Arrays.sort(min);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < min.length - 1; i++) {
            res = Math.min(res, min[i + 1] - min[i]);
        }

        return Math.min(res, 24 * 60 - min[min.length - 1] + min[0]);
    }
}