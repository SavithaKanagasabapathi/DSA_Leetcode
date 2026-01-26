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
    public int maxLevelSum(TreeNode root) {
        //TC-O(N) and SC-O(W), W is width - For Level traverse, storing width of each level in deque
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int currentLevel = 1, maxLevel = 1, maxSum = Integer.MIN_VALUE;
        //Give MIN_VALUE, else wrong ans for -ve i/p
        while (!deque.isEmpty()) {
            int currentSum = 0, size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                currentSum += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = currentLevel;
            }
            currentLevel++;
        }
        return maxLevel;
    }
}