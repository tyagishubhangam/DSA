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
    public boolean isPalindrome(ListNode head) {
        List<Integer> li = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            li.add(tmp.val);
            tmp = tmp.next;
        }

        int l = 0;
        int r = li.size() - 1;
        while(l <= r){
            if(li.get(l) != li.get(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}