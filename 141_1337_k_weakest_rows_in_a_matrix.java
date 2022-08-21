/*
1337. The K Weakest Rows in a Matrix 
Question:
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

Example 1:
Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 2 
- Row 1: 4 
- Row 2: 1 
- Row 3: 2 
- Row 4: 5 
The rows ordered from weakest to strongest are [2,0,3,1,4].

Example 2:
Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 1 
- Row 1: 4 
- Row 2: 1 
- Row 3: 1 
The rows ordered from weakest to strongest are [0,2,3,1].
 
Constraints:
m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
*/

Solution:
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        /*
        1)Firstly, we will create an array arr of size mat.length
        2)Now, this array will have frequency of number of ones present in each row.
        3)Now, create ans array of size k, now traverse arr and find the index number with minimum value and put that index number in ans array
        4)Just to make sure that you have traversed a particular index, mark it by reinitializing that index with Integer.MAX_VALUE
        5)Return ans array
        */

        int rows = mat.length, cols = mat[0].length; 
        int[] arr = new int[rows];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                 if(mat[i][j] == 1) arr[i]++;
            }
        }

        int[] ans = new int[k];
        
        for(int i = 0; i < k; i++) {
            int minVal = Integer.MAX_VALUE, minIdx = -1;
            for(int j = 0; j < rows; j++) {
                if(arr[j] < minVal) {
                    minVal = arr[j];
                    minIdx = j;
                }
            }
            ans[i] = minIdx;
            arr[minIdx] = Integer.MAX_VALUE;
        }
        
        return ans;
    }
}

