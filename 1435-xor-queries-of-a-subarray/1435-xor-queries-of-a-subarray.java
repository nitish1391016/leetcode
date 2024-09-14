class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int[] xor = new int[arr.length];
        xor[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            xor[i] = arr[i]^xor[i-1];
        }
        
        int[] res = new int[q.length];
        for(int i=0;i<q.length;i++){
            if(q[i][0] > 0)
                res[i] = xor[q[i][0]-1]^xor[q[i][1]];
            else
                res[i] = xor[q[i][1]];
        }
        return res;
    }
}