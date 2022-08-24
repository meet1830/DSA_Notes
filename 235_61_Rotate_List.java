/* 
 * 61. Rotate List
Medium

6060

1302

Add to List

Share
Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9
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

// brute -> traverse till end everytime
// O(n + k*n), O(1)

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        
        // calculate length of list
        ListNode temp = head;
        int l = 0;
        while (temp != null) {
            l++;
            temp = temp.next;
        }
        
        for (int i = 0; i < k % l; i++) {
            temp = head;
            while (temp.next.next != null)
                temp = temp.next;
            
            temp.next.next = head;
            head = temp.next;
            temp.next = null;
        }
        
        return head;
    }
}



// optimal -> convert into circular linked list. traverse the head to length - count times(rotate rightwards, if leftwards then just count) and point previous node to null 
// O(n + n - k%n), O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        
        // count ll length
        int l = 1;
        ListNode temp = head;
        while (temp.next != null) {
            l++;
            temp = temp.next;
        }
        
        // make circular ll -> 
        temp.next = head;
        
        // changing head after rotations
        ListNode prev = head;
        for (int i = 0; i < l - k % l; i++) {
            prev = head;
            head = head.next;
        }
        
        // pointing prev to null
        prev.next = null;
        
        return head;
    }
}