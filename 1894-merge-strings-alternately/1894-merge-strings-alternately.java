class Solution {
    private String returnRes(String str1, String str2, boolean flag){
        String res = "";
        int i =0, j=0;
        while(j<str2.length()){
            if(flag){
                res+=str1.charAt(i++);
                flag= false;
            }
            else{
                res+=str2.charAt(j++);
                flag = true;
            }
        }
        res+=str1.substring(i,str1.length());
        return res;
    }
    public String mergeAlternately(String word1, String word2) {
        if(word1.length()<word2.length())
            return returnRes(word2, word1, false);
        return returnRes(word1, word2, true);
        
    }
}