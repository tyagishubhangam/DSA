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
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        recurse(str, root);
        return str.toString();
    }

    public void recurse(StringBuilder str, TreeNode root){
        if(root == null){
            return;
        }
        str.append(root.val);
        if(root.left == null && root.right == null){
            return;
        }
        str.append("(");
        recurse(str, root.left);
        str.append(")");
        if(root.right != null){
            str.append("(");
            recurse(str, root.right);
            str.append(")");
        }

        
    }
}