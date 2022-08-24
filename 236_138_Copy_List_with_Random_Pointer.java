/* 
 * 138. Copy List with Random Pointer
Medium

9570

1052

Add to List

Share
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 

Constraints:

0 <= n <= 1000
-10^4 <= Node.val <= 10^4
Node.random is null or is pointing to some node in the linked list.
*/



/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// brute -> create deepcopies of key list nodes in a hashmap as values. Perform same operations as found on the input list through hashmap.
// O(n + n), O(n) -> (for hashmap)

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        
        temp = head;
        
        while (temp != null) {
            if (temp.next != null)
                map.get(temp).next = map.get(temp.next);
                
            if (temp.random != null)
                map.get(temp).random = map.get(temp.random);
                
            temp = temp.next;
        }
        
        return map.get(head);
    }
}



/*
optimal ->  three steps
1. create copies of each node besides the original ones in input list changing next pointers, so next pointers are done
2. assign random pointers same as input list but for the copy nodes
3. input list is changed. hence restore original linkedlist and extract deepcopy linkedlist
O(n + n + n), O(1)
*/

class Solution {
    public Node copyRandomList(Node head) {
        // step 1
        Node curr = head, nex = head;
        
        while (curr != null) {
            nex = curr.next;
            
            Node copy = new Node(curr.val);
            
            curr.next = copy;
            copy.next = nex;
            
            curr = nex;
        }
        
        
        // step 2
        curr = head;
        
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            
            curr = curr.next.next;
        }
        
        
        // step 3
        Node saveHead = new Node(0), copy = saveHead;
        curr = head; 
        
        while (curr != null) {
            nex = curr.next.next;
            
            // extract copy
            copy.next = curr.next;
            copy = copy.next;
            
            // restore original ll
            curr.next = nex;
            
            curr = nex;
        }
        
        return saveHead.next;
    }
}
