/*
33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
 
Constraints:
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
*/

// Approach -> after finding the mid any 1 of the 2 parts of array will be sorted and hence can be discarded. And binary search can be performed on the other half to find the target element.

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            
            if (nums[mid] == target) return mid;
            
            //check if this part is sorted
            else if (nums[l] <= nums[mid]) {
                
                //check if target lies in the part
                if (nums[l] <= target && nums[mid] > target) {
                    //if true then search within 
                    r = mid - 1;
                } 
                else {
                    //if false then discard this part
                    l = mid + 1;
                }
            }
            
            //check if remaining part is sorted
            else if (nums[mid] <= nums[r]) {
                
                //check if target lies in the part
                if (nums[mid] < target && nums[r] >= target) {
                    //if true then search within
                    l = mid + 1;
                }
                else {
                    //if false discard this part
                    r = mid - 1;
                }
            }
        }
        
        //if not found return -1
        return -1;
    }
}


// Approach 2: Find minimum and search

class Solution {
    public int search(int[] nums, int target) {
        
        //first find index of minimum value element from the array
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        
        //got the pivot index of rotation so there will be two part sorted arrays along side minimum element.
        int rotateIndex = l;
        //int rotateIndex = r;
        
        //reset r and l
        l = 0;
        r = nums.length - 1;
        
        //get location of target element left or right
        if (target >= nums[rotateIndex] && target <= nums[r]) {
            //right side of pivot
            l = rotateIndex;
        }
        else {
            //left side of pivot
            r = rotateIndex - 1;
        }
        
        //perform vanilla binary search on the part array to locate the element
        while (l<=r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }
}



// Another approach (Simple)

// Find minimum. Its index divides the array into 2 sorted arrays.
// can create a binary search function 
// and call it providing l and r values as arguments.
// on first call provide it with 0 and pivot-1. if does not return -1, return it as ans or else apply search again by giving pivot, arr.length - 1 as arguments.



// also works for duplicate elements in the array
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(target == nums[mid]) return mid;
            
            if(nums[mid] > nums[start]) {//[start..mid] is sorted
                if(target < nums[mid] && target >= nums[start]) end = mid - 1;
                else start = mid + 1;
            } else if(nums[mid] < nums[start]) {//[mid..end] is sorted
                if(target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            } else start++;
        }
        
        return -1;
    }
}
