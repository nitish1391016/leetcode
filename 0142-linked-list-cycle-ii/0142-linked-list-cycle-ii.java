/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> map = new HashSet<>();
        ListNode prev = head;
        while(head!=null){
            map.add(head);
            head = head.next;
            if(map.contains(head)){
                return head;
            }
        }
        return null;
    }
}