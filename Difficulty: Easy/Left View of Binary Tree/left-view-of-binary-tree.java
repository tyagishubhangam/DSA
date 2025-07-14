/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> li = new ArrayList<>();
        recurse(root, 0, li);
        return li;
        
    }
    public static void recurse(Node root,int level, ArrayList<Integer> li){
        if(root == null){
            return;
        }
        if(level == li.size()){
            li.add(root.data);
        }
        recurse(root.left, level + 1, li);
        recurse(root.right, level + 1, li);
        

    }
}