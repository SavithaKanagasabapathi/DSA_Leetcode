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
    int count = 0, result = 0;

    public int kthSmallest(TreeNode root, int k) {
        //TC-O(H+K) and SC-O(H), first we go leftmost and traverse k elements, H is height of tree
        count = k;
        inorderTraverse(root);
        return result;
    }

    private void inorderTraverse(TreeNode root) {
        //traverse left most and decrement count, if 0 - return that node val
        if (root == null || count == 0) {
            return;
        }
        inorderTraverse(root.left);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }
        inorderTraverse(root.right);
    }
}