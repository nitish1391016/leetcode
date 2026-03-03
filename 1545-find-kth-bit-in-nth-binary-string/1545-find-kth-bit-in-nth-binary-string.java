class Solution {
    public char findKthBit(int n, int k) {
        int res = findKth(n, k);
        return res == 0 ? '0': '1';
    }
    public int findKth(int n, int k) {
        int totalDigits = (int)Math.pow(2, n)-1;
        int middle = totalDigits/2+1;
        if(n == 1 && k == 1){
            return 0;
        }
        else if(middle == k) return 1;
        else if(k > middle){
            return findKth(n-1, totalDigits-k+1)==0 ?1:0;
        }
        else {
            return findKth(n-1, k);
        }
    }
}