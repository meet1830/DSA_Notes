/*
289. Game of Life 
Question:
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.

Follow up:
Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
*/



class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int[][] temp = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            int count = 0;
            for(int j = 0; j < cols; j++) {
                count = 0;
                // counting ones
                // upper left diagonal
                if(i - 1 >= 0 && j - 1 >= 0) {
                    if(board[i - 1][j - 1] == 1) count++;
                }
                
                // upper element
                if(i - 1 >= 0) {
                    if(board[i - 1][j] == 1) count++;
                }
                
                // upper right diagonal
                if(i - 1 >= 0 && j + 1 < cols) {
                    if(board[i - 1][j + 1] == 1) count++;
                }
                
                // right element
                if(j + 1 < cols) {
                    if(board[i][j + 1] == 1) count++;
                } 
                
                // lower right diagonal
                if(i + 1 < rows && j + 1 < cols) {
                    if(board[i + 1][j + 1] == 1) count++;
                }
                
                // lower element
                if(i + 1 < rows) {
                    if(board[i + 1][j] == 1) count++;
                }
                
                // lower left diagonal
                if(i + 1 < rows && j - 1 >= 0) {
                    if(board[i + 1][j - 1] == 1) count++;
                }
                
                // left element
                if(j - 1 >= 0) {
                    if(board[i][j - 1] == 1) count++;
                }
                
                if(count == 2 && board[i][j] == 1) temp[i][j] = 1;
                else if(count == 3) temp[i][j] = 1;
                else temp[i][j] = 0;
                // System.out.print(count + " ");
            }
        }
        
        // copy all the elements to the original matrix
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }
}
