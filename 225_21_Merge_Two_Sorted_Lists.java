/* 
 * 21. Merge Two Sorted Lists
Easy

14260

1276

Add to List

Share
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

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

// brute -> using extra space (given in the question to return new linked list thereby using extra space)

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode head = merged;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                merged.next = new ListNode(list1.val);
                merged = merged.next;
                list1 = list1.next;
            }
            else {
                merged.next = new ListNode(list2.val);
                merged = merged.next;
                list2 = list2.next;
            }
        }
        while(list1 != null) {
            merged.next = new ListNode(list1.val);
            merged = merged.next;
            list1 = list1.next;
        }
        while(list2 != null) {
            merged.next = new ListNode(list2.val);
            merged = merged.next;
            list2 = list2.next;
        }
        return head.next;
    }
}




// optimal (not as per question) -> merging in place
// changing the pointers whenever needed
// O(m + n), O(1)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base cases
        if (l1 == null) 
            return l2;
        if (l2 == null) 
            return l1;
        
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        // saving the head to return
        ListNode resHead = l1;
        
        while (l1 != null && l2 != null) {
            ListNode temp = null;
            
            // reaching the element (temp) where its pointer is to be changed
            while (l1 != null && l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }
            
            // changing the pointer
            temp.next = l2;
            
            // swap 
            // the other list l2 now may contain elements which does not need changing pointers and may contain that need to change. to identify them treat the list same as l1 so that the same algo works for the second list
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        return resHead;
    }
}




// optimal -> merging in place -> changing pointers -> simple
// here taking res pointer to save head(can take any value to just initialize) and taking prev pointer to change pointers
// compares lists values and according to that prev points to that node (can be in the same list) and prev also moves ahead for the next iteration.
// at last if l1 or l2 any one of them becomes null then prev points to the other list that is not empty and as other elements need not to be compared returns res.next.
// under normal testcases iterates to min of size of both lists but if testcases like 1,1000 and 1,2,3,4,5 exist then will iterate m+n times.
// hence O(m + n), O(1)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode res = new ListNode(-1);
        ListNode prev = res;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                l2 = l2.next;
            }
            
            prev = prev.next;
        }
        
        if (l1 != null)
            prev.next = l1;
        else 
            prev.next = l2;
        
        return res.next;
    }
}