/* 
Pepcoding -> Flood Fill

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a. The numbers can be 1 or 0 only.
4. You are standing in the top-left corner and have to reach the bottom-right corner. 
Only four moves are allowed 't' (1-step up), 'l' (1-step left), 'd' (1-step down) 'r' (1-step right). You can only move to cells which have 0 value in them. You can't move out of the boundaries or in the cells which have value 1 in them (1 means obstacle)
5. Complete the body of floodfill function - without changing signature - to print all paths that can be used to move from top-left to bottom-right.

Note1 -> Please check the sample input and output for details
Note2 -> If all four moves are available make moves in the order 't', 'l', 'd' and 'r'

Constraints
1 <= n <= 10
1 <= m <= 10
e1, e2, .. n * m elements belongs to set (0, 1)

Format
Input
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements

Output
trrrdlt
tlldrt
.. and so on

Example
Sample Input
3 3
0 0 0
1 0 1
0 0 0

Sample Output
rddr
*/

// flood fill
public class Main {
  public static void floodFill(int[][] arr, int cm, int cn, 
      String ans, boolean[][] visited) {
    // base -> stupid calls smart base case
    if (cm < 0 || cn < 0 || cm == arr.length || 
        cn == arr[0].length || arr[cm][cn] == 1 || visited[cm][cn] == true) {
        // order of or conditions matter here -> if any condition true, then 
        // remaining conditions will not get evaluated
      return;
    }
    if (cm == arr.length - 1 && cn == arr[0].length - 1) {
      System.out.println(ans);
      return;
    }
    
    visited[cm][cn] = true;
    floodFill(arr, cm - 1, cn, ans + "u", visited);
    floodFill(arr, cm, cn - 1, ans + "l", visited);
    floodFill(arr, cm + 1, cn, ans + "d", visited);
    floodFill(arr, cm, cn + 1, ans + "r", visited);
    visited[cm][cn] = false;
  }
  public static void main(String[] args) {
    int m = 6, n = 7;
    int[][] arr = {
      {0, 1, 0, 0, 0, 0, 0},
      {0, 1, 0, 1, 1, 1, 0},
      {0, 0, 0, 0, 0, 0, 0},
      {1, 0, 1, 1, 0, 1, 1},
      {1, 0, 1, 1, 0, 1, 1},
      {1, 0, 0, 0, 0, 0, 0}
    };
    boolean[][] visited = new boolean[m][n];
    floodFill(arr, 0, 0, "", visited);
  }
}

/*
ddrdddrrrrr
ddrruurrrrddlldddrr
ddrrrrdddrr
*/


/* 
 * 733. Flood Fill

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.


Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 

Constraints:
m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n

*/


class Solution {
  // can apply dfs or bfs to travel all nodes recursively and iteratively
  public void dfs(int[][] image, int m, int n, int initColor, int newColor) {
      // base cases
      if(m >= image.length || m < 0) return;
      if(n >= image[0].length || n < 0) return;
      
      // condition to travel nodes with the same initial color
      if(image[m][n] == initColor) {
          // making conversion
          image[m][n] = newColor;
          
          // travelling all nodes
          dfs(image, m - 1, n, initColor, newColor); // up
          dfs(image, m + 1, n, initColor, newColor); // down
          dfs(image, m, n - 1, initColor, newColor); // left
          dfs(image, m, n + 1, initColor, newColor); // right
      }
  }
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      // avoiding stack overflow error if initial color is same as new color
      if(newColor == image[sr][sc]) 
          return image;
      
      dfs(image, sr, sc, image[sr][sc], newColor);
      
      return image;
  }
}