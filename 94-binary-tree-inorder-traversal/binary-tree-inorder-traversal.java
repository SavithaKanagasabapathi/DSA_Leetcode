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
    public List<Integer> inorderTraversal(TreeNode root) {
        //TC-O(N) and SC-O(H), H is logn for complete, n for skewed - recursion depth
        //Inorder - Left->Root->Right
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }
}