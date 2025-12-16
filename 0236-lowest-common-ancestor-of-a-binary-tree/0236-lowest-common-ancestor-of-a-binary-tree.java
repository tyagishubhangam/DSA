/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tmp = recurse(root, p, q);
        return ans;
        
    }

    public TreeNode recurse(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            ans = root;
            return root;
        }

        TreeNode left = recurse(root.left, p, q);
        TreeNode right = recurse(root.right, p, q);
        if((left == p && right == q) || (left == q && right == p)){
            ans = root;
        }
        if(left == p || left == q){
            return left;
        }
        if(right == p || right == q){
            return right;
        }

        return null;
    }
}