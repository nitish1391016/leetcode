class Solution {
    public boolean isIndexPairs(String str1, String str2) {
        if (str1.length() > str2.length())
            return false;
        else if (str1.length() == str2.length())
            return str1.equals(str2) ? true : false;
        return str2.substring(0, str1.length()).equals(str1)
                && str2.substring(str2.length() - str1.length()).equals(str1) ? true : false;

    }

    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isIndexPairs(words[i], words[j])) {
                    res++;
                }
            }
        }
        return res;
    }
}