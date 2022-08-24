/* 
 * 18. 4Sum
Medium

7307

856

Add to List

Share
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9

*/



// brute -> sort array -> 3 loops plus binary search - use hashset to store them to prevent duplicates

// optimal -> take two nested loops and in that take third loop for two pointers and search for target
// consider testcase -> [1000000000,1000000000,1000000000,1000000000] -294967296
// testcase is made such that if take int then will override the ans and result in a result but the correct ans is none. hence take long
// tc -> n^3 + nlogn sc -> 1

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>(); 
        
        // base
        if (n < 4)
            return ans;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < n; i++) {
            long target_1 = target - nums[i];
            
            for (int j = i + 1; j < n; j++) {
                long target_2 = target_1 - nums[j];
                
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = nums[left] + nums[right];
                    
                    if (sum < target_2) 
                        left++;
                    
                    else if (sum > target_2)
                        right--;
                    
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        
                        ans.add(list);
                        
                        // avoiding duplicates
                        while (left < right && nums[left] == nums[left + 1]) 
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        
                        left++; right--;
                    }
                    
                }
                
                // avoid duplicates for j
                while (j < n - 1 && nums[j] == nums[j + 1]) 
                    j++;
            }
            
            // avoid duplicates for i
            while (i < n - 1 && nums[i] == nums[i + 1]) 
                i++;
        }
        
        return ans;
    }
}