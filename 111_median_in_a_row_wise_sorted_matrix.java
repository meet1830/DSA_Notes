/*
Median in a row-wise sorted Matrix
Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Expected Time Complexity: O(32 * R * logC)
Expected Auxiliary Space: O(1)

Input
The first line contains two integers R and C.
The next r lines contains c spaced integers , elements of matrix.
Constraints
1<= R,C <=150
1<= matrix[i][j] <=2000
Output
Print the median of the matrix.

Example
Sample Input

3 3
1 3 5 
2 6 9 
3 6 9
Sample Output

5
Explanation

Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median.
Sample Input

3 1
1
2
3
Sample Output

2
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  public static boolean possible(int a[][], int x, int median) {
    int n = a.length;
    int m = a[0].length;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      int l = 0, r = m - 1, smaller = 0;
      while (l <= r) {
        int mid = (l + r) / 2;
        if (a[i][mid] < median) {
          smaller = mid + 1;
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      cnt += smaller;
      // System.out.print(smaller + " ");
    }
    // System.out.println();
    // System.out.println(cnt);
    // System.out.println(cnt <= x);
    return (cnt <= x);
  }

  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int a[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = input.nextInt();
      }
    }
    int x = n * m / 2;
    int l = 1, r = 2000, ans = 0;
    while (l <= r) {
      int median = l + (r - l) / 2;
      // System.out.println(median);
      if (possible(a, x, median)) {
        ans = median;
        l = median + 1;
      } else {
        r = median - 1;
      }
    }
    System.out.println(ans);
  }
}
