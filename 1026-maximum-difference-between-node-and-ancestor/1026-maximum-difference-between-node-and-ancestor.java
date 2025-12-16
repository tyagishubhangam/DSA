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
    int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        recurse(root);
        return maxDiff;
    }

    public int[] recurse(TreeNode root){
        if(root.left == null && root.right == null){
            return new int[]{root.val, root.val};
        }

        int[] leftMaxMin = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] rightMaxMin = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        if(root.left != null){
            leftMaxMin = recurse(root.left);
        }
        if(root.right != null){
            rightMaxMin = recurse(root.right);
        }
        int minChild = Math.min(leftMaxMin[1], rightMaxMin[1]);
        int maxChild = Math.max(leftMaxMin[0], rightMaxMin[0]);
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(minChild - root.val), Math.abs(maxChild - root.val)));
        int[] tmp = new int[2];
        tmp[0] = Math.max(root.val, maxChild);
        tmp[1] = Math.min(root.val, minChild);

        return tmp;
        

        
        
    }
    
}