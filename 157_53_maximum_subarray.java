/*
 * 53. Maximum Subarray 
Question:
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
 
Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

 

/*
    brute -> three loops -> two loops for finding out the subarray and third one for finding sum. if more than max than update max variable
    better -> can get rid of third loop if calculating the sum in second loop itself.
    optimal -> kadanes algo
*/

// KADANE'S ALGORITHM
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], maxSoFar = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            // checking if sum is increasing if yes 
            // then add next to the current or
            // just use next
            
            if(maxSum > maxSoFar) maxSoFar = maxSum;
        }
        
        return maxSoFar;
    }
}


// KADANE'S ALGO
// keep sum until it remains positive
// if sum exceeds the max update the max
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        
        return max;
    }
}


