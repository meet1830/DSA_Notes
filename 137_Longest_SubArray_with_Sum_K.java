/*
 * Longest Sub-Array with Sum K
Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

Example 1:
Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.

Example 2:
Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function smallestSubsegment() that takes an array (A), sizeOfArray (n),  sum (K)and returns the required length of the longest Sub-Array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1<=N<=10^5
-10^5<=A[i], K<=10^5
*/

class Solution {

    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            // calculating sum
            sum += arr[i];

            // if sum == k
            if (sum == k)
                maxLen = i + 1;

            // if sum does not exist in hashmap then add
            if (!map.containsKey(sum))
                map.put(sum, i);

            // if map contains sum - k then update maxLen if greater
            if (map.containsKey(sum - k)) {
                if (maxLen < i - map.get(sum - k))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }

}