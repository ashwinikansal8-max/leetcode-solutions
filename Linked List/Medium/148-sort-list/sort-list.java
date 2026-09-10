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

    ListNode merge(ListNode h1,ListNode h2)
    {
        if(h2==null) return h1;
        if(h1==null) return h2;
        if(h1==null && h2==null) return null;

        ListNode h3,t;
        if(h1.val<=h2.val)
        {
            h3=t=h1;
            h1=h1.next;
        }
        else{
            h3=t=h2;
            h2=h2.next;
        }

        while(h1!=null && h2!=null)
        {
            if(h1.val<=h2.val)
            {
                t.next=h1;
                t=t.next;
                h1=h1.next;
            }
            else{
                t.next=h2;
                t=t.next;
                h2=h2.next;
            }
        }

        if(h1!=null) t.next=h1;
        else t.next=h2;
       
        return(h3); 
    }


    ListNode center(ListNode h){
        if(h==null || h.next==null) return h;
        ListNode slow=h, fast=h;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode c=center(head);
        ListNode h1=head, h2=c.next;
        c.next=null;

        h1= sortList(h1);
        h2= sortList(h2);
        return merge(h1,h2);
    }
}