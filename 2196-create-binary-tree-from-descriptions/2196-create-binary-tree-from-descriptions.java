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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        HashMap<Integer, int[]> mp = new HashMap<>();
        HashSet<Integer> parentSet = new HashSet<>();
        HashSet<Integer> childSet = new HashSet<>();
        for(int[] description : descriptions){
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];
            
            childSet.add(child);
            parentSet.add(parent);
            
            if(!mp.containsKey(parent)){
                mp.put(parent, new int[2]);
            }
            if(isLeft == 1){
                mp.get(parent)[0] = child; 
            }else{
                mp.get(parent)[1] = child;
            }
        }
        // System.out.println(hs);
        int par = 0;
        for(int i : parentSet){
            if(!childSet.contains(i)){
                par = i;
                break;
            }
        }
        return constructTree(par, mp);
        
    }

    public TreeNode constructTree(int parent, HashMap<Integer, int[]> mp){
        if( parent == 0){
            return null;
        }

        TreeNode root = new TreeNode(parent);
        if(!mp.containsKey(parent)){
            return root;
        }
        TreeNode left = constructTree(mp.get(parent)[0], mp);
        TreeNode right = constructTree(mp.get(parent)[1], mp);
        root.left = left;
        root.right = right;
        
        return root;
    }
}