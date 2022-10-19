/* 
 * 46. Permutations
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/



// brute -> using extra space
// recursion eg [1,2,3]
// for first level -> can take 1 or 2 or 3
// second level for 1 -> 1,2 1,3
// third level for 1,2 -> 1,2,3 -> ans
// third level for 1,3 -> 1,3,2 -> ans
// second level for 2 -> 2,1 or 2,3
// third level for 2,1 -> 2,1,3 -> ans
// third level for 2,3 -> 2,3,1 -> ans
// second level for 3 -> 3,1 3,2
// third level for 3,1 -> 3,1,2 -> ans
// third level for 3,2 -> 3,2,1 -> ans
// use visited to identify which of them is taken so not take that for the call and remove them at the end of recursion
// O((n! * n) + n -> number of permutations * for loop for each permutation, making deep copy)
// O(n + n -> visited[n] + list.size() = n)
// auxiliary space -> O(n) -> depth of recursion -> it happens in levels 

class Solution {
    public void getPerm(int[] nums, List<Integer> list, boolean[] visited, List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                getPerm(nums, list, visited, ans);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[7];
        
        getPerm(nums, new ArrayList<Integer>(), visited, ans);
        
        return ans;
    }
}



// optimal -> without using extra space
// recursion first level -> first index swapping -> 1-1 1-2 1-3 -> 1,2,3 2,1,3 3,2,1
// second level for 1,2,3 -> 2-2 2-3 -> 1,2,3 1,3,2
// will go to third level but will swap with itself for every call
// second level for 2,1,3 -> 1-1 1-3 -> 2,1,3 2,3,1
// third level
// second level for 3,2,1 -> 2-2 2-1 -> 3,2,1 3,1,2
// third level
// O(n! * n), O(n) - since storing list's deepcopy it is to be considered in sc
// O(n) -> auxiliary space -> recursion level

class Solution {
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void getPerm(int[] nums, int idx, List<List<Integer>> ans) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            
            for(int x : nums) 
                list.add(x);
            
            ans.add(list);
            
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            getPerm(nums, idx + 1, ans);
            swap(nums, i, idx);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        getPerm(nums, 0, ans);
        
        return ans;
    }
}
