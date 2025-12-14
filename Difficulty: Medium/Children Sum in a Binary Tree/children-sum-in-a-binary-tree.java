/*
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
    public boolean isSumProperty(Node root) {
        //  code here
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        
        int leftVal = 0;
        int rightVal = 0;
        if(root.left != null){
            leftVal = root.left.data;
        }
        if(root.right != null){
            rightVal = root.right.data;
        }
        if(root.data != (rightVal + leftVal)){
            return false;
        }
        return isSumProperty(root.left) && isSumProperty(root.right);
        
        
        
    }
    
    
}