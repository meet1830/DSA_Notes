/* 977. Squares of a Sorted Array
Easy

6170

161

Add to List

Share
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
*/



// two pointer approach to sort the array
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int p = 0, q = n - 1;
        
        for(int r = n - 1; r >= 0; r--) {
            if(Math.abs(nums[p]) > Math.abs(nums[q])) {
                ans[r] = nums[p] * nums[p];
                p++;
            }
            else {
                ans[r] = nums[q] * nums[q];
                q--;
            }
        }
        
        return ans;
    }
}



class Solution {
    public int[] sortedSquares(int[] a) {
        int n = a.length;
        int ans[] = new int[n];
        int mn = 0, rmn = n, k = 0;
        for(int i = 0; i < n; i++){
            a[i] = Math.abs(a[i]);
        }
        for(int i = 0; i < n; i++){
            if(a[i] < a[mn]){
                mn = i;
            }
        }
        if(mn + 1 < n){
            rmn = mn + 1;
        }
        while(mn >= 0 && rmn < n){
            if(a[mn] < a[rmn]){
                ans[k] = a[mn] * a[mn];
                mn--;
            }else{
                ans[k] = a[rmn] * a[rmn];
                rmn++;
            }
            k++;
        }
        while(mn >= 0){
            ans[k] = a[mn] * a[mn];
            k++;
            mn--;
        }
        while(rmn < n){
            ans[k] = a[rmn] * a[rmn];
            k++;
            rmn++;
        }
        return ans;
    }
}