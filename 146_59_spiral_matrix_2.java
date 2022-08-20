/*
9. Spiral Matrix II 
Question:
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]

Constraints:
1 <= n <= 20
*/


class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int val = 1;
        int i = 0, k = 0, l = 0, r = n, c = n;
        // k, l, r, c
        while (k < r && l < c) {
            // Print the first row from the remaining rows
            for (i = l; i < c; i++) {
                mat[k][i] = val++;
            }     
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < r; i++) {
                mat[i][c - 1] = val++;
            }
            c--;

            // Print the last row from the remaining rows
            if (k < r) {
                for (i = c - 1; i >= l; i--) {
                    mat[r - 1][i] = val++;
                }
                r--;
            }

            // Print the first column from the remaining columns
            if (l < c) {
                for (i = r - 1; i >= k; i--) {
                    mat[i][l] = val++;
                }
                l++;
            }
        }
        return mat;
    }
}

