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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //TC-O(N^2) and SC-O(H), N nodes and copying N length to result many times
        //H is height for recursion stack and currentPath storage
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        backtrack(result, currentPath, root, targetSum);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPath, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        currentPath.add(root.val);//add
        if (root.left == null && root.right == null && targetSum == root.val) {//leaf and check sum
            result.add(new ArrayList<>(currentPath));//create new ArrayList, 
            //if we add just currentPath, backtrack will modify the value, 
            //so create new copy and set to result.
        } else {
            backtrack(result, currentPath, root.left, targetSum - root.val);
            backtrack(result, currentPath, root.right, targetSum - root.val);
        }
        currentPath.remove(currentPath.size() - 1);//remove for backtrack
    }
}