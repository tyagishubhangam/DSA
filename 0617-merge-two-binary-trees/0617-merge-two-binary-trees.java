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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        
        return merge(root1, root2);

        
    }

    public TreeNode merge(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return null;
        }
        TreeNode root = new TreeNode();
        int val = 0;
        if(root1 != null){
            val += root1.val;
        }
        if(root2 != null){
            val += root2.val;
        }
        root.val = val;
        TreeNode left = null;
        TreeNode right = null;
        if(root1 == null){
            left = merge(null, root2.left);
            right = merge(null, root2.right);
        }else{
            if(root2 == null){
                left = merge(root1.left, null);
                right = merge(root1.right, null);
            }else{
                left = merge(root1.left, root2.left);
                right = merge(root1.right, root2.right);
            }
        }

        
        
        
        root.left = left;
        root.right = right;

        return root;
    }
}