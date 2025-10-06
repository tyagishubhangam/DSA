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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        List<ListNode> li = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            li.add(tmp);
            tmp = tmp.next;
        }
        Collections.sort(li, (a,b)->a.val - b.val);
        ListNode x = li.get(0);
        tmp = x;
        for(int i=1;i<li.size();i++){
            tmp.next = li.get(i);
            tmp = tmp.next;
        }

        tmp.next = null;
        return x;
    }
}