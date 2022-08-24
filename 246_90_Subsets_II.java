/* 
 * 90. Subsets II
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/


// brute -> generating subsets and storing them in sorted order in hashset to remove duplicates. then copying them in final ans
// O(2^n + n), O(2^n * n -> storing 2^n number of subsets of size n in hashset + n -> size of each list)

class Solution {
    public void findSub(int[] nums, int idx, HashSet<List<Integer>> set, List<Integer> list) {
        if (idx == nums.length) {
            ArrayList l = new ArrayList<>(list);
            Collections.sort(l);
            set.add(l);
            
            return;
        }
        
        list.add(nums[idx]);
        findSub(nums, idx + 1, set, list);
        list.remove(list.size() - 1);
        findSub(nums, idx + 1, set, list);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        
        findSub(nums, 0, set, new ArrayList<>());
        
        for (List<Integer> x : set) 
            ans.add(x);
        
        return ans;
    }
}



// optimal -> we will avoid duplicates with the help of recursion. the recursion will work in levels of size of list. when forming first level of lists of size 1, if we encounter an element same as the previous one, we will not add it.
// for eg we have nums = 1, 2, 2, 2, 3, 3
// then first level recursion lists -> 1, 2, 3
// in second level of size 2, if we have taken the same element once then we will not take it again. second level lists -> 1,2 1,2 1,2 1,3 1,3. here we will take 1,2 1,3
// similarly in third level if element is taken once then dont take it again
// for 1,2 -> 1,2,2 1,2,2 1,2,3 1,2,3 we will take 1,2,2 1,2,3
// for 1,3 -> same logic
// at the first line creating a deep copy of list and adding it to ans (creating global variable will also not help lists will be empty in the ans)
// adding empty list first and then subsets will get added without duplicates
// i == i - 1 comparing prev element and since in recusion, i should not be equal to same element
// O(nlogn + 2^n * n(creating and adding deepcopy to ans)), 
// O(2^n * n -> total number of subsets * size of each)
// auxiliary space -> O(n) -> will do till depth n -> six levels in this case

class Solution {
    public void findSub(int[] nums, int idx, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1])
                continue;
            
            list.add(nums[i]);
            findSub(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        findSub(nums, 0, new ArrayList<>(), ans);
        
        return ans;
    }
}
