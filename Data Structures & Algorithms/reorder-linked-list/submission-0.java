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
    public void reorderList(ListNode head) {
        if(head == null) return;

        int n = 0;
        ListNode itr = head;
        while(itr != null) {
            itr = itr.next;
            n++;
        }

        int mid = n%2 == 0? n/2 : n/2 + 1;
        itr = head;
        for(int i = 1; i < mid; i++) {
            itr = itr.next;
        }

        ListNode list2 = itr.next;
        itr.next = null;
        list2 = reverseList(list2);

        ListNode list1 = head;
        ListNode dummy = new ListNode(0);
        itr = dummy;
        for(int i = 1; i <=n; i++) {
            if(i%2 != 0) {
                itr.next = list1;
                list1 = list1.next;
            }else {
                itr.next = list2;
                list2 = list2.next;
            }
            itr = itr.next;
        }

        head = dummy.next;
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
