/*
19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

Follow up: Could you do this in one pass?

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

// brute -> find out length of list, and then iterate again to the node before the node to be deleted and delete that node

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // take two pointers or nodes. Iterate pointer n times making it point to the nth node and the other pointer still points to the first node. After that start iterating again and this time increment both pointers till second pointer points to the last element, making the first pointer pointing to the node to be deleted.
        // concept -> n steps needed for first pointer, size - n + 1 steps needed for second pointer to point the node to be deleted.
        
        ListNode first = head;
        ListNode second = head;
        for(int i = 0; i < n; i++) {
            // considering edge cases
            if(first.next == null) {
                // that means n is greater than size of list
                if(i == n - 1) {
                    // next is null and i is pointing to last node that means head is to be removed
                    head = head.next;
                }
                // return for case when n is greater than size of list
                return head;
            }
            first = first.next;
        }
        while(first.next != null) {
            second = second.next;
            first = first.next;
        }
        // deleting the node
        second.next = second.next.next;
        return head;
    }
}
