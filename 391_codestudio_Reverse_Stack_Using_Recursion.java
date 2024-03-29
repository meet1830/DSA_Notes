/* 
 * Reverse Stack Using Recursion
 
Reverse a given stack of integers using recursion.

Note:
You are not allowed to use any extra space other than the internal stack space used due to recursion.
You are not allowed to use the loop constructs of any sort available as handy. For example: for, for-each, while, etc. 
The only inbuilt stack methods allowed are:
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.

Input Format :
The first line of input contains an integer value N, denoting the size of the input Stack.

The second line contains N single space-separated integers, denoting the stack elements, where the last (Nth) element is the TOP most element of Stack.    

Constraints :
0 <= N <= 10^3
Where 'N' is the number of elements in the given stack.
Time Limit: 1 sec

Output Format :
N single space-separated integers in a single line, where the first integer denotes the TOP element of the reversed stack.

Sample Input 1 :
3
2 1 3
Sample Output 1 :
2 1 3
Explanation To Sample Input 1 :
First-line contains an integer 3 denotes the size of the input stack i.e N = 3.
Second-line contains 3 single space-separated integers i.e the elements of the stack.
alt text

Printing the reverse stack starting from the top element: 2 1 3.

Sample Input 2 :
2
3 2
Sample Output 2 :
3 2    

*/


import java.util.Stack;
// extension of the problem insert element at the bottom of the stack. here for reversing using recursion have to insert every element that is encountered at the bottom
public class Solution {
    static void insertAtBottom (Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        int num = st.pop();
        insertAtBottom(st, x);
        st.push(num);
    }
	public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int num = stack.pop();
        reverseStack(stack);
        
        insertAtBottom(stack, num);
	}
}
