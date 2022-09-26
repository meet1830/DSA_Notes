/* 
 * Largest subarray with 0 sum
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 10^5
-1000 <= A[i] <= 1000, for each valid i
*/


// brute -> generate all the possible subarrays using two pointers and calculate sum.
// tc -> n^3 can optimize the subarray generating to n^2 

class GfG
{
    int maxLen(int arr[], int n) 
    {
        int len = 0, maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int p = i; p <=j; p++) 
                    sum += arr[p];
                    
                if (sum == 0)
                    len = j - i + 1;
                    
                maxLen = Math.max(len, maxLen);
            }
        }
        
        return maxLen;
    }
}



// brute -> reduced to n^2
class GfG {
    int maxLen(int arr[], int n) {
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            
            for (int j = i; j < n; j++) {
                sum += arr[j];
                
                if (sum == 0)
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        
        return maxLen;
    }
}



// optimal use hashing put k = 0 in longest subarray with sum k

// one subarray till index i is equal to sum x. other subarray bigger than this subarray has the same sum. then it can be concluded that the elements between both the subarray will be of sum 0. 

class GfG {
    int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0, maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            
            // if sum == target for subarray starting from index 0 then count it. it would be max as in else loop we are subtracting some term hence length reduces 
            if (sum == 0)
                maxLen = i - 0 + 1;
            
            else if (map.containsKey(sum - 0)) {
                maxLen = Math.max(maxLen, i - map.get(sum - 0));
            }
            else 
            // in else because dont update index value when found due to test case 1. if updated then will not return largest length.
                map.put(sum, i);
        }
        
        return maxLen;
    }
}