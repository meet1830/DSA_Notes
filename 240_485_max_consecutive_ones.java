/* 
 * 485. Max Consecutive Ones
Easy

3159

407

Add to List

Share
Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
*/


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0, cnt = 0;
        
        for (int x : nums) {
            if(x == 1)
                cnt++;
            else 
                cnt = 0;
            
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
}