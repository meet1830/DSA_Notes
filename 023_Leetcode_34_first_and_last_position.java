/*
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 
Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = searchFirst(nums, target);
        arr[1] = searchLast(nums, target);
        return arr;
    }
    public int searchFirst(int[] nums, int target) {
        int l = 0, r = nums.length -1, result = -1;
        if (l>r) return result;
        while (l<=r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
            if (nums[mid]==target) {
                result = mid;
            }
        }
        return result;
    }
    public int searchLast(int[] nums, int target) {
        int l = 0, r = nums.length -1, result = -1;
        if (l>r) return result;
        while (l<=r) {
            int mid = (l + r) / 2;
            if (nums[mid]<=target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
            if (nums[mid]==target) {
                result = mid;
            }
        }
        return result;
    }
}
