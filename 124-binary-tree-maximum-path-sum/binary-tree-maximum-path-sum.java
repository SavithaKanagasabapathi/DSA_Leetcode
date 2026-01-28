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
    //TC-O(N) and SC-O(H), height of tree for recursion
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxSumAndMaxPath(root);
        return maxSum;
    }

    private int getMaxSumAndMaxPath(TreeNode root) {
        //calculate maxSum and return maxPath to parent 
        if (root == null) {
            return 0;
        }
        //if negative, sum will be less, so better ignore negative 
        int leftGain = Math.max(0, getMaxSumAndMaxPath(root.left));
        int rightGain = Math.max(0, getMaxSumAndMaxPath(root.right));
        int currentPathSum = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPathSum);
        return root.val + Math.max(leftGain, rightGain);//which side is max, add that to root
    }
}