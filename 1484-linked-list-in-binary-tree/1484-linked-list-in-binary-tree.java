/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static boolean checkFromCurrent(TreeNode node, ListNode head){
        if (head == null) return true;
        if(node == null) return false;
        if(head.val != node.val)  return false;
        return checkFromCurrent(node.left,head.next) || checkFromCurrent(node.right, head.next);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null)    return false;
        return checkFromCurrent(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}