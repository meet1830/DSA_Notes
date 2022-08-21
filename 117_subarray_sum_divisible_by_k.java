/*
Subarray Sums Divisible by K
Given an integer array nums and an integer k, print the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

Input:
The first line contains a two integers n(size of array n) and k Second line contains n spaced integers

Output:
Print count of subarrays divisible by k

Constraints
1 <= nums.length <= 3 * 104
-10^4 <= nums[i] <= 10^4
2 <= k <= 10^4
Sample Input 1
6 5 4 5 0 -2 -3 1

Sample Output 1
7

Explanation
There are 7 subarrays with a sum divisible by k = 5: [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Sample Input 2
1 9
5
Sample Output 2
0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = input.nextInt();

    System.out.println(solution(arr, k));
  }

  public static int solution(int[] arr, int k) {
    int ans = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    int rem = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      rem = sum % k;
      if (rem < 0)
        rem += k;

      if (map.containsKey(rem)) {
        ans += map.get(rem);
        map.put(rem, map.get(rem) + 1);
      } else
        map.put(rem, 1);
    }

    return ans;
  }
}