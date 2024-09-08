class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int m = word1.length();
        int n = word2.length();
        String res = "";
        while (i < m && i < n) {
            res += word1.charAt(i);
            res += word2.charAt(i++);
        }
        while (i < m) {
            res += word1.charAt(i++);
        }
        while (i < n)
            res += word2.charAt(i++);
        return res;
    }
}