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
    public ListNode mergeNodes(ListNode head) {
       ListNode tmp = head.next;
       ListNode fresh = new ListNode(0);
       ListNode ans = fresh;
       int currSum = 0;
       while(tmp != null){
        currSum += tmp.val;
        if(tmp.val == 0){
            fresh.next = new ListNode(currSum);
            currSum = 0;
            fresh = fresh.next;
        }
        tmp = tmp.next;
       }

       return ans.next;

    }
}