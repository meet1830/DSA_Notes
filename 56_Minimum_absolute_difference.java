

//                  NOT ALL TEST CASES PASSING


/*
Minimum Absolute Difference
Given an array of size N, find the index which partitions the arrays into 2 subarrays such that absolute difference of their sums is minimized.

If we partition with respect to index i (1<=i<=N) subarrays will be:- (A[1],A[2],A[3].....A[i-1]) , (A[i+1],A[i+2],......A[n])

Input
First line of input contains the size of array N, next line contains N space separated integers depicting the values of array.

Output
Print the index for minimum absolute difference. If more than one answer exists print the minimum index.

Constraints:
1 <= N <= 100000 0 <= A[i] <= 10000000

Sample Input:
4
1 2 3 4
Sample Output:
3
Explaination
For index 1 absolute difference = 2 + 3 + 4 = 9 For index 2 absolute difference = 3 + 4 - 1 = 6 For index 3 absolute difference = 4 - 1 - 2 = 1 For index 4 absolute difference = 1 + 2 + 3 = 6
*/

import java.util.*;

public class G2_Minimum_absolute_difference {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    long[] arr = new long[n];
    for (int i = 0; i < n; i++)
      arr[i] = input.nextLong();
    long s1 = 0, s2 = 0;
    long[] diff = new long[n];
    for (int i = 0; i < n; i++) {
      s1 = 0;
      s2 = 0;
      for (int j = 0; j < i; j++) {
        s1 += arr[j];
      }
      // System.out.print("s1="+s1);
      for (int k = i + 1; k < n; k++) {
        s2 += arr[k];
      }
      // System.out.println(" s2="+s2);
      diff[i] = s2 - s1;
    }
    long[] sd = new long[n];
    for (int i = 0; i < n; i++) {
      sd[i] = diff[i];
    }
    Arrays.sort(sd);
    if (n > 1) {
      for (int i = 0; i < n; i++) {
        if (sd[0] == diff[i]) {
          System.out.println(i);
          break;
        }
      }
    } else
      System.out.println(arr[0]);
    input.close();
  }
}


// using prefix and suffix sum arrays, finding min difference between them
// O(n), O(2n)
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }

    int[] prefixSum = new int[n];
    int[] suffixSum = new int[n];
    prefixSum[0] = arr[0];
    suffixSum[n - 1] = arr[n - 1];
      
    int p = 1, s = n - 2;
    while (p < n) {
      prefixSum[p] = prefixSum[p - 1] + arr[p++];
      suffixSum[s] = suffixSum[s + 1] + arr[s--];
    }
    
    int min = Integer.MAX_VALUE, minIdx = -1;
    for (int i = 0; i < n; i++) {
        int temp = Math.abs(prefixSum[i] - suffixSum[i]);
        if (temp < min) {
            min = temp;
            minIdx = i;
        }
    }
      
    System.out.println(minIdx + 1);
  }
}