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

        if(head==null) return head;
        Stack<Integer> nodeValues = new Stack<>();

        while(head!=null) { 
            nodeValues.push(head.val);
            head = head.next;
        }
        ListNode newHead = new ListNode(0); 
        ListNode curr = newHead; 
        while(!nodeValues.isEmpty()) {
            curr.next = new ListNode(nodeValues.pop());
            curr = curr.next;
        }
        return newHead.next;
    }
}
