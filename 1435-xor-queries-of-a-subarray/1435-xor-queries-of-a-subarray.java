class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int[] xor = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            xor[i+1] = arr[i]^xor[i];
        }
        
        int[] res = new int[q.length];
        for(int i=0;i<q.length;i++){
            res[i] = xor[q[i][0]]^xor[q[i][1]+1];
        }
        return res;
    }
}