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
        return recurse(root);
    }

    public static boolean recurse(TreeNode root){
        if(root == null){
            return true;
        }
        int lH = findHeight(root.left);
        int rH = findHeight(root.right);
        if(Math.abs(lH - rH) > 1){
            return false;
        }

        return recurse(root.left) && recurse(root.right);
    }

    public static int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    
}