/* 
 * 206. Reverse Linked List
Easy

13987

243

Add to List

Share
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
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

// optimal -> 3 pointers iterative

class Solution {
    public ListNode reverseList(ListNode head) {
        // no base cases needed
        ListNode curr = head, prev = null, next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // return prev;
        head = prev;
        return head; 
    }
}


// optimal -> iterative

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        
        // return newHead;
        head = newHead;
        return head;
    }
}


// optimal -> recursive
// base first one if input is null and second for stopping recursion
// reaching to the last node
// will run only from second last node because recursion has stopped at if condition for last node
// pointing the next of the current to itself -> reversing the pointer
// and in second line cutting the previous pointer which was original 

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode newHead = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}
