/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        boolean check=false;
        ListNode slow=head , fast=head , s=head;

        if(head==null || head.next==null) return null;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow) {
                check=true;
                break;
        }
        }
        
        if(check==false) return null;

        while(s!=slow){
            s=s.next;
            slow=slow.next;
        }

        return s;

    }
    }
