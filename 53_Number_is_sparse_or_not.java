/*
Number is sparse or not
Given a number N. The task is to check whether it is sparse or not. A number is said to be a sparse number if no two or more consecutive bits are set in the binary representation.
means two or more consecutive bits are 1. for eg. 12 -> 1100 -> yes, 72 -> 01001000 -> no

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


// If we observer carefully, then we can notice that if we can use bitwise AND of binary representation of the “given number its “right shifted number”(i.e., half the given number) to figure out whether the number is sparse or not. Result of AND operator would be 0 if number is sparse and non-zero if not sparse.
// JAVA Code to Check if a
// given number is sparse or not

import java.util.*;

class GFG {
	
	// Return true if n is
	// sparse,else false
	static int checkSparse(int n)
	{

		// n is not sparse if there
		// is set in AND of n and n/2
		if ((n & (n>>1)) >=1)
			return 0;
	
		return 1;
	}
	
	// Driver code
	public static void main(String[] args)
	{
		System.out.println(checkSparse(72)) ;
		System.out.println(checkSparse(12)) ;
		System.out.println(checkSparse(2)) ;
		System.out.println(checkSparse(3)) ;
	}
}

// 1 0 1 0