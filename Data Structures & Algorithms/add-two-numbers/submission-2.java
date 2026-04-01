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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode newhead = new ListNode(0);
        ListNode curr = newhead;
        while(l1!=null || l2!=null) {
            sum = carry;
            if(l1!=null) sum+=l1.val;
            if(l2!=null) sum+=l2.val;
            if(l1!=null)             l1 = l1.next;
            if(l2!=null)             l2 = l2.next;
            if(sum>9) curr.next = new ListNode(sum%10);
            else curr.next = new ListNode(sum);
            curr = curr.next;
            if(sum>9) carry = sum/10;
            else carry = 0;
        }
        if(carry!=0) curr.next = new ListNode(carry);
        return newhead.next;

    }
}
