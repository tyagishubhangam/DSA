/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> li = new ArrayList<>();
        li.add(node.data);
        if(isLeaf(node)){
            return li;
        }
        traverseLeft(node.left,li);
        traverseLeafs(node,li);
        traverseRight(node.right,li);
        return li;
        
    }
    
    public static void traverseLeft(Node root, ArrayList<Integer> li){
        Node tmp = root;
        while(tmp != null){
            if(!isLeaf(tmp)){
                li.add(tmp.data);
                
            }
            if(tmp.left != null){
                tmp = tmp.left;
            }else{
                tmp = tmp.right;
            }
        }
    }
    
    public static void traverseRight(Node root, ArrayList<Integer> li){
        Node tmp = root;
        ArrayList<Integer> rev = new ArrayList<>();
        while(tmp != null){
            if(!isLeaf(tmp)){
                rev.add(tmp.data);
            }
            if(tmp.right != null){
            tmp = tmp.right;
            }
            else{
                tmp = tmp.left;
            }
        }
        
        for(int i=rev.size()-1;i>=0;i--){
            li.add(rev.get(i));
        }
        
        
    }
    
    public static void traverseLeafs(Node root, ArrayList<Integer> li){
        if(root == null){
            return ;
        }
        
        if(isLeaf(root)){
            // System.out.println(root.data);
            li.add(root.data);
            return ;
           
        }
        
            traverseLeafs(root.left, li);
        
        
            traverseLeafs(root.right, li);
        
        
    }
    
    public static boolean isLeaf(Node root){
        if(root.left == null && root.right == null){
            return true;
        }
        
        return false;
    }
}