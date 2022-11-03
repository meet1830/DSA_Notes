/* 
 * 142. Linked List Cycle II
Medium

8548

590

Add to List

Share
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?
*/


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

// brute -> hashing - O(n), O(n)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        
        while (node != null) {
            if (set.contains(node))
                return node;
            
            set.add(node);
            
            node = node.next;
        }
        
        return null;
    }
}



// optimal -> slow and fast pointers -> after the slow and fast pointers have collided, use a dummy node at head and move it and slow pointer together. where they both collide is the starting node. if fast reaches null, return null
// O(N), O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        
        ListNode slow = head, fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                ListNode temp = head;
                
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                
                return slow;
            }
        }
        
        return null;
    }
}