/*
TRAILING ZEROES
For an integer n find the number of trailing zeroes in n!.

Input
line 1: contains an integer n.

Output
Print a single integer denoting number of trailing zeroes in n.

Constraints
1<=n<=10^9

Expected Time Complexity: O(logn)

Expected Space Complexity: O(1)

Sample Input
5
Sample Output
1
*/

// Approach -> https://brilliant.org/wiki/trailing-number-of-zeros/?quiz=trailing-number-of-zeros 

import java.io.*;
import java.util.*;
public class G2_trailing_zeroes_n! {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int tzeros = 0, i = 1;
    while (n / (Math.pow(5, i)) > 0) {
      tzeros += n / (Math.pow(5, i++));
    }
    System.out.println(tzeros);
  }
}
