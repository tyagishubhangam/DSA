/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
    
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        TreeMap<Integer, Integer> hs = new TreeMap<>();
        while(!queue.isEmpty()){
            int n = queue.size();
            
            for(int i=0;i<n;i++){
                Pair tmp = queue.poll();
                int pos = tmp.pos;
                Node node = tmp.node;
                if(!hs.containsKey(pos)){
                    hs.put(pos, node.data);
                }
                if(node.left != null){
                    queue.offer(new Pair(node.left, pos - 1));
                }
                
                if(node.right != null){
                    queue.offer(new Pair(node.right, pos + 1));
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
    
    Pair(Node node, int pos){
        this.node = node;
        this.pos = pos;
    }
}

// class SortThePQ implements Comparator<Pair> {
//     public int compare(Pair p1, Pair p2){
//         return p1.pos-p2-pos;
//     }
// }