/* 
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/



// brute -> use hashset for preventing duplicates

class Solution {
    public void findSum(int[] candidates, int target, int idx, List<Integer> list, HashSet<List<Integer>> set) {
        if (target < 0)
            return;
        
        if (target == 0) {
            ArrayList l = new ArrayList<>(list);
            Collections.sort(l);
            set.add(l);
            
            return;
        }
        
        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            findSum(candidates, target - candidates[i], i + 1, list, set);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        
        findSum(candidates, target, 0, new ArrayList<>(), set);
        
        for (List<Integer> x : set) 
            ans.add(x);
        
        return ans;
    }
}



// optimal -> same logic of subsets 2 and combination sum 1 problems

class Solution {
    public void findSum(int[] candidates, int target, int idx, List<Integer> list, List<List<Integer>> ans) {
        if (target < 0)
            return;
        
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i != idx && candidates[i] == candidates[i - 1])
                continue;
            
            list.add(candidates[i]);
            findSum(candidates, target - candidates[i], i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        List<List<Integer>> ans = new ArrayList<>();
        findSum(candidates, target, 0, new ArrayList<>(), ans);
        
        return ans;
    }
}
