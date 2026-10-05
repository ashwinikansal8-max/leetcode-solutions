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
    public ListNode modifiedList(int[] nums, ListNode head) {

        if(head==null) return head;

        HashSet<Integer> hs = new HashSet<>();
         for (int x : nums) {
            hs.add(x);   
        }

        ListNode d = new ListNode(-1,null);

        ListNode curr=head,prev=d;
        while(curr!=null)
        {
            if(hs.contains(curr.val)){
                prev.next = curr.next;
                curr=curr.next;
            }
            else{
            prev.next=curr;
            prev=curr;
            curr=curr.next;
            }
        }
        
        d=d.next;
        return d;
    }
}