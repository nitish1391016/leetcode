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
    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode start = l1;
        ListNode prev = l1;
        int borrow = 0;
        while (l2 != null) {
            int res = l2.val + l1.val + borrow;
            borrow = 0;
            if (res > 9) {
                l1.val = res % 10;
                borrow = res / 10;
            } else
                l1.val = res;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + borrow;
            l1.val = sum % 10;
            borrow = sum / 10;
            prev = l1;
            l1 = l1.next;
        }
        if (borrow != 0) {
            prev.next = new ListNode(borrow);
        }
        return start;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = 0, length2 = 0;
        ListNode temp1 = l1;
        while (temp1 != null) {
            length1++;
            temp1 = temp1.next;
        }
        ListNode temp2 = l2;
        while (temp2 != null) {
            length2++;
            temp2 = temp2.next;
        }
        if (length1 < length2) {
            return add(l2, l1);
        }
        return add(l1, l2);
    }
}