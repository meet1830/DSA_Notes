/*
445. Add Two Numbers II

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

Example 2:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

Example 3:
Input: l1 = [0], l2 = [0]
Output: [0]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>();
        // adding values to both stacks
        ListNode temp = l1;
        while(temp != null) {
            st1.push(temp.val);
            temp = temp.next;
        }
        temp = l2;
        while(temp != null) {
            st2.push(temp.val);
            temp = temp.next;
        }
        // defining and adding sum as linkedlist returning tail value
        int carry = 0;
        temp = null;
        while(!st1.isEmpty() || !st2.isEmpty() || carry == 1) {
            int sum = carry;
            if(!st1.isEmpty()) {
                sum += st1.pop();
            }
            if(!st2.isEmpty()) {
                sum += st2.pop();
            }
            ListNode add = new ListNode(sum % 10);
            add.next = temp;
            temp = add;
            carry = sum / 10;
        }
        return temp;
    }
}
