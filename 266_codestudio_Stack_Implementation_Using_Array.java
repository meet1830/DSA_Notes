/* 
 * Stack Implementation Using Array
Stack is a data structure that follows the LIFO (Last in First out) principle. Design and implement a stack to implement the following functions:
1. Push(num): Push the given number in the stack if the stack is not full.
2. Pop: Remove and print the top element from the stack if present, else print -1.
3. Top: Print the top element of the stack if present, else print -1.
4. isEmpty: Print 1 if the stack is empty, else print 0.
5. isFull: Print 1 if the stack is full, else print 0.
You have been given ‘M’ operations which you need to perform in the stack. Your task is to implement all the functions of the stack.
Example:
We perform the following operations on an empty stack which has capacity 2:

When operation 1 1 is performed, we insert 1 in the stack.

When operation 1 2  is performed, we insert 2 in the stack. 

When operation 2 is performed, we remove the top element from the stack and print 2.

When operation 3 is performed, we print the top element of the stack, i.e., 3.

When operation 4 is performed, we print 0 because the stack is not empty.

When operation 5 is performed, we print 0 because the stack is size 1, which is not equal to its capacity.

Input Format:
The first line contains a single integer ‘T’ representing the number of test cases.

The first line of each test case contains two single space-separated integers, ‘N’ and ‘M’, representing the size of the stack and number of operations, respectively.

The next ‘M’ lines of each test case contain operations that have to be performed on the stack. 

Output Format :
For each test case, print the results of the operations performed on the stack.

Print output of each test case in a separate line.

Note :
You do not need to print anything. It has already been taken care of. Just implement the given function. 
Constraints :
1 <= T <= 10
1 <= N, M <= 10^3

Time Limit: 1 sec

Sample Input 1 :
1
2 6
1 1
1 2
2
3
4
5
Sample Output 1 :
2 1 0 0
Explanation For Sample Output 1 :
For test case 1: 
We perform the following operations on an empty stack which has capacity 2:

When operation 1 1 is performed, we insert 1 in the stack.

When operation 1 2  is performed, we insert 2 in the stack. 

When operation 2 is performed, we remove the top element from the stack and print 2.

When operation 3 is performed, we print the top element of the stack, i.e., 1.

When operation 4 is performed, we print 0 because the stack is not empty.

When operation 5 is performed, we print 0 because the stack is size 1, which is not equal to its capacity.

Sample Input 2 :
1
5 5
1 2
2
2 
1 1
3
Sample Output 2 :
2 -1 1
Explanation For Sample Output 2 :
For test case 1: 
We perform the following operations on an empty stack which has a capacity of 5:

When operation 1 2 is performed, we insert 2 in the stack.

When operation 2 is performed, we remove the top element from the stack and print 2.

When operation 2 is performed, as the stack is empty, we print -1.

When operation 1 1 is performed, we insert 1 in the stack.

When operation 3 is performed, we print the top element of the stack, i.e., 1.
*/


public class Stack {
    int[] arr;
    int top;
    
    public Stack (int n) {
        arr = new int[1001];
        top = -1;
    }
    
    void push(int num) {
        arr[++top] = num;    
    }
    int pop() {
        if (top != -1)
            return arr[top--];
        return -1;
    }
    int top() {
        if (top != -1)
            return arr[top];
        return -1;
    }
    int isEmpty() {
        if (top == -1)
            return 1;
        else 
            return 0;
    }
    int isFull() {
        if (top == arr.length)
            return 1;
        else 
            return 0;
    }
}
