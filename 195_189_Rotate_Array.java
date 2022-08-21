/* 
 * 189. Rotate Array
Medium

10753

1383

Add to List

Share
Given an array, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^5
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/



// 1. using a temp array
// O(n), O(k)

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k >= n)
            k = k % n;
        int[] temp = new int[k];
        // copying k elements from nums to temp 
        int t = 0;
        for (int i = n - 1; i >= n - k; i--) {
            temp[t++] = nums[i];
        }
        // replacing nums and making way for putting temp back at the starting
        t = n - 1;
        for (int i = n - k - 1; i >= 0; i--) {
            nums[t--] = nums[i];
        }
        // copying temp elements to nums
        t = k - 1;
        for (int i = 0; i < k; i++) {
            nums[t--] = temp[i];
        }
    }
}



// 2. rotating one by one using temp variable
// O(n * k), O(1)

class Solution {
    public void rotateByOne (int[] nums) {
        int n = nums.length;
        int temp = nums[n - 1];
        // replacing whole array
        for (int i = n - 2; i >= 0; i--) {
            nums[i + 1] = nums[i];
        }
        nums[0] = temp;
    }
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotateByOne(nums);
        }
    }
}



// 3. reversal algo
// Steps
// 1. reverse the whole array
// 2. reverse both the blocks [d] and [n - d] 
// 3. for right rotation reverse [d] and [n - d] and for left [n - d] and [d]
// O(n), O(1)

class Solution {
    public void reverseArray (int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
    public void rotate (int[] nums, int k) {
        int n = nums.length;
        
        if (k >= n)
            k = k % n;
        
        // reverse whole array
        reverseArray(nums, 0, n - 1);
        // reverse 0 to k
        reverseArray(nums, 0, k - 1);
        // reverse k + 1 to n
        reverseArray(nums, k, n - 1);
    }
}
