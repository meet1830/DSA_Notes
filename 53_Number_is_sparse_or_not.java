/*
Number is sparse or not
Given a number N. The task is to check whether it is sparse or not. A number is said to be a sparse number if no two or more consecutive bits are set in the binary representation.

Input
First line contains a single integer N

Output
Print "YES" (without quotes) if number is sparse else Print "NO"

Constraints:
1 <= N <= 1000000

Sample Input:
2
Sample Output:
YES

*/

import java.util.Scanner;

public class G3_Number_is_sparse_or_not {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long n = input.nextLong();
    byte[] arr = new byte[32];
    for (int i = 0; i < 32; i++)
      arr[i] = 0;
    long temp = n;
    for (int i = 0; temp > 0; i++) {
      if (temp % 2 == 0)
        arr[i] = 0;
      else
        arr[i] = 1;
      temp /= 2;
      // System.out.print(arr[i] + " ");
    }
    byte state = 0;
    for (int i = 0; i < 32; i++) {
      if (arr[i] == 1 && arr[i] == arr[i + 1]) {
        state = 0;
        break;
      }
      else
        state = 1;
    }
    if (state == 0) System.out.println("NO");
    else System.out.println("YES");
    input.close();
  }
}