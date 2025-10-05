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
        List<ListNode> li = new ArrayList<>();
        Stack<ListNode> st = new Stack<>();
        while(prev != null){
            while(!st.isEmpty() && st.peek().val <= prev.val){
                st.pop();
            }
            if(st.isEmpty()){
                li.add(prev);
            }
            st.push(prev);
            prev = prev.next;
        }
        ListNode res = new ListNode(0);
        ListNode hd = res;
        for(int i=li.size()-1;i>=0;i--){
            if(li.get(i) != null){
                res.next = li.get(i);
                res = res.next;
            }
        }
        res.next = null;
        return hd.next;
    }
}