/* 
 * 456. 132 Pattern 
Question:
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Example 1:
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.

Example 2:
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 
Constraints:
n == nums.length
1 <= n <= 2 * 10^5
-10^9 <= nums[i] <= 10^9
*/



class Solution {

/*
brute -> use three nested loops i. j = i + 1, k = j + 1 to find three values and in the third loop use a if condition if it satisfies the condition of the question then return true else false.
    tc -> n^3 sp -> 1 will give tle
better -> take i = nums[0] and run two loops j = 0, k = j + 1, and then then run condition if true then return true. then take min of nums[i] and nums[j]. if taken min with nums[k] then makes no sense as nums[i] still has to lesser than j according to the condition.
    tc -> n^2 sp -> 1 again gives tle as n * n is 10^10 which is greater than constraints
optimal -> reduce to one loop. problem similar to next greater element, hence will use stack. somehow store two values in stack and iterate to find the third one(i). since j and k are greater than i hence traverse from back
take an array having max somewhere at the middle. find the max element from other elements on right side of the max(secondmax) and similarly find lowest element from the left. if second max is greater than the lowest element from left then we have a 132 pattern. dry run to understand
    tc -> n sc -> n
*/

    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<Integer>();
        int secondMax = Integer.MIN_VALUE;
        
        for(int i = nums.length - 1; i >= 0; i--) {
            // found third element hence return
            if(nums[i] < secondMax) 
                return true;
            
            // finding secondMax
            while(!st.isEmpty() && nums[i] > st.peek()) {
                secondMax = Math.max(secondMax, st.pop());
            }
            
            // finding all peaks and storing in stack
            st.push(nums[i]);
        }
        
        return false;
    }
}


