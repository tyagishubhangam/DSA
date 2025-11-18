/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        postOrderTraversal(root, ans);
        return ans;
        
    }
    
    public static void postOrderTraversal(Node root, ArrayList<Integer> li){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left,li);
        postOrderTraversal(root.right, li);
        li.add(root.data);
    }
}