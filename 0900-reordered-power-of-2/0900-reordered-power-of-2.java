class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);

        for(int i=0;i<31;i++){
            int num = (1<<i);
            char [] powArray = (String.valueOf(num).toCharArray());
            Arrays.sort(powArray);
            if(Arrays.equals(powArray, digits))
                return true;
        }
        return false;
        
    }
}