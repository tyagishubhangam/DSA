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
    public int pairSum(ListNode head) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        ListNode tmp = head;
        int idx = 0;
        while(tmp != null){
            hs.put(idx, tmp.val);
            tmp = tmp.next;
            idx++;
        }

        int maxSum = Integer.MIN_VALUE;
        int l = 0;
        int r = idx-1;
        while(l < r){
            maxSum = Math.max(maxSum, hs.get(l)+hs.get(r));
            l++;
            r--;
        }

        return maxSum;
    }
}