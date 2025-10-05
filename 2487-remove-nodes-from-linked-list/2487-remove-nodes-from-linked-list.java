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
    public ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        ListNode tmp = head;
        while(tmp != null){
            ListNode nxt = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = nxt;
        }
        ListNode res = new ListNode(0);
        ListNode hd = res;
        Stack<ListNode> st = new Stack<>();
        while(prev != null){
            while(!st.isEmpty() && st.peek().val <= prev.val){
                st.pop();
            }
            if(st.isEmpty()){
                res.next = prev;
                res = res.next;
            }
            st.push(prev);
            prev = prev.next;
        }
        res.next = null;
        prev = null;
        hd = hd.next;
        while(hd != null){
            ListNode nxt = hd.next;
            hd.next = prev;
            prev = hd;
            hd = nxt;
        }

        return prev;
    }
}