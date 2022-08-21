/*
Count 1 in binary array
Given a binary sorted non-increasing array arr of size N. You need to print the count of 1 in the binary array.

Try to solve the problem using binary search

Input
Each test case contains two lines. The first line contains N (size of binary array). The second line contains N elements of binary array separated by space.

Output
In new line, print the count 1 in binary array.

Constraints:
1 <= N <= 10^6 arr[i] = 0,1

Sample Input:
8
1 1 1 1 1 0 0 0
Sample Output:
5
Explaination
Number of 1 in given binary array : 1 1 1 1 1 0 0 0 is 5.
*/

import java.util.*;
import java.io.*;

public class A2_count_1_in_binary_array {
  public static void count1 (int[] arr) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] == 1) {
        l = mid + 1;
      }
      else {
        r = mid - 1;
      }
    }
    System.out.println(l);
  }
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] arr = new int[n];
    for (int i=0; i<n; i++) {
      arr[i] = input.nextInt();
    }
    count1(arr);
  }
}
