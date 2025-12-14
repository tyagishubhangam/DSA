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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        
        return constructTree(0,n-1,nums);
        
        

        // return root;
    }

    public TreeNode constructTree(int l, int r, int[] nums){
        if(l > r){
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(l, mid - 1, nums);
        root.right = constructTree(mid + 1, r, nums);

        return root;
    }
}