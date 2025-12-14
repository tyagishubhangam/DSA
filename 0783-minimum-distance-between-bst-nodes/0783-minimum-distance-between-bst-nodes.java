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
    public int minDiffInBST(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        DFS(root, li);
        Collections.sort(li);
        for(int i=0;i<li.size()-1;i++){
            minDiff = Math.min(minDiff, li.get(i+1)-li.get(i));
        }

        return minDiff;
    }

    public void DFS(TreeNode root, List<Integer> li){
        if(root == null){
            return;
        }

        li.add(root.val);
        DFS(root.left, li);
        DFS(root.right, li);
    }
}