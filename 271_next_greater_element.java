/*
Next Greater Element

Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

Example 1:
Input: 
N = 4, arr[] = [1 3 2 4]
Output:
3 4 4 -1
Explanation:
In the array, the next larger element 
to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
since it doesn't exist, it is -1.

Example 2:
Input: 
N = 5, arr[] [6 8 0 1 3]
Output:
8 -1 1 3 -1
Explanation:
In the array, the next larger element to 
6 is 8, for 8 there is no larger elements 
hence it is -1, for 0 it is 1 , for 1 it 
is 3 and then for 3 there is no larger 
element on right and hence -1.

Your Task:
This is a function problem. You only need to complete the function nextLargerElement() that takes list of integers arr[ ] and N as input parameters and returns list of integers of length N denoting the next greater elements for all the corresponding elements in the input array.

Expected Time Complexity : O(N)
Expected Auxiliary Space : O(N)

Constraints:
1 ≤ N ≤ 106
1 ≤ Ai ≤ 1018

*/

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] input, int n)
    {
        long[] output = new long[n];
        Stack<Long> st = new Stack<>();
    
        output[n - 1] = -1;
        st.push(input[n - 1]);
    
        for(int i = n - 2; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() < input[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                output[i] = -1;
                st.push(input[i]);
            }
            else {
                output[i] = st.peek();
                st.push(input[i]);
            }
        }
        return output;
    } 
}




/*
 * 496. Next Greater Element I
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 

Constraints:

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 104
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.
 

Follow up: Could you find an O(nums1.length + nums2.length) solution?
*/


// brute
// first if -> finding nums1[i] in nums2
// second if -> finding greater element in nums2
// O(n^2), O(1)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums2[j]) {
                            nge[i] = nums2[k];
                            break;
                        }
                    }
                    if (nge[i] == 0)
                        nge[i] = -1;
                }
            }
        }
        
        return nge;
    }
}



// optimal
// use hashmap to store the nums2[i] and its next greater element which can then be accessed in O(1) for all elements in nums1
// O(n), O(n)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i])
                st.pop();
            
            if (!st.isEmpty())
                map.put(nums2[i], st.peek());
            else 
                map.put(nums2[i], -1);
            
            st.push(nums2[i]);    
        }
        
        for (int i = 0; i < nums1.length; i++) {
            nge[i] = map.get(nums1[i]);
        }
        
        return nge;
    }
}