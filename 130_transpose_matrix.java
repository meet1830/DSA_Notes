/*
 * Transpose Matrix
Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the row and column indices of the matrix. Input consists of the number of rows m and columns n followed by the matrix m x n values.

Input
For line contains two integer m and n denoting rows and columns in the matrix The m lines of input contains n integers each denoting n elements in each row

Output
Ouput n lines with m integers each denoting transpose of matrix

Constraints:
2 <= m, n < 1000 1 <= Element of matrix <= 10^9

Sample Input:
3 3
1 2 3
4 5 6
7 8 9
Sample Output:
1 4 7
2 5 8
3 6 9
Explaination
The first row of matrix is [1, 2, 3] and after taking transpose it becomes first column of matrix [1, 4, 7] is first colimn of matrix and after taking transpose it becomes first row
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        long[][] mat = new long[m][n];
        long[][] trans = new long[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = input.nextLong();
                trans[j][i] = mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(trans[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}