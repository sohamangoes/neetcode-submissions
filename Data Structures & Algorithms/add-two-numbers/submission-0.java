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
        int n1 = 0, n2 = 0;
        ListNode itr1 = l1, itr2 = l2;
        while(itr1 != null || itr2 != null) {

            if(itr1 != null) {
                n1 ++;
                itr1 = itr1.next;
            }

            if(itr2 != null) {
                n2 ++;
                itr2 = itr2.next;
            }
        }

        ListNode big, small;
        if(n1 > n2) {
            big = l1;
            small = l2;
        } else {
            big = l2;
            small = l1;
        }


        itr1=big;
        itr2=small;
        int carry = 0;
        while(itr1 != null && itr2 != null) {

            int sum = itr1.val + itr2.val + carry;
            itr1.val = sum % 10;
            carry = sum > 9 ? 1: 0;

            itr1 = itr1.next;
            itr2 = itr2.next;
        }

        while(itr1 != null) {

            int sum = itr1.val + carry;
            itr1.val = sum % 10;
            carry = sum > 9 ? 1: 0;

            itr1 = itr1.next;
        }

        if(carry == 1) {
            itr1 = big;
            while(itr1.next != null) {
                itr1 = itr1.next;
            }

            ListNode newNode = new ListNode(carry);
            itr1.next = newNode;
        }

        return big;
    }
}
