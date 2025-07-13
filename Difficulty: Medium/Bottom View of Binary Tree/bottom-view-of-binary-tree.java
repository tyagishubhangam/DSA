/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,root));
        TreeMap<Integer, Integer> hs = new TreeMap<>();
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                Pair tmp = queue.poll();
                int pos = tmp.pos;
                hs.put(pos, tmp.node.data);
                if(tmp.node.left != null){
                    queue.offer(new Pair(pos - 1, tmp.node.left));
                }
                if(tmp.node.right != null){
                    queue.offer(new Pair(pos + 1, tmp.node.right));
                }
            }
        }
        for(int i:hs.keySet()){
            res.add(hs.get(i));
        }
        return res;
    }
}

class Pair{
    Node node;
    int pos;
    Pair(int pos, Node node){
        this.node = node;
        this.pos = pos;
    }
}
