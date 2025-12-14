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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        List<List<Integer>> li = new ArrayList<>();
        Queue<TempNode> queue = new LinkedList<>();
        queue.offer(new TempNode(root, 0, 0));
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TempNode tmp = queue.poll();
                int row = tmp.row;
                int col = tmp.col;
                if(!mp.containsKey(col)){
                    mp.put(col, new TreeMap<>());
                }
                if(!mp.get(col).containsKey(row)){
                    mp.get(col).put(row, new PriorityQueue<>());
                }
                mp.get(col).get(row).offer(tmp.node.val);
                if(tmp.node.left != null){
                    queue.offer(new TempNode(tmp.node.left, row+1, col - 1));
                }
                if(tmp.node.right != null){
                    queue.offer(new TempNode(tmp.node.right, row+1, col + 1));
                }
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> tm : mp.values()){
            List<Integer> vals = new ArrayList<>();
            for(PriorityQueue<Integer> pq : tm.values()){
                while(!pq.isEmpty()){
                    vals.add(pq.poll());
                }
            }
            li.add(new ArrayList<>(vals));
        }

        return li;
    }
}

class TempNode{
    TreeNode node;
    int row;
    int col;
    TempNode(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}