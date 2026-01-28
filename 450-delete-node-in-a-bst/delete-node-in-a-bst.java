/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        //TC-O(H) and SC-O(H), complete - log n, skewed - n
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            //For leaf or one child, 
            //if leaf, it will return null to parent, if 1 child, return that child to parent
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //For both children,
            root.val = findSuccessor(root.right).val;//set successor to root val
            root.right = deleteNode(root.right, root.val);//delete successor
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}