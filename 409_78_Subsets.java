/*
78. Subsets
Medium

12403

178

Add to List

Share
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/


// using power set algo to find all subsets
// consider decimal to binary representations of all no from 0 to limit - 1
// for eg if limit is 8, then 0 = 000 and 6 = 101 and 8 = 111
// put the array element where there is 1 and do not put where there is 0
// use classic method of division by 2 to convert from decimal to binary
// if remainder is 1 then put the element in arraylist and if it is 0 then do not put
// O(n*2^n), O(2^n)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int limit = (int)Math.pow(2, n);
        for (int i = 0; i < limit; i++) {
            List<Integer> list = new ArrayList<>();
            int temp = i;
            for (int j = n - 1; j >= 0; j--) {
                int r = temp % 2;
                temp = temp / 2;
                if (r == 0) {
                    continue;
                } else {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}



// backtracking
// O(n*2^n + nlogn) -> creating and adding deepcopy to ans
// O(2^n*n) -> total number of subsets * size of each
class Solution {
    private void findSub(int[] nums, int idx, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            findSub(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSub(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
}