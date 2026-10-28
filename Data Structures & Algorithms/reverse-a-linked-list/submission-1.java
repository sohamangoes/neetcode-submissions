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
        if(head == null) return head;
        if(head.next == null) return head;

        ListNode itr = head;
        ListNode prev = null;
        while(itr != null) {
            ListNode next = itr.next;
            itr.next = prev;
            prev = itr;
            itr = next;
        }

        return prev;
    }
}
