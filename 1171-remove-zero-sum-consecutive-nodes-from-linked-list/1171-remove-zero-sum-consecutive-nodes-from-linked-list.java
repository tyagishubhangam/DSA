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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> hs = new HashMap<>();
        ListNode tmp = new ListNode((int)-1e8);
        tmp.next = head;
        int sum = 0;
        hs.put(0, tmp);
        ListNode x = tmp;
        tmp = tmp.next;
        while(tmp != null){
            sum += tmp.val;
            if(hs.containsKey(sum)){
                ListNode prev = hs.get(sum);
                int tmpSum = sum;
                prev = prev.next;
                while(prev != tmp){
                    tmpSum += prev.val;
                    hs.remove(tmpSum);
                    prev = prev.next;
                }
                hs.get(sum).next = tmp.next;
                
            }else{
                hs.put(sum, tmp);
            }
            tmp = tmp.next;
        }

        return x.next;
    }
}