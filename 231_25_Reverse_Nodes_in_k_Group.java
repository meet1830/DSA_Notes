/* 
 * 25. Reverse Nodes in k-Group
Hard

8659

528

Add to List

Share
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        
        // saving head node to return at last
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = dummy, nex = dummy, pre = dummy;
        
        int count = 0;
        // counting length of the list
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        
        // creating groups and changing pointers
        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            
            pre = cur;
            count -= k;
        }
        
        return dummy.next;
    }
}