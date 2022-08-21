/*
Max Sum Subarray of size K
Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K

Input
First line contains 2 integers N and K Second line contains N integers denoting elements of array

Output
Print maximum sum subarray of size K

Constraints:
1 <= N <= 1000000 1 <= K <= N -10000 <= Arr[i] <= 10000

Sample Input:
4 2
100 200 300 400
Sample Output:
700
*/

import java.util.*;

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = input.nextInt();

    int[] pSum = new int[n];
    pSum[0] = arr[0];
    for (int i = 1; i < n; i++)
      pSum[i] = arr[i] + pSum[i - 1];

    int max = Integer.MIN_VALUE, temp = max;
    int l = 0, r = k - 1;
    while (r < n) {
      if (l == 0)
        temp = pSum[r];
      else
        temp = pSum[r] - pSum[l - 1];
      max = Math.max(temp, max);
      l++;
      r++;
    }

    System.out.println(max);
  }
}

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = input.nextInt();

    int sum = 0;
    for (int i = 0; i < k; i++)
      sum += arr[i];

    int curr_sum = sum;
    for (int i = k; i < n; i++) {
      curr_sum += arr[i] - arr[i - k];
      sum = Math.max(sum, curr_sum);
    }

    System.out.println(sum);
  }
}