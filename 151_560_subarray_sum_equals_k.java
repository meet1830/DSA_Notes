/*
 * 560. Subarray Sum Equals K 
Question:
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Constraints:
1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7
*/



class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // (sum, count of subarrays) base case for empty subarray
        map.put(0,1);
        int sum = 0, res = 0;
        for(int i : nums) {
            sum += i;
            if(map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}



class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if(sum == k) 
                count++;
            
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}