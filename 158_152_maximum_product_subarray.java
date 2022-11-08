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



// ma stores max product, mi stores min product
// if curr ele is neg, then if multiplied with ma will result in min value till now and similarly if multiplied with mi will result in max product till now. 
// Hence swap them beforehand so that ma stores max product and mi stores min product.
// in eg 1 till -2, ma = 6 and mi = 2
// 6*-2=-12 and 2*-2=-4, hence ma < mi
// if swapped before then ma = -4, mi = -12
// O(n), O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], ma = ans, mi = ans;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = ma;
                ma = mi;
                mi = temp;
            }
            ma = Math.max(nums[i], nums[i] * ma);
            mi = Math.min(nums[i], nums[i] * mi);
            ans = Math.max(ans, ma);
        } 
        return ans;
    }
}
