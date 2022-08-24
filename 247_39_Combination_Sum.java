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



/*
 * 39. Combination Sum
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

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
 

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
 */


/*
-> backtracking
-> here recursion tree will be taking one candidate and it has branches containing all the candidates again of the array including the selected candidate having sum with the selected candidate. this again continues and keeps on adding to the sum. the tree stops when sum reaches target or is greater than the target.
-> once rejected a candidate will not take it again to avoid duplicates like 223 and 232
-> initially rejected is 0 hence no candidate is rejected and all of them are taken into consideration each and every time in tree. and hence in example we get ans as 223 initially but not any other duplicate of that. 
-> and each time as i proceeds the amount of iterations running will decrease. if i is 2 that means that first two candidates are rejected and tree will only be built for the remaining elements.
-> res final length will not be more than 150 as per constraints. 
-> tc -> o(n!)
*/

class Solution {
  List<List<Integer>> res = new ArrayList();
  
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      backTrack(candidates, target, new ArrayList(), 0);
      return res;
  }
  
  public void backTrack(int[] candidates, int target, ArrayList<Integer> list, int rejected) {
      // needed to pass res here also but avoided it by declaring res as global
      // list -> list of numbers that are chosen
      
      if(target < 0) 
          return;
      
      if(target == 0) {
          res.add(new ArrayList(list));
          return;   
      }
      
      for (int i = rejected; i < candidates.length; i++) {
          list.add(candidates[i]);
          backTrack(candidates, target - candidates[i], list, i);
          list.remove(list.size() - 1);
      }    
  }
}