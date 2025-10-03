/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hs = new HashMap<>();
        Node tmp = head;
        while(tmp != null){
            hs.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }

        for(Node x : hs.keySet()){
            if(x.next != null){
                hs.get(x).next = hs.get(x.next);
            }

            if(x.random != null){
                hs.get(x).random = hs.get(x.random);
            }
   
        }

        return hs.get(head);

    }
}