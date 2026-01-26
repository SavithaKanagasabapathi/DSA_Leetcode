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
    public boolean isValidBST(TreeNode root) {
        //TC-O(N) and SC-O(H)
        return isValid(root, null, null);//root has no min/max
    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {
        //Integer instead of int is because it allow null.
        //If we give Integer.MIN_VALUE or MAX_VALUE, root with int max value 2147483647, 
        //will return false, as we are given root.val>=max return false.
        //That condition is for not allowing duplicates
        if (root == null) {
            return true;//if root null, it's a BST. So True.
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}