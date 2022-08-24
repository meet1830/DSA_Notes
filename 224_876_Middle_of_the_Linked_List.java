/* 
 * 876. Middle of the Linked List
Easy

6579

173

Add to List

Share
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100

*/



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

 
// brute -> get no of nodes traversing once and again traverse for n/2 to find middle node

class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        
        temp = head;
        for (int i = 0; i < count / 2; i++) 
            temp = temp.next;
        
        return temp;
    }
}



// optimal -> use slow and fast pointers move until fast pointer cannot move ahead and slow pointer will point to the middle of the list. in case of list containing even no of nodes, move until fast.next is not equal to null.

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;
        
        ListNode slow = head, fast = head;
        
        while (true) {
            if(fast.next != null)
                slow = slow.next;
            if(fast.next == null || fast.next.next == null)
                break;
            
            fast = fast.next.next;
        } 
        
        return slow;
    }
}
