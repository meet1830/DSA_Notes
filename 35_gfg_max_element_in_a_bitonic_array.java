/*
Bitonic Point

Given an array arr of n elements which is first increasing and then may be decreasing, find the maximum element in the array.
Note: If the array is increasing then just print then last element will be the maximum value.

Example 1:
Input: 
n = 9
arr[] = {1,15,25,45,42,21,17,12,11}
Output: 45
Explanation: Maximum element is 45.

Example 2:
Input: 
n = 5
arr[] = {1, 45, 47, 50, 5}
Output: 50
Explanation: Maximum element is 50.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findMaximum() which takes the array arr[], and n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
3 ≤ n ≤ 106
1 ≤ arri ≤ 106
*/

class Solution {
    public static int findMaximum(int[] arr, int n) {
        int l = 0, r = arr.length - 1, result = 0;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    result = arr[mid];
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            else if (mid == 0) {
                if (arr[0] > arr[1]) {
                    result = arr[0];
                    return result;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (arr[mid] > arr[arr.length - 2]) {
                    result = arr[mid];
                    return result;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        return result;
    }
}
