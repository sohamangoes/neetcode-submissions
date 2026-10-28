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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null) return null;

        head = reverseList(head);

        if(n == 1) {
            head = head.next;
            return reverseList(head);
        }

        ListNode itr = head;
        for(int i = 1; i < n-1; i++) {
            itr = itr.next;
        }
        
        if(itr != null) {
            ListNode temp = itr.next;
            if(temp != null) {
                itr.next = temp.next;
            }
        }        

        return reverseList(head);
    }

    private ListNode reverseList(ListNode head) {

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
