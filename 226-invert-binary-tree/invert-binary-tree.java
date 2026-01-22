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
    public TreeNode invertTree(TreeNode root) {
        //TC-O(N) and SC-O(H), H is logn for complete, n for skewed - recursion depth
        if (root != null) {
            TreeNode invertedRight = invertTree(root.right);
            TreeNode invertedLeft = invertTree(root.left);
            root.left = invertedRight;//Direct invert and assign will change value, so temp used above
            root.right = invertedLeft;
        }
        return root;
    }
}