/* 
 * 994. Rotting Oranges
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.


Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/


class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) 
                    fresh++;
                    // counting fresh oranges for base case
                else if(grid[i][j] == 2) 
                    q.offer(new int[] {i, j});
            }
        }
        
        if(fresh == 0) return 0;
        
        // can add to obtain coordinates around the orange
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // variable to keep track of minutes passed
        int minute = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            // looping through all the oranges from the previous minute
            for(int i = 0; i < size; i++) {
                int[] curr_coordinate = q.poll();
                
                // checking for fresh oranges in all directions
                for(int j = 0; j < directions.length; j++) {
                    int x = curr_coordinate[0] + directions[j][0];
                    int y = curr_coordinate[1] + directions[j][1];
                    
                    // if at corner or when there does not exist a fresh orange
                    // then no need to check
                    if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) 
                        continue;
                    
                    grid[x][y] = 2; // marking as rotten
                    fresh--;
                    
                    // newly rotted orange has to be added to the queue
                    q.offer(new int[] {x, y});
                }
            }
            
            // queue empty but fresh still left means no more 
            // rotted oranges left to rot fresh oranges
            if(q.size() == 0 && fresh > 0)
                return -1;
            
            // a min passed after one loop
            minute++;
        }
        
        if(fresh == 0) 
            return --minute;
        
        // else return -1 as all oranges could not be rotten
        return -1;
    }
}