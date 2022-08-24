/* 
 * Flattening a Linked List
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer. For more clearity have a look at the printList() function in the driver code.

 

Example 1:

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every 
node in a single level.
(Note: | represents the bottom pointer.)
 

Example 2:

Input:
5 -> 10 -> 19 -> 28
|          |                
7          22   
|          |                 
8          50 
|                           
30              
Output: 5->7->8->10->19->22->28->30->50
Explanation:
The resultant linked lists has every
node in a single level.

(Note: | represents the bottom pointer.)
 

Your Task:
You do not need to read input or print anything. Complete the function flatten() that takes the head of the linked list as input parameter and returns the head of flattened link list.

 

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)

 

Constraints:
0 <= N <= 50
1 <= Mi <= 20
1 <= Element of linked list <= 103


*/


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */

// if every vertical list is treated as individual list, then the question becomes merge n sorted linked lists, similar to merge 2 sorted linked lists
// so same as question merge 2 sorted linked lists, we merge two of the lists, make them as a single list and return its head, and call recursion and merge the returned list to another list
class GfG
{
    Node mergeTwoLists(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;
        
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }
            else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if (a != null)
            temp.bottom = a;
        else 
            temp.bottom = b;
            
        return res.bottom;
    }
    
    Node flatten(Node root)
    {
        // base -> input is null or reached last node
        if (root == null || root.next == null) 
            return root;
            
        // recursion for list on right
        root.next = flatten(root.next);
        
        // now merge, will return node from prev merge as root.next and this node as root
        root = mergeTwoLists(root, root.next);
        
        // return root. it will be merged with its left
        return root;
    }
}