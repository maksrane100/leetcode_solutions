///////////////////////////////////////////
//61. Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null) {
            return head;
        }
        
        ListNode curr = head;        
        ListNode first = head;
        ListNode second = head;
        
        int i = 0;
        
        while(i < k) {
            // when k is greater than length of the list
            // we need to connect second back to the head
            if(second.next==null) {
                second=head;
            } else {
                second = second.next;
            }
            i++;
        }
        
        while(second.next!=null) {
            first = first.next;
            second = second.next;
        }
        
        second.next=head;
        head=first.next;
        first.next=null;
        
        return head;
        
    }
}