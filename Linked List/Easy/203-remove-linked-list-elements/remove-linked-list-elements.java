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
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val) head=head.next;
        if(head==null) return head;
       

 ListNode t = head;
        while(t.next!=null) 
        {
              if(t.next.val==val) t.next=t.next.next;
              else t=t.next;
        }
return head;
    }
}