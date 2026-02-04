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
        //Reverse - TC-O(M+N) and SC-O(max(m,n)) - result list space
        // ListNode rl1 = reverse(l1);
        // ListNode rl2 = reverse(l2);
        // ListNode dummy = new ListNode(0);
        // ListNode current = dummy;
        // int carryOver = 0;
        // while (rl1 != null || rl2 != null || carryOver != 0) {
        //     //sum=rl1+rl2+carryOver
        //     int sum = carryOver;
        //     if (rl1 != null) {
        //         sum += rl1.val;
        //         rl1 = rl1.next;
        //     }
        //     if (rl2 != null) {
        //         sum += rl2.val;
        //         rl2 = rl2.next;
        //     }
        //     carryOver = sum / 10;//tens place
        //     current.next = new ListNode(sum % 10);//ones place
        //     current = current.next;
        // }
        // return reverse(dummy.next);//reverse sum response

        //Stack - TC-O(M+N) and SC-O(M+N) - stack for both lists, result list space
        ListNode end = null;
        int carryOver = 0;
        Deque<Integer> dl1 = new ArrayDeque<>();
        Deque<Integer> dl2 = new ArrayDeque<>();
        while (l1 != null) {
            dl1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            dl2.push(l2.val);
            l2 = l2.next;
        }
        while (!dl1.isEmpty() || !dl2.isEmpty() || carryOver != 0) {
            //sum=dl1+dl2+carryOver
            int sum = carryOver;
            if (!dl1.isEmpty()) {
                sum += dl1.pop();//stack
            }
            if (!dl2.isEmpty()) {
                sum += dl2.pop();//stack
            }
            carryOver = sum / 10;//tens place
            ListNode node = new ListNode(sum % 10);//ones place
            node.next = end;
            end = node;//add in front
        }
        return end;
    }

    private ListNode reverse(ListNode node) {
        ListNode end = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = end;
            end = node;
            node = next;
        }
        return end;
    }
}