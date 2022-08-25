/* 
 * Delete middle element of a stack

Given a stack with push(), pop(), empty() operations, delete the middle of the stack without using any additional data structure.

Middle: ceil((size_of_stack+1)/2) (1-based index)

Example 1:
Input: 
Stack = {1, 2, 3, 4, 5}
Output:
ModifiedStack = {1, 2, 4, 5}
Explanation:
As the number of elements is 5 , 
hence the middle element will be the 3rd
element which is deleted

Example 2:
Input: 
Stack = {1 2 3 4}
Output:
ModifiedStack = {1 3 4}
Explanation:
As the number of elements is 4 , 
hence the middle element will be the 2nd
element which is deleted

Your Task:
You don't need to read input or print anything. Complete the function deleteMid() which takes the stack and its size as input parameters and modifies the stack in-place.
Note: The output shows the stack from top to bottom.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
2 ≤ size of stack ≤ 100
*/



// recursion -> in every call pop the stack and store the popped value.
// then again call del function and repeat the same as above
// at last call pop and return
// the call returns to previous call, now the stored value is added back in the stack
// this keeps happening till all remaining returning calls are executed
// note that in last call the stored value will not be added back to stack and hence is deleted
// calls are made till n / 2 times, hence the value not stored is the value to be deleted
// O(n), O(1)
class Solution
{
    static void del (Stack<Integer> st, int n, int count) {
        if (count == n / 2) {
            st.pop();
            return;
        }
        
        int num = st.pop();
        
        del (st, n, count + 1);
        
        st.push(num);
    }
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        del(s, sizeOfStack, 0);
    } 
}
