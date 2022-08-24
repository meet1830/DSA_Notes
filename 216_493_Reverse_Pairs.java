/* 
 * 493. Reverse Pairs
Hard

3693

200

Add to List

Share
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
 

Constraints:

1 <= nums.length <= 5 * 10^4
-2^31 <= nums[i] <= 2^31 - 1

*/



// brute -> use two nested loops to figure out count
// O(n^2), O(1)

class Solution {
    public int reversePairs(int[] nums) {
        int count = 0;
        
        for (int i = 0; i < nums.length; i++)
            for (int j = i; j < nums.length; j++)
                if (nums[i] > 2 * nums[j])
                    count++;
        
        return count;
    }
}



// optimal -> using merge sort -> similar to problem inversion count
// other code same as merge sort
// explaining the for loop
// while merging the left and right array in merge function, take two pointers, one on left array and other on right array
// check for the condition given for each i (n^2) unless it becomes false
// but here optimised and made j stay where it was because as left and right are in sorted fashion, if condition is true for previous i, then it will be true for this i
// hence after for each i count the number of true conditions
// O(nlogn + n + n) -> (mergeSort + merge + counting loop)
// O(n) -> merge sort function
class Solution {
    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) 
            return 0;
        
        int mid = l + (r - l) / 2;
        int count = mergeSort(nums, l, mid);
        count += mergeSort(nums, mid + 1, r);
        count += merge(nums, l, r, mid);
        
        return count;
    }
    
    private int merge(int[] nums, int l, int r, int mid) {
        int count = 0;
        int i = l, j = mid + 1;
        for (i = l; i <= mid; i++) {
            while (j <= r && nums[i] > (2 * (long)nums[j]))
                j++;
            count += j - (mid + 1);
        }
        
        int[] merged = new int[r - l + 1];
        int k = 0;
        i = l; j = mid + 1;
        
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j])
                merged[k++] = nums[i++];
            else 
                merged[k++] = nums[j++];
        }
        while (i <= mid) 
            merged[k++] = nums[i++];
        while (j <= r)
            merged[k++] = nums[j++];
        
        for (int p = 0, q = l; p < merged.length; p++, q++) 
            nums[q] = merged[p];
        
        return count;
    }
    
    public int reversePairs(int[] nums) {
        int[] arr = nums;
        return mergeSort(arr, 0, nums.length - 1);
    }
}