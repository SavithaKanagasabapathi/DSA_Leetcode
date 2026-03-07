/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        //TC-O(N) and SC-O(N)
        // if (head == null) {
        //     return head;
        // }
        // Map<Node, Node> map = new HashMap<>();
        // Node current = head;
        // while (current != null) {//only put in map (node and its copy)
        //     //why here itself, we are not assigning next and random copy is that 
        //     //we don't even create copies of coming next and random
        //     Node copy = new Node(current.val);
        //     map.put(current, copy);
        //     current = current.next;
        // }
        // current = head;
        // while (current != null) {
        //     Node copy = map.get(current);
        //     copy.next = map.get(current.next);//map it's copy next and random
        //     copy.random = map.get(current.random);
        //     current = current.next;
        // }
        // return map.get(head);

        //TC-O(N) and SC-O(N) - Recursion Stack
        // if (head == null) {
        //     return head;
        // }
        // Node current = head;
        // if (map.containsKey(current)) {
        //     return map.get(current);
        // }
        // Node copy = new Node(current.val);
        // map.put(current, copy);
        // copy.next = copyRandomList(current.next);//create copy and assign it
        // copy.random = copyRandomList(current.random);
        // return copy;

        //TC-O(N) and SC-O(1)
        //A-a-B-b-C-c, A original and a copy, A.random=C
        if (head == null) {
            return head;
        }
        Node current = head;
        while (current != null) {//construct this A-a-B-b-C-c
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = current.next.next;
        }
        current = head;
        while (current != null) {//assign copy random
            if (current.random != null) {//If random null, random.next will give error
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        current = head;
        Node copyHead = head.next;
        Node newCurrent = copyHead;
        while (current != null) {
            current.next = current.next.next;//current.next will be copy so no check needed
            if (newCurrent.next != null) {
                newCurrent.next = newCurrent.next.next;
            }
            current = current.next;//current.next changed so only next and not next.next
            newCurrent = newCurrent.next;
        }
        return copyHead;
    }
}