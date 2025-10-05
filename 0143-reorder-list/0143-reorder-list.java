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
    public void reorderList(ListNode head) {
        if(head.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast!=null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode prev2 = null;
        while(slow != null){
            ListNode nxt = slow.next;
            slow.next = prev2;
            prev2 = slow;
            slow = nxt;
        }
        
        ListNode tmp = head;
        ListNode cc = null;
        
        while(tmp != null){
            ListNode nxt = tmp.next;
            tmp.next = prev2;
            prev2 = prev2.next;
            tmp.next.next = nxt;
            cc = tmp.next;
            tmp = tmp.next.next;
        }
        if(prev2 != null){
            cc.next = prev2;
        }

        

    }
}