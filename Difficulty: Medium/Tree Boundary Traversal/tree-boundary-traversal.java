/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(root.data);
        if(root.left == null && root.right == null){
            return li;
        }
        traverseLeft(root.left, li);
        traverseLeafs(root, li);
        traverseRight(root.right, li);
        return li;
        
        
    }
    
    public static void traverseLeft(Node root, ArrayList<Integer> li){
        Node tmp = root;
        while(tmp != null){
            if(tmp.left != null || tmp.right != null){
                li.add(tmp.data);
            }
            
            if(tmp.left != null){
                tmp = tmp.left;
            }else{
                tmp = tmp.right;
            }
        }
        
        
    }
    
    public static void traverseLeafs(Node root, ArrayList<Integer> li){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            li.add(root.data);
        }
        traverseLeafs(root.left, li);
        traverseLeafs(root.right, li);
    }
    
    public static void traverseRight(Node root, ArrayList<Integer> li){
        Node tmp = root;
        List<Integer> demo = new ArrayList<>();
        while(tmp != null){
            if(tmp.left != null || tmp.right != null){
                demo.add(tmp.data);
            }
            if(tmp.right != null){
                tmp = tmp.right;
            }else{
                tmp = tmp.left;
            }
        }
        for(int i=demo.size() - 1;i>=0;i--){
            li.add(demo.get(i));
        }
    }
}