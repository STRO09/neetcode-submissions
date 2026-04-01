class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        List<ListNode> order = new ArrayList<>();
        ListNode current = head;

        while(current != null) {
            order.add(current);
            current = current.next;
        }

        int i = 1;                      // start from second node
        int j = order.size() - 1;

        while(i <= j){
            head.next = order.get(j);
            head = head.next;
            j--;

            if(i > j) break;

            head.next = order.get(i);
            head = head.next;
            i++;
        }

        head.next = null;               // terminate list
    }
}