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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            prev = slow;
        }

        while(slow != null){
            ListNode nxt = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nxt;
        }
        
        int ans = 0;
        ListNode tmp = head;
        while(prev != tmp){
            ans = Math.max(ans, tmp.val + prev.val);
            prev = prev.next;
            tmp = tmp.next;
        }

        return ans;
    }
}