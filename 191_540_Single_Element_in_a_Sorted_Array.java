/* 
 * 540. Single Element in a Sorted Array
Medium

5985

114

Add to List

Share
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
*/



// better -> xoring all the values with result in the final ans as the element which is not repeating.
// O(n), O(1)

// optimal
// O(logn), O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        
        // boundary cases
        if (hi == 0)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[hi] != nums[hi - 1])
            return nums[hi];
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            // ideal case -> starting element of pair should be at even index
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1]))
                lo = mid + 1;
            else 
                hi = mid - 1;
        }
        
        return nums[lo];
    }
}