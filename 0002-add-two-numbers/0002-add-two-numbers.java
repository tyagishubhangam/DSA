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
        int carry = 0;
        while(n1 != null && n2 != null){
            int n = n1.val + n2.val + carry;
            carry = n/10;
            int data = n%10;
            li.add(data);
            n1 = n1.next;
            n2 = n2.next;
        }
        if(n1 == null && n2 != null){
            while(n2 != null){
                int data = (n2.val + carry)%10;
                li.add(data);
                carry = (n2.val + carry)/10;
                n2 = n2.next;
            }
            
        }else{
            if(n1 != null && n2 == null){
                while(n1 != null){
                    int data = (n1.val + carry)%10;
                    li.add(data);
                    carry = (n1.val + carry)/10;
                    n1 = n1.next;
                }
                
            }
        }
        if(carry != 0){
            li.add(carry);
        }
        ListNode head = new ListNode(li.get(0));
        ListNode tmp = head;
        for(int i=1;i<li.size();i++){
            ListNode mvr = new ListNode(li.get(i));
            tmp.next=mvr;
            tmp = mvr;
        }
        return head;
    }
}