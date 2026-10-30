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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int i = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode itr = head;
        ListNode previousKTail = dummy;
        ListNode kHead = null;
        
        while(itr != null) {

            if(i%k == 0) {
                kHead = itr;
            }
            if(i%k == k-1) {
                ListNode next = itr.next;
                itr.next = null;

                ListNode[] reversed = reverse(kHead);
                ListNode rHead = reversed[0];
                ListNode rTail = reversed[1];

                previousKTail.next = rHead;
                rTail.next = next;

                previousKTail = rTail;
                itr = rTail;
            }

            itr = itr.next;
            i++;
        }

        return dummy.next;
    }

    private ListNode[] reverse(ListNode head) {

        if(head == null) return new ListNode[] {head, head};
        if(head.next == null) return new ListNode[] {head, head};

        ListNode itr = head;
        ListNode prev = null;
        while(itr!=null) {

            ListNode next = itr.next;
            itr.next = prev;
            prev = itr;
            itr = next;
        }

        return new ListNode[] { prev, head };
    }
}
