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

 //h2 = even 
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null) return head;
        ListNode h2=head.next,t2=h2,t1=head;

        while(t2!=null && t2.next!=null)
        {
             t1.next = t2.next;
             t1=t1.next;

             t2.next = t1.next;
             t2=t2.next;
        }
        
        
        t1.next = h2;
        return head;
    }
}