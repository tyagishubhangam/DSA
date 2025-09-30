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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp = list1;
        ListNode tmp2 = list2;
        ListNode x = new ListNode(-1);
        ListNode head = x;
        while(tmp!= null && tmp2 != null){
            if(tmp.val <= tmp2.val){
                x.next = tmp;
                tmp = tmp.next;
            }else{
                x.next = tmp2;
                tmp2 = tmp2.next;
            }
            x = x.next;
        }
        if(tmp == null && tmp2 != null){
            x.next = tmp2;
        }else{
            if(tmp != null && tmp2 == null){
                x.next = tmp;
            }
        }

        return head.next;
    }
}