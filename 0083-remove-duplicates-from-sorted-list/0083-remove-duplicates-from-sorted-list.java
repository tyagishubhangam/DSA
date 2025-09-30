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
    public ListNode deleteDuplicates(ListNode head) {
        
        while(head != null && head.next != null && head.val == head.next.val){
            head.next = head.next.next;
        }
        ListNode tmp = head;
        while(tmp != null){
            while(tmp != null && tmp.next != null && tmp.val == tmp.next.val){
                tmp.next = tmp.next.next;
            }

            tmp = tmp.next;
        }

        return head;
    }
}