/* 
 * Sort a Stack
You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.
We can only use the following functions on this stack S.
is_empty(S) : Tests whether stack is empty or not.
push(S) : Adds a new element to the stack.
pop(S) : Removes top element from the stack.
top(S) : Returns value of the top element. Note that this function does not remove elements from the stack.

Note :
1) Use of any loop constructs like while, for..etc is not allowed. 
2) The stack may contain duplicate integers.
3) The stack may contain any integer i.e it may either be negative, positive or zero.

Input Format:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow.

The first line of each test case contains an integer 'N', the number of elements in the stack.

The second line of each test contains 'N' space separated integers.

Output Format:
The only line of output of each test case should contain 'N' space separated integers denoting the stack in a sorted order.

Note :
You do not need to print anything, it has already been taken care of. Just implement the given function. 

Constraints:
1 <= 'T' <= 100
1 <=  'N' <= 100
1 <= |'V'| <= 10^9
Where |V| denotes the absolute value of any stack element.
Time limit: 1 sec

Sample Input 1:
1
5
5 -2 9 -7 3
Sample Output 1:
9 5 3 -2 -7
Explanation Of Sample Input 1:
9 Is the largest element, hence it’s present at the top. Similarly 5>3, 3>-2 and -7 being the smallest element is present at the last. 

Sample Input 2:
1
5
-3 14 18 -5 30
Sample Output 2:
30 18 14 -3 -5
Explanation Of Sample Input 2:
30 is the largest element, hence it’s present at the top. Similarly, 18>14, 14>-3 and -5 being the smallest element is present at the last. 
*/


import java.util.*;

// insert an element in stack in sorted order. apply this to every element in stack
public class Solution {
    static void insertSorted (Stack<Integer> st, int x) {
        if (st.isEmpty() || (!st.isEmpty() && st.peek() < x)) {
            st.push(x);
            return;
        } 
        int num = st.pop();
        insertSorted(st, x);
        st.push(num);
    }
	public static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
            return;
        }
        int num = stack.pop();
        sortStack(stack);
        insertSorted(stack, num);
	}

}