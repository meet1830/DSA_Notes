/*
Matrix Diagonal Sum
Given a square matrix mat, return the sum of the matrix diagonals. Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Example 1:

Input: mat =

[[1,2,3],

[4,5,6],

[7,8,9]]

Output: 25

Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25

Notice that element mat[1][1] = 5 is counted only once.

Example 2:

Input: mat =

[[1,1,1,1],

[1,1,1,1],

[1,1,1,1],

[1,1,1,1]]

Output: 8
Input Format

Input n in the first line, where n is number of rows and columns. Then input n lines, each containing n integers.

Output Format

Output a single integer as answer.

Time Complexity = O(N)
*/


import java.io.*;
import java.util.*;
public class Main {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[][] mat = new int[n][n];
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        mat[i][j] = input.nextInt();
      }
    }
    int sum = 0;
    for (int i=0; i<n; i++) {
      sum += mat[i][i];
    }
    for (int i=0; i<n; i++) {
      sum += mat[i][n - i - 1];
    }
    if (n%2 != 0) {
      sum -= mat[n/2][n/2];
    }
    System.out.println(sum);
  }
}