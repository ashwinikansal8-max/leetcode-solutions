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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;
        ListNode h1=head,h2=null,t,c=head;
        int n=k,check=0;

        while(c!=null && check<k)
        {
            c = c.next;
            check++;
        }

        if(check<k) return head;
        
        while(n-->0 && h1!=null)
        {
            t=h1;
            h1=h1.next;
            t.next=h2;
            h2=t;
        }
        
        head.next = reverseKGroup(h1,k);
        return h2;
    }
}