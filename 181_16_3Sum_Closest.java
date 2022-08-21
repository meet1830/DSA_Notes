/* 
 * 16. 3Sum Closest
Medium

6656

342

Add to List

Share
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-10^4 <= target <= 10^4
*/


// check 3 sum problem same approach
// if check for duplicates then wrong ans as we need to return sum closest and if repeating elements are not summed up the ans may change
// base case less than 3 no need check constraints
// tc - n^2 sc - 1

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        // if initialized as 0 then can prevent sum from updating in the loop returning wrong sum ans. if as integer.maxvalue then also fails because first sum - target is calculated then abs in taken hence prevents sum from updating
        int sum = nums[0] + nums[1] + nums[n - 1];
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];
                
                if (tempSum < target)
                    left++;
                else
                    right--;
                
                // checking if closer then update sum
                // if only target - sum then will change result for neg elements and neg target
                if (Math.abs(sum - target) > Math.abs(tempSum - target))
                    sum = tempSum;
            }
        }
        
        return sum;
    }
}