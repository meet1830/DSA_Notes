/*
Spirally traversing a matrix
Given a matrix of size r*c. Traverse the matrix in spiral form.

Expected Time Complexity: O(rxc)
Expected Auxiliary Space: O(rxc), for returning the answer only.

Input
The first line contains two integers r and c.
The next r lines contains c spaced integers , elements of matrix.
Constraints
1 <= r, c <= 100
0 <= matrix[i][j] <= 100
Output
Print the spiral matrix.

Example
Sample Input

4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Sample Output

1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation

 Sample Input

3 4  
1 2 3 4
5 6 7 8
9 10 11 12
Sample Output

1 2 3 4 8 12 11 10 9 5 6 7
Explanation

Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.
*/

import java.util.*;
import java.io.*;

public class Main {
  public static void spiralMat(int[][] mat, int r, int c) {
    /* terminology
      k - starting row index
      r - ending row index
      l - starting column index
      c - ending column index
      i - iterator
    */
    int i, k = 0, l = 0;
    while (k < r && l < c) {
      // Print the first row from the remaining rows
      for (i = l; i < c; i++) {
        System.out.print(mat[k][i] + " ");
      }
      k++;

      // Print the last column from the remaining columns
      for (i = k; i < r; i++) {
        System.out.print(mat[i][c - 1] + " ");
      }
      c--;

      // Print the last row from the remaining rows
      if (k < r) {
        for (i = c - 1; i >= l; i--) {
          System.out.print(mat[r - 1][i] + " ");
        }
        r--;
      }

      // Print the first column from the remaining columns
      if (l < c) {
        for (i = r - 1; i >= k; i--) {
          System.out.print(mat[i][l] + " ");
        }
        l++;
      }
    }
  }
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int r = input.nextInt(), c = input.nextInt();
    int[][] mat = new int[r][c];
    for (int i=0; i<r; i++) {
      for (int j=0; j<c; j++) {
        mat[i][j] = input.nextInt();
      }
    }
    spiralMat(mat, r, c);
  }
}



// traverse counter clockwise
// for eg 
/*
4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

1, 5, 9, 13, 14, 15, 16, 12, 8, 4, 3, 2, 6, 10, 11, 7
*/

public class Main {
    public static void main(String args[]) {
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printCounterClockwise(mat, 4, 4);
    }
    private static void printCounterClockwise(int[][] mat, int m, int n) {
        int k = 0, l = 0, r = m, c = n;
    
        while (k < r && l < c)
        {
            for (int i = k; i < r; i++)
                System.out.print(mat[i][l] + " ");
            l ++ ;

            for (int i = l; i < c; i++)
                System.out.print(mat[r - 1][i] + " ");
            r-- ;

            if (c > l) {
                for (int i = r - 1; i >= k; i--)
                    System.out.print(mat[i][c - 1] + " ");
                c-- ;
            }

            if (r > k) {
                for (int i = c - 1; i >= l; i--)
                    System.out.print(mat[k][i] + " ");
                k++;
            }
        }
    }
}