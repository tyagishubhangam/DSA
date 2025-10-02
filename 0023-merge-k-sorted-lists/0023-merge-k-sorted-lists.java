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
    public ListNode mergeKLists(ListNode[] lists) {
        
        return divideAndMerge(0,lists.length - 1, lists);
    }
    public ListNode divideAndMerge(int s, int e, ListNode[] lists){
        if(s > e){
            return null;
        }
        if(s == e){
            return lists[s];
        }

        int mid = s+(e-s)/2;
        ListNode l1 = divideAndMerge(s, mid, lists);
        ListNode l2 = divideAndMerge(mid+1, e, lists);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }

        l2.next = merge(l1, l2.next);
        return l2;
    }
}