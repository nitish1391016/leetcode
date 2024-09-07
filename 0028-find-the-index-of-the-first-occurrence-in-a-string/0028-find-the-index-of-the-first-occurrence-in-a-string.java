class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        
        for(int i=0;i< haystack.length();i++){
            int j = needle.length();
            // System.out.println(i+j);
            if(i+j <= haystack.length() && needle.equals(haystack.substring(i, i+j)))
                return i;
        }
        return -1;
    }
}