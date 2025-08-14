class Solution {
    public String largestGoodInteger(String num) {
        int[] map = new int[11];
        for(int i=0;i<num.length()-2;i++){
            char a = num.charAt(i);
            char b = num.charAt(i+1);
            char c = num.charAt(i+2);
            if(a == b && b == c){
                int digit = (int)(num.charAt(i)-'0');
                map[digit]++;                
            }
        }
        for(int i=10;i>-1;i--){
            if(map[i]!=0){
                return ""+i+i+i;
            }
        }
        return "";
    }
}