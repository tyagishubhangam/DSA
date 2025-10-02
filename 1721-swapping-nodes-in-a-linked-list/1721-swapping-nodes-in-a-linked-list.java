/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        HashMap<Integer, ListNode> hs = new HashMap<>();
        
        int len = 0;
        ListNode tmp = head;
        while(tmp != null){
            len++;
            hs.put(len, tmp);
            tmp = tmp.next;
        }
        
        

        int x = hs.get(k).val;
        hs.get(k).val = hs.get(len - k + 1).val;
        hs.get(len -k +1).val = x;
        return head;
    }
}