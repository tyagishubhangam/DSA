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
    public boolean isBalanced(TreeNode root) {
        return heightDifference(root) !=-1;
    }

    public static int heightDifference(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightDifference(root.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = heightDifference(root.right);
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(rightHeight - leftHeight) > 1){
            return -1;
        }

        return (Math.max(leftHeight, rightHeight) + 1);
    }
}