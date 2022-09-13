/* 
 * Minimize the Heights I

Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once.

Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.

Note: Assume that height of the tower can be negative.

Example 1:
Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as 
{3, 3, 6, 8}. The difference between 
the largest and the smallest is 8-3 = 5.

Example 2:
Input:
K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
Output:
11
Explanation:
The array can be modified as
{6, 12, 9, 13, 17}. The difference between 
the largest and the smallest is 17-6 = 11. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getMinDiff() which takes the arr[], n and k as input parameters and returns an integer denoting the minimum difference.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

Constraints
1 ≤ K ≤ 10^4
1 ≤ N ≤ 10^5
1 ≤ Arr[i] ≤ 10^5

*/


// formula for diff -> max - min hence t0 minimize diff max-- and min++. 
// hence we are dividing into two segments and by adding and subtracting
// and finding out min diff

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        
        int diff = arr[n - 1] - arr[0];
        
        for (int i = 1; i < n; i++) {
            
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            
            diff = Math.min(diff, max - min);
        }
        
        return diff;
    }
}



/* 
 * Minimize the Heights II

Given an array arr[] denoting heights of N towers and a positive integer K.

For each tower, you must perform exactly one of the following operations exactly once.

Increase the height of the tower by K.
Decrease the height of the tower by K ( you can do this operation only if the height of the tower is greater than or equal to K)

Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

Note: It is compulsory to increase or decrease the height by K for each tower.


Example 1:

Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as 
{3, 3, 6, 8}. The difference between 
the largest and the smallest is 8-3 = 5.

Example 2:

Input:
K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
Output:
11
Explanation:
The array can be modified as
{6, 12, 9, 13, 17}. The difference between 
the largest and the smallest is 17-6 = 11. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getMinDiff() which takes the arr[], n, and k as input parameters and returns an integer denoting the minimum difference.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

Constraints
1 ≤ K ≤ 10^4
1 ≤ N ≤ 10^5
1 ≤ Arr[i] ≤ 10^5
*/


// formula for diff -> max - min hence t0 minimize diff max-- and min++. 
// hence we are dividing into two segments and by adding and subtracting
// and finding out min diff

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        
        int diff = arr[n - 1] - arr[0];
        
        for (int i = 1; i < n; i++) {
            if(arr[i] - k < 0)
                continue;
                
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            
            diff = Math.min(diff, max - min);
        }
        
        return diff;
    }
}
