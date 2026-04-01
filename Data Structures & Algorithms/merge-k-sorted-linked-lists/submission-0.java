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
    Map<Integer, Integer> map = new TreeMap<>(); 
    ListNode newHead = new ListNode(0);
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode curr = null;
        for(ListNode node : lists) { 
            curr = node;
            while(curr!=null) {
                map.put(curr.val, map.getOrDefault(curr.val,0)+1);
                curr = curr.next;
            }
        }
        curr = newHead;
        for(Map.Entry<Integer, Integer> entries : map.entrySet()) { 
            for(int i=0; i < entries.getValue(); i++) {
                curr.next = new ListNode(entries.getKey());
                curr = curr.next;
            }
        }
        return newHead.next;
    }
}
