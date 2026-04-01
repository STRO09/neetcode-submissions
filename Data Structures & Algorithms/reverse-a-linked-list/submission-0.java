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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode current = head;
        Stack<ListNode> stack = new Stack<>();
        while(current!=null) {
            stack.push(current);
            current = current.next;
        }    
        ListNode newHead = stack.pop();
        current = newHead;
        while(!stack.isEmpty()) {
            current.next = stack.pop();
            current= current.next;
        }  
        current.next = null;
        return newHead;   
    }
}
