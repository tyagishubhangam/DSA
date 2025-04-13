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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        List<Integer> li = new ArrayList<>();
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        int carry = 0;
        while(n1 != null || n2 != null || carry != 0){

            int n = 0;
            if(n1 != null){
                n += n1.val;
                n1 = n1.next;
            }
            if(n2 != null){
                n += n2.val;
                n2 = n2.next;
            }
            n += carry;
            int data = n%10;
            ListNode mvr = new ListNode(data);
            tmp.next = mvr;
            tmp = mvr;
            carry = n/10;
            
            
            
        }
        return res.next;
    }
}