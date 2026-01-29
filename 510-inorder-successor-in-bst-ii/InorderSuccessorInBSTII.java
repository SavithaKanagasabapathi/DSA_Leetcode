import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int val) {
        this.val = val;
    }
}

public class InorderSuccessorInBSTII {
    public static void main(String[] args) {
        Solution soln = new Solution();
        /*
         * Constructing the following BST:
         * 5
         * / \
         * 3 6
         * / \
         * 2 4
         */
        Node root = new Node(5);
        Node n3 = new Node(3);
        Node n6 = new Node(6);
        Node n2 = new Node(2);
        Node n4 = new Node(4);

        root.left = n3;
        n3.parent = root;
        root.right = n6;
        n6.parent = root;
        n3.left = n2;
        n2.parent = n3;
        n3.right = n4;
        n4.parent = n3;

        // Test Case 1: Successor of 3 (Has right child) -> Should be 4
        System.out.println(soln.inorderSuccessor(n3).val);

        // Test Case 2: Successor of 4 (No right child, climb up) -> Should be 5
        System.out.println(soln.inorderSuccessor(n4).val);

        // Test Case 3: Successor of 6 (Rightmost node) -> Should be null
        System.out.println(soln.inorderSuccessor(n6));

        // Test Case 1: -> Should be 3
        System.out.println(soln.inorderPredecessor(n4).val);

        // Test Case 2: -> Should be 4
        System.out.println(soln.inorderPredecessor(root).val);

        // Test Case 3: -> Should be null
        System.out.println(soln.inorderPredecessor(n2));
    }
}

class Solution {
    public Node inorderSuccessor(Node node) {
        // TC-O(H) and SC-O(1)
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    public Node inorderPredecessor(Node node) {
        // TC-O(H) and SC-O(1)
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            node = node.left;
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }
}