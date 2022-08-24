/* 
 * 234. Palindrome Linked List
Easy

10500

621

Add to List

Share
Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?

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

// brute -> Using an arraylist to store linkedlist values and checking if arraylist is palindrome or not

class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode p = head;
        
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1))
                return false;
        }
        
        return true;
    }
}



// optimal -> find the middle of the list, and reverse all the elements after list. with one dummy node on the head and one on after middle, compare till end. if interviewer tells not to modify the list then again reverse the second half and join it with the first half. approach without reverse function as separate

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        
        // finding middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reversing second half of linkedlist
        ListNode curr = slow.next, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // comparing both ll
        ListNode left = head, right = prev;
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}



// approach -> same as above with reverse function as separate
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        
        // finding middle node
        ListNode slow = head, fast = head;
        while (fast.next!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reversing the second half
        ListNode right = reverse(slow.next);
        
        // comparing
        ListNode left = head;
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode curr) {
        ListNode prev = null, next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}