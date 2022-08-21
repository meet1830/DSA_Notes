/* 
 * 15. 3Sum 
Question:
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Constraints:
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
*/



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums.length < 3) return result;
        
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            int first = nums[i];
            
            int target = -first;
            int start = i + 1;
            int end = n - 1;
            
            while (start < end) {
                int sum = nums[start] + nums[end];
                
                if (sum > target) end--;
                else if (sum < target) start++;
                else {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(first);
                    l.add(nums[start]);
                    l.add(nums[end]);
                    
                    result.add(l);
                    
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    
                    start++;
                    end--;
                }
            }
            
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return result;
    }
}


