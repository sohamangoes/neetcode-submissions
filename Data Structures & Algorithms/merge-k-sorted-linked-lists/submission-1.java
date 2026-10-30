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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {

        if(start == end) {
            return lists[start];
        }

        if(start + 1 == end) {
            return merge(lists[start], lists[end]);
        }

        int mid = start + (end-start)/2;
        ListNode leftMerge = merge(lists, start, mid);
        ListNode rightMerge = merge(lists, mid + 1, end);
        return merge(leftMerge, rightMerge);
    }

    private ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode itr = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                itr.next = list1;
                list1 = list1.next;
            } else {
                itr.next = list2;
                list2 = list2.next;
            }
            itr = itr.next;
        }

        itr.next = list1 !=null ? list1 : list2;

        return dummy.next;
    }
}
