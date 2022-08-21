/*
Combination sum

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
*/


import java.util.*;
public class P7_leetcode_combination_sum {
  public static void combinations(int[] arr, int index, int target, ArrayList<Integer> comb) {
    if (index == arr.length) {
      if (target == 0) {
        System.out.println(comb);
      }
      return;
    }
    // pick condition
    if (arr[index] <= target) {
      comb.add(arr[index]);
      combinations(arr, index, target - arr[index], comb);
      comb.remove(comb.size() - 1);
    } 
    // not pick condition
    combinations(arr, index + 1, target, comb);
  }
  public static void main(String[] args) {
    int[] arr = {2, 3, 5};
    int target = 8;
    ArrayList<Integer> comb = new ArrayList<>();
    combinations(arr, 0, target, comb);
  }
}

/*
[2, 2, 2, 2]
[2, 3, 3]
[3, 5]
*/

// Time complexity -> k * 2^n
// space complexity -> depends on number of combinations cannot be predicted