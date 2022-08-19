/*
Maximum Contiguous Subarray Sum
Given an array, A of length N, find the contiguous subarray within A which has the largest sum.

Input
The first line of each test case contains an integer n, the length of the array A.
and the next line contains n integers.

Constraints:
1 <= N <= 10^5
-10^6 <= A[i] <= 10^6

Output
Output an integer representing the maximum possible sum of the contiguous subarray.

Example
Input:
5
1 2 3 4 -10
Output:
10
Explaination:
1+2+3+4=10
*/

import java.util.*;

public class G1_Maximum_Contiguous_Subarray_Sum {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), sum=0;
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = input.nextInt();
      if(arr[i]>=0) sum+= arr[i];
    }
    Arrays.sort(arr);
    if(arr[n-1]<0) {
      System.out.println(arr[n-1]);
    } 
    else System.out.println(sum);
    input.close();
  }
}

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    long sum = 0;
    long max = -999999; 
    // max == some big neg number
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      sum = sum + a[i];
      if (max < sum) {
        max = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
    }
    System.out.println(max);
  }
}