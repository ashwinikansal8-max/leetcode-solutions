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
        ListNode slow = head,fast=head;
        while(fast!=null && fast.next!=null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    ListNode rev(ListNode h1){
          ListNode h2=null,t;
          while(h1!=null){
            t=h1;
            h1=h1.next;
            t.next=h2;
            h2=t;
          }
          return h2;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode t=head;
        ListNode c = center(head);
        ListNode c2=c.next;
        c.next=null;

        ListNode sec = rev(c2);
        while(head!=null && sec!=null){
            if(head.val!=sec.val) return false;
            head=head.next;
            sec=sec.next;
        }
        return true;
    }
}