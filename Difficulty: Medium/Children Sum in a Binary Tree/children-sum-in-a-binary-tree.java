/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        if(recurse(root)){
            return 1;
        }
        
        return 0;
    }
    
    public static boolean recurse(Node root){
        if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            return true;
        }
        int left = 0;
        if(root.left != null){
            left = root.left.data;
        }
        int right = 0;
        if(root.right != null){
            right = root.right.data;
        }
        
        if(left + right == root.data){
            return recurse(root.left) && recurse(root.right);
        }
        
        return false;
    }
}