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
    public List<List<Integer>> levelOrder(TreeNode root) {  if(root == null){
        return new ArrayList<>();
    }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> li = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode tr = queue.poll();
                tmp.add(tr.val);
                if(tr.left != null){
                    queue.offer(tr.left);
                }
                if(tr.right != null){
                    queue.offer(tr.right);
                }
            }
            li.add(tmp);
        }
        return li;
        
    }
}