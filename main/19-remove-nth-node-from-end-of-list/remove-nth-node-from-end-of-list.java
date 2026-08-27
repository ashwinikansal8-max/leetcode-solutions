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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t=head,temp=head;
        int c=0;
        while(t!=null) 
        {
             c++;
             t=t.next;
        }
        int nth = c-n;
        if(nth==0) return head.next;

        while(nth-->1)
        temp = temp.next;
        

        temp.next = temp.next.next;
        return head;
    }
}