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
    //TC-O(N) and SC-O(N), hashmap and recursion stack
    //preorder-root,left,right
    //postorder-left,right,root
    int preorderIndex;
    Map<Integer, Integer> postorderMap;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preorderIndex = 0;
        postorderMap = IntStream.range(0, postorder.length).boxed()
                .collect(Collectors.toMap(i -> postorder[i], i -> i));
        return arrayToTree(preorder, 0, postorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int start, int end) {
        if (start <= end && preorderIndex < preorder.length) {
            TreeNode root = new TreeNode(preorder[preorderIndex++]);
            if (start == end) {
                return root;//if leaf node, it won't have left, so next line will throw error
            }
            int leftRootIndex = postorderMap.get(preorder[preorderIndex]);
            root.left = arrayToTree(preorder, start, leftRootIndex);//include leftRootIndex
            root.right = arrayToTree(preorder, leftRootIndex + 1, end - 1);//end-1 as post last is root
            return root;
        }
        return null;
    }
}