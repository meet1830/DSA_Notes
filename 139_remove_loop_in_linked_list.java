/*
Remove loop in Linked List
Given a linked list of N nodes such that it may contain a loop.
A loop here means that the last node of the link list is connected to the node at position X. If the link list does not have any loop, X=0.
Remove the loop from the linked list, if it is present.  

Example 1:
Input:
N = 3
value[] = {1,3,4}
X = 2
Output: 1
Explanation: The link list looks like
1 -> 3 -> 4
     ^    |
     |____|    
A loop is present. If you remove it 
successfully, the answer will be 1. 

Example 2:
Input:
N = 4
value[] = {1,8,3,4}
X = 0
Output: 1
Explanation: The Linked list does not 
contains any loop. 

Example 3:
Input:
N = 4
value[] = {1,2,3,4}
X = 1
Output: 1
Explanation: The link list looks like 
1 -> 2 -> 3 -> 4
|______________|
A loop is present. 
If you remove it successfully, 
the answer will be 1. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function removeLoop() which takes the head of the linked list as the input parameter. Simply remove the loop in the list (if present) without disconnecting any nodes from the list.
Note: The generated output will be 1 if your submitted code is correct.

Expected time complexity: O(N)
Expected auxiliary space: O(1)

Constraints:
1 ≤ N ≤ 10^4
*/

// Solution TC -> O(n), SC -> O(n)
// but passes all test cases

class Solution {
    // if linked list does not contain loop
    // then will not go into the loop and return
    public static void removeLoop(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node prev = null, temp = head;

        while (temp != null) {
            // if contains
            if (set.contains(temp)) {
                prev.next = null;
                return;
            }
            // if does not contain
            else {
                set.add(temp);
                prev = temp;
                temp = temp.next;
            }
        }

        return;
    }
}

class Solution {
    public static void removeLoop(Node head) {
        Node slow = head, fast = head;

        // floyd's algo to detect loop
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        // return if no loop detected
        if (fast != slow)
            return;

        // count no of nodes in loop
        int count = 1;
        Node p1 = slow, p2 = slow;
        while (p1.next != p2) {
            p1 = p1.next;
            count++;
        }

        // change positions of both pointers
        p1 = head;
        for (int i = 0; i < count; i++)
            p2 = p2.next;

        // move both pointers at same pace
        // they meet at starting node of loop
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // get one pointer to last node of loop
        while (p2.next != p1)
            p2 = p2.next;

        // set its next as null to remove loop
        p2.next = null;

        return;
    }
}