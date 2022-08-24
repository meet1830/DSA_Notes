/* 
 * 160. Intersection of Two Linked Lists
Easy

10749

989

Add to List

Share
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 

Constraints:

The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
1 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA < m
0 <= skipB < n
intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 

Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?

*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// brute -> taking every node and matching it with every other node from other list till nodes(not values) are same
// dont need to check here if one of or both the heads are null because constraints.
// O(m*n), O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode same = headA;
        
        while (same != null) {
            ListNode temp = headB;
            
            while (temp != null) {
                if (temp == same)
                    return same;
                
                temp = temp.next;
            }
            
            same = same.next;
        }
        
        return null;
    }
}


// better -> hashing -> save all nodes of list 1 in set and while traversing second list if found same node then return
// O(m+n), O(m)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        
        temp = headB;
        while (temp != null) {
            if (set.contains(temp))
                return temp;
            
            temp = temp.next;
        }
        
        return null;
    }
}



// optimal 1 -> traverse both the linkedlists simultanously and calculate their lengths. then travel the longer linkedlist by the difference in count basically making point both the pointers at the same number of node in the lists. then traverse both the lists simultanously and find for the intersecting node else return null.
// O(m+n) + O(m-n) + O(N), O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cnt1 = 0, cnt2 = 0;
        ListNode temp1 = headA, temp2 = headB;
        
        while (temp1 != null || temp2 != null) {
            if (temp1 != null) {
                cnt1++;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                cnt2++;
                temp2 = temp2.next;
            }
        }
        
        temp1 = headA;
        temp2 = headB;
        
        if (cnt1 > cnt2) {
            for(int i = 1; i <= cnt1 - cnt2; i++) {
                temp1 = temp1.next;
            }
        }
        else {
            for (int i = 1; i <= cnt2 - cnt1; i++) {
                temp2 = temp2.next;
            }
        }
        
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return null;
    }
}



// optimal 2 -> traverse both the lists simultaneously, if one of them becomes null, point them to the head of other list and continue traversing. same for the other. at this time they will point to the same number of node in their lists. continue traversing till the same node or else till null and return.
// intuition -> essentially finding out the difference between the number of nodes and overcoming the difference. 
// O(m+n), O(1)

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
        return a;
    }
}