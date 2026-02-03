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
        //Iterative - TC-O(N) and SC-O(1)
        // ListNode end = null, current = head;
        // while (current != null) {
        //     ListNode temp = current.next;
        //     current.next = end;
        //     end = current;
        //     current = temp;
        // }
        // return end;
        //i/p 1-2-3-null
        //end=null, current=1, temp=2, current.next=null, end=1-null, current=2
        //end=1-null, current=2, temp=3, current.next=1-null, end=2-1-null, current=3
        //3-2-1-null

        //Recursive - TC-O(N) and SC-O(N)
        if (head == null || head.next == null) {//last num
            return head;
        }
        ListNode end = reverseList(head.next);//recurse upto last
        head.next.next = head;
        head.next = null;
        return end;
        //i/p 1-2-3-null
        //recurse upto 3, return 3 as .next is null
        //recurse(2)-2.next.next=2
        //2.next=null, so finally head is 3-2-null
        //recurse(1)-3-2-1-null
    }
}