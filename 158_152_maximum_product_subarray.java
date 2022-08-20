/* 
 * 152. Maximum Product Subarray 
Question:
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray. 

Constraints:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/



class Solution {
    public int maxProduct(int[] nums) {
        int maxp = nums[0], minp = nums[0], maxSoFar = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int x = Math.max(nums[i], Math.max(nums[i] * maxp, nums[i] * minp));
            int y = Math.min(nums[i], Math.min(nums[i] * maxp, nums[i] * minp));
            
            maxp = x;
            minp = y;
            
            maxSoFar = Math.max(maxSoFar, maxp);
        }
        
        return maxSoFar;
    }
}


