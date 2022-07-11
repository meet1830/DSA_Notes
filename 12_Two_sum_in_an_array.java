/*
Two Sum in an Array
Given an array of integers nums and an integer target, find indices of the two numbers from the array such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Print the indices of two elements in increasing order.

(Hint: Use two pointers)

Input
line 1: contains two integers n and t denoting size of nums array and target value.

line 2: contains n separated integers denoting elements of array.

Output
Print indices of the two numbers that they add up to the target.

Constraints
2 <= nums.length <= 105

-10^8 <= nums[i] <= 10^8

-10^8 <= target <= 10^9

Time Complexity:O(nlogn)

Only one valid answer exists.

Sample Input
4 9
2 7 5 11
Sample Output
0 1
Explanation
Because nums[0] + nums[1] == 9, we print 0 1
*/

import java.util.*;

public class A2_Two_sum_in_an_array {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    long t = input.nextLong();
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextLong();
    }
    outer: 
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] + arr[j] == t) {
          System.out.println(i + " " + j);
          break outer;
        }
      }
    }
    input.close();
  }
}

// use labels or use return to exit out of function completely