class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) return null;
        
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        while (head != null && set.contains(head.val)) {
            head = head.next;
        }


        ListNode current = head;

        while (current != null && current.next != null) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}