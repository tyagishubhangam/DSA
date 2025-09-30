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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tmp1 = list1;
        int idx = 0;
        ListNode nxt = null;
        while(a-1 != idx){
            
            tmp1 = tmp1.next;
            idx++;
            
        }
        nxt = tmp1.next;
        tmp1.next = list2;
        idx++;
        while(b != idx){
            nxt = nxt.next;
            idx++;
        }
        while(tmp1.next != null){
            tmp1 = tmp1.next;
        }
        tmp1.next = nxt.next;

        return list1;
    }
}