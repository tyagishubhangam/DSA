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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode evenHead = even;
        ListNode oddHead = odd;
        ListNode tmp = head;
        int cnt = 0;
        while(tmp != null){
            cnt++;
            if(cnt % 2 == 0){
                even.next = new ListNode(tmp.val);
                even = even.next;
            }else{
                odd.next = new ListNode(tmp.val);
                odd = odd.next;
            }

            tmp = tmp.next;
            
        }
        oddHead = oddHead.next;
        evenHead = evenHead.next;
        odd.next = evenHead;
        return oddHead;
    }
}