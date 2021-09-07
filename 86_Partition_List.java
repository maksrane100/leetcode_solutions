<<<<<<< HEAD
///////////////////////////////////////////
//86. Partition List
///////////////////////////////////////////

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
    public ListNode partition(ListNode head, int x) {
     
        ListNode curr=head;
        
        ListNode head1=new ListNode();
        ListNode head2=new ListNode();      

        ListNode prev1=head1;
        ListNode prev2=head2;
        
        while(curr!=null) {
            if(curr.val<x) {
                ListNode n1=new ListNode();
                n1.val=curr.val;
                prev1.next=n1;
                prev1=n1;
                
                
            } else  {
               ListNode n2=new ListNode();
                n2.val=curr.val;
                prev2.next=n2;
                prev2=n2;
            }
            
            curr=curr.next;
        }
        
        prev1.next=head2.next;
        
        return head1.next;
        
        
    }
=======
///////////////////////////////////////////
//86. Partition List
///////////////////////////////////////////

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
    public ListNode partition(ListNode head, int x) {
     
        ListNode curr=head;
        
        ListNode head1=new ListNode();
        ListNode head2=new ListNode();      

        ListNode prev1=head1;
        ListNode prev2=head2;
        
        while(curr!=null) {
            if(curr.val<x) {
                ListNode n1=new ListNode();
                n1.val=curr.val;
                prev1.next=n1;
                prev1=n1;
                
                
            } else  {
               ListNode n2=new ListNode();
                n2.val=curr.val;
                prev2.next=n2;
                prev2=n2;
            }
            
            curr=curr.next;
        }
        
        prev1.next=head2.next;
        
        return head1.next;
        
        
    }
>>>>>>> c9a657537c4a10962f5426954865bacce8125cd6
}