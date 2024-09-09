/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode list) {
        int row = m;
        int col = n;

        int[][] matrix = new int[m][n];
        if (row == 0 || col == 0) {
            return matrix;
        }
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        int ind = 0;
        int val =0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                val = -1;
                if(list!=null){
                    val = list.val;
                    list=list.next;
                }
                matrix[top][i] = val;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                val = -1;
                if(list!=null){
                    val = list.val;
                    list=list.next;
                }
                matrix[i][right] = val;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    val = -1;
                    if(list!=null){
                        val = list.val;
                        list=list.next;
                    }
                    matrix[bottom][i] = val;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    val = -1;
                    if(list!=null){
                        val = list.val;
                        list=list.next;
                    }
                    matrix[i][left] = val;
                }
                left++;
            }
        }
        return matrix;
    }
}