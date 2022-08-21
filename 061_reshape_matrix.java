/*
Reshape the Matrix
In MATLAB, there is a very useful function called "reshape", which can reshape a matrix into a new one with different size but keep its original data.

You are given a matrix represented by a two-dimensional array (m*n), and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the "reshape" operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output "Not possible to reshape."

Example 1: Input: nums = [[1,2], [3,4]] r = 1, c = 4 Output: [[1,2,3,4]] Explanation: The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.

Example 2: Input: nums = [[1,2], [3,4]] r = 2, c = 4 Output: Not possible to reshape.

Explanation: There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output "Not possible to reshape."
*/

import java.util.*;

public class G1_reshape_matrix {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int arr[][] = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    int r = sc.nextInt();
    int c = sc.nextInt();
    int arr2[][] = new int[r][c];

    if (r * c == m * n) {
      int k = 0, l = 0;
      for (int p = 0; p < m; p++) {
        for (int q = 0; q < n; q++) {
          arr2[k][l] = arr[p][q];
          if (l == c - 1) {
            k++;
            l = 0;
          } else
            l++;
        }
      }

      for (int x = 0; x < r; x++) {
        for (int y = 0; y < c; y++) {
          System.out.print(arr2[x][y] + " ");

        }
        System.out.println();
      }

    } else {
      System.out.println("Not possible to reshape.");
    }
    sc.close();
  }
}