class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int i = 0;
        while (i < n) {
            curr = stack.pop();  
            i++;
        }

        if (stack.isEmpty()) {
            return head.next;
        }

        ListNode prev = stack.peek();
        prev.next = curr.next;

        return head;
    }
}