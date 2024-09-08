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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        ListNode[] res = new ListNode[k];
        temp = head;
        for(int i=0;i<k;i++){
            int times = (n%k != 0)? 1: 0;
            int quotient = n / k;
            int reminder = n % k;
            times = quotient + ((i<reminder)?1:0);
            res[i] = head;
            if(head == null){
                res[i] = null;
                continue;
            }
            while(times-->0){
                temp = head;
                head = head.next;
            }
            temp.next = null;
        }
        return res;
    }
}