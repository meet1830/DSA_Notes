/* 
 * 1695. Maximum Erasure Value
Medium

2286

37

Add to List

Share
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

 

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4
*/



// hashset and two pointers
// tc - n, sc - n
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        int start = 0, end = 0;
        int currSum = 0, maxSum = 0;
        
        while (end < n) {
            if (!set.contains(nums[end])) {
                set.add(nums[end]);
                currSum += nums[end];
                end++;
                // currSum will have the sum of unique subarray at the end and it may not be maximum hence maxSum
                maxSum = Math.max(maxSum, currSum);
            }
            else {
                // remove elements till the encountered duplicate element is not removed. will add the same for this subarray in if condition
                set.remove(nums[start]);
                currSum -= nums[start];
                start++;
            }
        }
        
        return maxSum;
    }
}