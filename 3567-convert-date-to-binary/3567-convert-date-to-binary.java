class Solution {
    private static String getBinary(String s){
        int num = Integer.parseInt(s);
        String str = "";
        while(num>0){
            str=num%2+str;
            num/=2;
        }
        return str;
    }
    public String convertDateToBinary(String date) {
        return getBinary(date.substring(0,4))+"-"+getBinary(date.substring(5,7))+"-"+getBinary(date.substring(8,10));
    }
}