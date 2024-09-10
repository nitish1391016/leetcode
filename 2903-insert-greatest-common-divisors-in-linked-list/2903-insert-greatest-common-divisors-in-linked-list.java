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
class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        int length =0;
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        if(length == 1)
            return head;
        temp = head;
        while(temp.next!=null){
            ListNode newnode = new ListNode(gcd(temp.val, temp.next.val), temp.next);
            temp.next = newnode;
            temp = newnode.next;
        }
        return head;
    }
}