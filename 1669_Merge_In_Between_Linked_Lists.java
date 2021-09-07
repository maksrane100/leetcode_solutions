///////////////////////////////////////////
//1669. Merge In Between Linked Lists
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        
        ListNode h1 = list1;
        
        ListNode prev1 = null; 
        ListNode curr1 = list1;
        
        
        int i = 0;
        
        while(i < a) {
            prev1 = curr1;
            curr1 = curr1.next;
            i++;
        }       
        
        prev1.next = list2;
              
        i = 0;
        
        while(i <= b-a) {
            prev1 = curr1;
            curr1 = curr1.next;
            i++;
        }

        prev1.next = null;
        
        ListNode prev2 = null; 
        ListNode curr2 = list1;
        
        while(curr2 != null) {
            prev2 = curr2;
            curr2 = curr2.next;
        }
        
        prev2.next = curr1;
        
        return h1;
    }
}