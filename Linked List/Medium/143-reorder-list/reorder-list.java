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

    ListNode center(ListNode head){
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    ListNode rev(ListNode head){
       ListNode h1=head,h2=null,t;
       while(h1!=null){
          t=h1;
          h1=h1.next;
          t.next=h2;
          h2=t; 
       }
       return h2;
    }
    public void reorderList(ListNode head) {
        ListNode c=center(head);
        ListNode list2=rev(c.next),list1=head,curr=head;
        ListNode curr2=list2;
        c.next=null;
        while(list2!=null){
            curr=curr.next;
            curr2=curr2.next;
            list1.next=list2;
            if(curr!=null) list2.next=curr;
            list1=curr; list2=curr2;
        }
        

    }
}