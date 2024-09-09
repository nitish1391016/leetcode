class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int left =0, right = n;
        int top=0, bottom = m;
        List<Integer> list = new LinkedList<Integer>();
        while(left<=right && top<=bottom){
            // System.out.println(left+" "+top+ " "+right+" "+bottom);
            for(int i=top, j= left; j<=right;j++){
                list.add(matrix[i][j]);
            }
            top++;
            for(int i=top,j=right; i<=bottom; i++){
                list.add(matrix[i][j]);
            }
            right--;
            if(top<=bottom) {
                for(int i=bottom,j=right;j>=left;j--){
                    list.add(matrix[i][j]);
                }
            }
            bottom--;
            if(left<=right)
                for(int i=bottom,j =left;i>=top;i--){
                    list.add(matrix[i][j]);
                }
            left++;
        }
        return list;
    }
}