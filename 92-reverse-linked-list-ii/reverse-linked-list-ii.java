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
    //TC-O(N) and SC-O(1)
    //dummy.next=head for edge case
    //prev=before left position
    //current=first left position
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {//left-1 as left is position, left-1 is index
            prev = prev.next;
        }
        ListNode current = prev.next;
        for (int i = 0; i < right - left; i++) {
            //prev=1, current=2, next=3
            ListNode next = current.next;//store next as we need to change next
            current.next = next.next;//point next most, 2.next=4
            next.next = prev.next;//3's next should be 2 so prev.next(tell everything as next)
            prev.next = next;//go for next element
        }
        return dummy.next;
    }
}