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
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        traverse(root, null, targetSum);
        return res;
    }
    public void traverse(TreeNode root,Integer currSum, int targetSum){
        
        if(root == null){
            return;
        }
        if(currSum == null){
            currSum = 0;
        }
        if(root.left == null && root.right == null){
            if(currSum != null && currSum+root.val == targetSum){
                res = true;
                return ;
           
        }
        }
        
        traverse(root.left, currSum + root.val, targetSum);
        traverse(root.right, currSum+root.val, targetSum);
    }
}