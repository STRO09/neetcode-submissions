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
    public boolean hasCycle(ListNode head) {
        if( head == null || head.next == null || head.next.next == null)
            return false;
        ListNode slow = head.next; 
        ListNode fast = head.next.next;

        while(!slow.equals(fast)) {
            if(slow.next==null) return false;
            if(fast.next == null || fast.next.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        } 
        return true;    
    }
}
