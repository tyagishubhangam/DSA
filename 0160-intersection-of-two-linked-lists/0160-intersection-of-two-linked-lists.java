/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hsA = new HashSet<>();
        HashSet<ListNode> hsB = new HashSet<>();
        ListNode hA = headA;
        while(hA != null){
            hsA.add(hA);
            hA = hA.next;
        }
        ListNode hB = headB;
        while(hB != null){
            hsB.add(hB);
            if(hsA.contains(hB)){
                return hB;
            }
            hB = hB.next;
        }

        return null;
    }
}