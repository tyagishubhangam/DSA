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
        int len = 0;
        ListNode tmp = head;
        ListNode kth = null;
        while(tmp != null){
            len++;
            if(len == k){
                kth = tmp;
                // System.out.println(tmp.val);
            }
            tmp = tmp.next;
        }
        tmp = head;
        // System.out.println(len);
        int x = 0;
        while(x < len){
            x++;
            if(x == len-k+1){
                
                break;
            }
            tmp = tmp.next;
        }
        // System.out.println(tmp.val);
        int val = kth.val;
        kth.val = tmp.val;
        tmp.val = val;
        return head;
    }
}