/*
1260. Shift 2D Grid 
Question:
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

Example 1:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]

Example 2:
Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]

Example 3:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100
*/



class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // approach 
        // 1. convert matrix into 1d array
        // 2. rotate array by k
        // 3. convert into matrix and return
        // i * cols + j calculates index of 1d array
        // + k rotates the array
        // % m * n to prevent out of bound
        
        int rows = grid.length, cols = grid[0].length;
        int[][] result = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int val = ((i * cols + j) + k) % (rows * cols);
                int newR = val / cols;
                int newC = val % cols;
                result[newR][newC] = grid[i][j];
            }
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < rows; i++) {
            List<Integer> toAdd = new ArrayList<>();
            for(int j = 0; j < cols; j++) {
                toAdd.add(result[i][j]);
            }
            list.add(toAdd);
        }
        return list;
    }
}
