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

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt(); 
      int target = input.nextInt();
      int[] arr = new int[n];
      for(int i=0; i<n; i++) {
        arr[i] = input.nextInt();
      }
      HashMap<Integer, Integer> sum = new HashMap<>();
      int[] res = new int[2];
      for(int i = 0; i < n; i++) {
        if(sum.containsKey(target - arr[i])) {
          res[0] = sum.get(target - arr[i]);
          res[1] = i;
          System.out.println(res[0] + " " + res[1]);
          return;
        }
        else {
          sum.put(arr[i], i);
        }
      }
    }
}
