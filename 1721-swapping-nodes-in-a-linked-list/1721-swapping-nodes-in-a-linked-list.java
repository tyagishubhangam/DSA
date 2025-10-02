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
        ListNode first = null;
        int len = 0;
        ListNode tmp = head;
        while(tmp != null){
            len++;
            if(len == k){
                first = tmp;
            }
            tmp = tmp.next;
        }

        tmp = head;
        int len2 = 0;
        ListNode last = null;
        while(tmp != null){
            len2++;
            if(len2 == len - k+1){
                last = tmp;
                break;
            }
            tmp = tmp.next;
        }

        int x = first.val;
        first.val = last.val;
        last.val = x;
        return head;
    }
}