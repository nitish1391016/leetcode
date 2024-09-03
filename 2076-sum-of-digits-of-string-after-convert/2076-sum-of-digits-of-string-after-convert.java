class Solution {
    public int getLucky(String s, int k) {
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            int ch = (int) (s.charAt(j) - 96);
            res += ch % 10;
            ch /= 10;
            res += ch;// as character conversion will be 2 digit number always
        }
        while (--k > 0 && ((int) Math.log10(res) + 1) > 1) {// Not iterating again for 1 digit number
            int temp = res, sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            res = sum;
        }
        return res;
    }
}