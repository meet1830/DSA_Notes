/* 
 * 75. Sort Colors 
Question:
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 
Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/


/*
    brute -> use sorting algorithm -> merge sort -> tc - nLogn sc - 1
    better -> counting sort -> count frequency for all. and then insert in the array accordingly number of times -> tc - 2n sc - 1
    optimal -> variation of dutch national flag algo
        three pointers low mid and high
        initial assumption that all elements before low(low - 1) is 0, after high(high + 1) is 2 and between low and mid - 1 is 1
        initially l and m at 0 and h at n - 1
        if encountered 0 swap l and mid and l++ m++
        if 1 then just m++
        if 2 then swap m and h and h--
        tc - n, sc - 1
*/

class Solution {
    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        int i = 0;
        
        while(mid <= high) {
            switch(nums[mid]) {
                case 0: {
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                }
                    
                case 1: {
                    mid++;
                    break;
                }
                
                case 2: {
                    swap(nums, mid, high);
                    high--;
                }
            }
        }
    }
}

