/* 
 * 73. Set Matrix Zeroes
Medium

8663

537

Add to List

Share
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-2^31 <= matrix[i][j] <= 2^31 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/



/*
    1. Brute -> if encounter a zero and updated whole row and col in same iteration, then in next iteration it will treat the updated zero as original zero and will update its row and column ultimately the matrix will be converted to zero matrix
        Create a copy of matrix, if encountered zero update the row and column in original matrix. initially fill it with -1 or anything. at last update the values which have -1 with non zero values
        
    2. Better -> Create two arrays one for row and one for column. traverse the matrix, if encountered 0 then update the row array and col array with 0 for that index i and j. at last traverse the matrix and update it with 0 if any of the i or j is 0.
        
    3. Optimal -> take two boolean variables for first row and column. if first row, column contains 0 then update them to true. Now traverse the matrix from i and j = 1 whenever found 0 update the value of i and j for first row and column to be 0. Now traverse the first row, whenever found 0 run a loop to update the row and column of matrix to 0. Run again for col. then finally if boolean variables are true, then update the first row and col to be 0.
*/


class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        
        boolean row = false, col = false;
        for(int i = 0; i < c; i++) if(matrix[0][i] == 0) row = true;
        for(int j = 0; j < r; j++) if(matrix[j][0] == 0) col = true;
        
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int j = 1; j < c; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 0; i < r; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < r; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(row) {
            for(int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if(col) {
            for(int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }   
}



class Solution {
    public void setZeroes(int[][] matrix) {
        // 4.
        int col = 1; // means true initially
        int rows = matrix.length, cols = matrix[0].length;
        
        for(int i = 0; i < rows; i++) {
            // if value at the zeroth col is zero mark col as false
            // which indicates that that col is to be zeroed
            if(matrix[i][0] == 0) col = 0;
            
            // traversing other than dummy arrays to mark 0's in dummy arrays
            for(int j = 1; j < cols; j++) {
                if(matrix[i][j] == 0) 
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        
        // travel in matrix to zero the rows and cols
        // travel from back so that value is not updated in dummy arrays 
        for(int i = rows - 1; i >= 0; i--) {
            for(int j = cols - 1; j >= 1; j--) {
                // if any or both of dummy arrays are 0 then zero the value
                if(matrix[i][0] == 0 || matrix[0][j] == 0) 
                    matrix[i][j] = 0;
            }
            
            // check for col condition if col = 0 means that the zeroth col 
            // contains 0 and hence need to update the col with 0 value
            if(col == 0) 
                matrix[i][0] = 0;
        }
    }
}