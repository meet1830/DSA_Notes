/* 
 * 503. Next Greater Element II
Medium

5227

146

Add to List

Share
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

Constraints:

1 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
*/


// brute using modulo
// O(n^2), O(1)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < i + nums.length; j++) {
                if(nums[j % nums.length] > nums[i]) {
                    res[i] = nums[j % nums.length];
                    break;
                }
                else 
                    res[i] = -1;
            }
        }

        return res;
    }
}


// optimal -> using stack and creating an imaginary array on the side of the input array acting as one whole array. this way for case where greater element is present on the left side (circular array case) then it will always be present on the imaginary array
// O(n), O(1)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n])
                st.pop();
            
            // dont need to update ans for i > n
            if (i < n) {
                if (!st.isEmpty())
                    ans[i] = st.peek();
                else 
                    ans[i] = -1;
            }
            
            st.push(nums[i % n]);
        }
        
        return ans;
    }
}