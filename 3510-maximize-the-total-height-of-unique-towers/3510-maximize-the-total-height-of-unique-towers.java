class Solution {
    public long maximumTotalSum(int[] h) {
        Arrays.sort(h);
        long res = h[h.length-1];
        long val= res;
        long curr = res;
        for(int i = h.length-2;i>=0;i--){
            if(curr == h[i]){
                val--;
            }
            else {
                val--;
                curr = h[i]<val?h[i]:val;
                val = curr;
            }
            if(val == 0 || val == -1)
                return -1;
            res+=val; 
        }
        return res;  
    }
}