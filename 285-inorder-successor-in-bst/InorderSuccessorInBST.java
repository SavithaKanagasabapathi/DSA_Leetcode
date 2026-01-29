import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class InorderSuccessorInBST {
    public static void main(String[] args) {
        Solution soln = new Solution();
        /*
         * Constructing the following BST:
         * 20
         * / \
         * 10 30
         * / \
         * 5 15
         */
        TreeNode root = new TreeNode(20);
        TreeNode n10 = new TreeNode(10);
        TreeNode n30 = new TreeNode(30);
        TreeNode n5 = new TreeNode(5);
        TreeNode n15 = new TreeNode(15);

        root.left = n10;
        root.right = n30;
        n10.left = n5;
        n10.right = n15;

        // Test Case 1: Successor of 15 -> Should be 20
        // (15 has no right child, climb up until we find node where we turned left)
        System.out.println(soln.inorderSuccessor(root, n15).val);

        // Test Case 2: Successor of 10 -> Should be 15
        // (10 has a right child, find leftmost of that subtree)
        System.out.println(soln.inorderSuccessor(root, n10).val);

        // Test Case 3: Successor of 30 -> Should be null
        System.out.println(soln.inorderSuccessor(root, n30));

        // Predecessor of 15 is 10
        System.out.println(soln.inorderPredecessor(root, n15).val);

        // Predecessor of 20 is 15
        System.out.println(soln.inorderPredecessor(root, root).val);
    }
}

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // TC-O(H) and SC-O(1)
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // TC-O(H) and SC-O(1)
        TreeNode predecessor = null;
        while (root != null) {
            if (p.val > root.val) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predecessor;
    }
}