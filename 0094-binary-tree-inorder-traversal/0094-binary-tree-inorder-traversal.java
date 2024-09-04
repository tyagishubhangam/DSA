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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        inOrder(root, li);
        return li;
    }
    public void inOrder(TreeNode res, List<Integer> li){
        if(res == null){
            return;
        }
        inOrder(res.left,li);
        li.add(res.val);
        inOrder(res.right,li);
    }
}