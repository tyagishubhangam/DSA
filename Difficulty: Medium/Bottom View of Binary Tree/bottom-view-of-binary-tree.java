/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<TempNode> queue = new LinkedList<>();
        queue.offer(new TempNode(root, 0));
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TempNode t = queue.poll();
                int col = t.col;
                
                    mp.put(col,t.node.data);
                
                if(t.node.left != null){
                    queue.offer(new TempNode(t.node.left, col - 1));
                }
                if(t.node.right != null){
                    queue.offer(new TempNode(t.node.right, col + 1));
                }
            }
        }
        ArrayList<Integer> li = new ArrayList<>();
        for(int i : mp.values()){
            li.add(i);
        }
        return li;
        
    }
}

class TempNode{
    Node node;
    int col;
    TempNode(Node root, int col){
        this.node = root;
        this.col = col;
    }
}