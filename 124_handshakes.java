/*
 * Handshakes
We have N persons sitting on a round table. Any person can do a handshake with any other person.

       1  
    2     3
       4
Handshake with 2-3 and 1-4 will cause cross.

In how many ways these N people can make handshakes so that no two handshakes cross each other. N would be even.

Example 1:

Input: N = 2 Output: 1 Explanation: {1,2} handshake is possible.

Example 2:

Input: N = 4 Output: 2 Explanation: {{1, 2}, {3, 4}} are the two handshakes possible. {{1, 3}, {2, 4}} is another set of handshakes possible.

Your Task:
Input a single integer n Output a single integer the total number of handshakes possible so that no two handshakes cross each other if n is even, else print "Invalid"

Expected Time Complexity: O(2N)
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 30
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      
      if(n % 2 != 0) System.out.println("Invalid");
      else {
        int ans = count(n);
        
        System.out.println(ans);
      }
	}
  static int count(int N) 
    { 
        // base case
        // if N is Odd return 0  
    	if(N%2==1) return 0;
    	
    	// if N is zero return 1
    	else if(N==0)
    		return 1;
    	int res=0;
    	
    	// for each even i from 0 to N
    	for(int i=0;i<N;i+=2)
    	    // add the product of count(i) * count(N-2-i)
    		res+=count(i)*count(N-2-i);
    	return res;
    }
}

// Java program to count number
// of ways to connect n (where
// n is even) points on a circle
// such that no two connecting
// lines cross each other and
// every point is connected with
// one other point.
import java.util.*;

public class Main {

    // A dynamic programming
    // based function to find
    // nth Catalan number
    static int catalanDP(int n) {
        // Table to store
        // results of subproblems
        int[] catalan = new int[n + 1];

        // Initialize first
        // two values in table
        catalan[0] = catalan[1] = 1;

        // Fill entries in catalan[]
        // using recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++)
                catalan[i] += catalan[j] *
                        catalan[i - j - 1];
        }

        // Return last entry
        return catalan[n];
    }

    // Returns count of ways to
    // connect n points on a circle
    // such that no two connecting
    // lines cross each other and
    // every point is connected
    // with one other point.
    static int countWays(int n) {
        // Throw error if n is odd
        if (n < 1) {
            System.out.println("Invalid");
            return 0;
        }

        // Else return n/2'th
        // Catalan number
        return catalanDP(n / 2);
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n % 2 != 0)
            System.out.println("Invalid");
        else
            System.out.println(countWays(n) + " ");
    }
}
