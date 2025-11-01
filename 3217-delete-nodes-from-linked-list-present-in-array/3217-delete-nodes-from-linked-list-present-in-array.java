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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        while(hs.contains(head.val)){
            head = head.next;
        }
        ListNode tmp = head;
        ListNode prev = null;
        while(tmp != null){
            
            if(hs.contains(tmp.val)){
                prev.next = tmp.next;
            }else{
                prev = tmp;
            }
            tmp = tmp.next;
        }
        return head;
    }
}