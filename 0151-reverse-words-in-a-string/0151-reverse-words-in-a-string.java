class Solution {
    public String reverseWords(String str) {
        // StringBuilder res = new StringBuilder("");
        String res = "";
        for(int i=0;i<str.length();i++){
            while(i<str.length() && str.charAt(i) == ' ') i++;
            int j = i;
            while(i< str.length() && str.charAt(i) != ' ' ) i++;
            res = str.substring(j, i)+" "+res;
        }
        int i=0, j=res.length();
        if(res.charAt(i)==' ')i++;
        if(res.charAt(j-1)==' ')j--;
        return res.substring(i,j);
    }
}