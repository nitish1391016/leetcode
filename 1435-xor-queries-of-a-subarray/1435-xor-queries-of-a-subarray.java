class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int[] res = new int[q.length];
        for(int i=0;i<q.length;i++){
            int cal = 0;
            for(int j=q[i][0];j<=q[i][1];j++){
                cal = cal^arr[j];
            }
            res[i] = cal;
        }
        return res;
    }
}