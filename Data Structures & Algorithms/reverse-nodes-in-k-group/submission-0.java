class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode curr = head;
        ListNode start = head;
        ListNode prevGroupTail = null;

        while (true) {

            // 🔹 check if k nodes exist
            ListNode temp = curr;
            for (int i = 0; i < k; i++) {
                if (temp == null) return head;
                temp = temp.next;
            }

            // 🔹 reverse k nodes
            ListNode prev = null;
            ListNode point = curr;

            for (int i = 0; i < k; i++) {
                ListNode next = point.next;
                point.next = prev;
                prev = point;
                point = next;
            }

            // 🔹 connect previous group
            if (prevGroupTail == null) {
                head = prev; // new head after first reversal
            } else {
                prevGroupTail.next = prev;
            }

            // 🔹 connect current group tail to next
            start.next = point;

            // 🔹 move pointers forward
            prevGroupTail = start;
            start = point;
            curr = point;
        }
    }
}