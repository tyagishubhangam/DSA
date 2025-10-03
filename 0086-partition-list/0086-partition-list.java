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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode tmp = head;
        ListNode headLeft = left;
        ListNode headRight = right;
        while(tmp != null){
            if(tmp.val < x){
                left.next = tmp;
                left = left.next;
            }else{
                right.next = tmp;
                right = right.next;
            }
            tmp = tmp.next;
        }
        right.next = null;
        left.next = headRight.next;
        right.next = null;
        return headLeft.next;
        
    }
}