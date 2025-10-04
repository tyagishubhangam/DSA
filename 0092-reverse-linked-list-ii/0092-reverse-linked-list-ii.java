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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tmp = head;
        int len = 0;
        List<Integer> li = new ArrayList<>();
        ListNode start = null;
        while(tmp != null && len <= right-1){
            len++;
            if(len >= left){
                if(start == null && len == left){
                    start = tmp;
                }
                li.add(tmp.val);
            }
            tmp = tmp.next;
        }
        int idx = li.size()-1;
        while(idx >= 0){
            start.val = li.get(idx);
            idx--;
            start = start.next;
        }

        return head;
    }
}