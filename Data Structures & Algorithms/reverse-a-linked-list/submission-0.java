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

        Stack<ListNode> stack = new Stack<>();
        ListNode itr = head;
        while(itr != null) {
            stack.push(itr);
            itr = itr.next;
        }

        head = stack.pop();
        itr = head;
        while(!stack.isEmpty()) {
            itr.next = stack.pop();
            itr = itr.next;
        }
        itr.next = null;

        return head;
    }
}
