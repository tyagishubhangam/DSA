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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        if(root == null){
            return li;
        }
        int lvl = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode tmp = queue.poll();
                if(lvl == li.size()){
                    li.add(tmp.val);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                
            }
            lvl
            ++;
            
        }

        return li;
    }
}