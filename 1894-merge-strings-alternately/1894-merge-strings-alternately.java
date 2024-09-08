class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int m = word1.length();
        int n = word2.length();
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        String res = "";
        while (i < m && i < n) {
            res += str1[i];
            res += str2[i++];
        }
        while (i < m) {
            res += str1[i++];
        }
        while (i < n)
            res += str2[i++];
        return res;
    }
}