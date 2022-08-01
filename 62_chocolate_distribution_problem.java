/*
Chocolate Distribution Problem
Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :

Each student gets exactly one packet.
The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
Example 1:

Input: N = 8, M = 5 A = {3, 4, 1, 9, 56, 7, 9, 12} Output: 6 Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets : {3, 4, 9, 7, 9}.

Example 2:

Input: N = 7, M = 3 A = {7, 3, 2, 4, 9, 12, 56} Output: 2 Explanation: The minimum difference between maximum chocolates and minimum chocolates is 4 - 2 = 2 by choosing following M packets : {3, 2, 4}.

Your Task:
Input n and m in a single line Then input n integers. A single line of output, the minDiff

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
1 ≤ Ai ≤ 109
1 ≤ M ≤ N
*/

import java.io.*;
import java.util.*;
public class G2_chocolate_distribution_problem {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), s = input.nextInt();
    int arr[] = new int[n];
    for (int i=0; i<n; i++) {
      arr[i] = input.nextInt();
    }
    int diff[] = new int[n-s+1];
    Arrays.sort(arr);
    for(int i=0; i<=n-s; i++) {
      diff[i] = arr[i+s-1] - arr[i];
    }
    Arrays.sort(diff);
    System.out.println(diff[0]);
  }
}
