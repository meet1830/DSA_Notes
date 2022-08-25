/*
 * 1658. Minimum Operations to Reduce X to Zero
Medium

3598

77

Add to List

Share
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.


Example 1:
Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

Example 2:
Input: nums = [5,6,7,8,9], x = 4
Output: -1

Example 3:
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109
 */



/*
If it exists an answer, then it means we have a subarray in the middle of original array whose sum is == totalSum - x
subarrayLeft + (totalSum - x) + subarrayRight
x = subarrayLeft + subarrayRight
If we want to minimize our operations, then we should maximize the length of the middle subarray.
Then the question becomes: Find the Longest Subarray with Sum Equals to TotalSum - X
We could simply use Map + Prefix Sum to get it
*/
class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int i : nums) 
            target += i;
        
        // base case -> if target is 0 then map will never contain sum - target value as sum - target is only increasing and map does not contain that
        if (target == 0) 
            return nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0, maxLen = -1;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                maxLen = Math.max(maxLen, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}



// sliding window technique - maximum subarray with sum target - x
// here can consider a subarray (of maximum length) whose sum is target - x in the input array. all other are elements to be removed. so will find max length of subarray of sum target - x and return length of total array size - length of subarray. length of subarray is to be maximized and hence removal of elements from both sides will be minimized

class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        
        int totalSum = 0;
        for (int i : nums)
            totalSum += i;
        
        // if totalSum == x that means all the elements are to be taken then the target becomes 0 and in while currSum will never be equal to target hence base condition
        if (totalSum == x) 
            return n;
        
        int target = totalSum - x;
        
        int start = 0, end = 0;
        int currSum = 0, maxLen = 0;
        
        while (end < n) {
            currSum += nums[end];
            
            while (start < n && currSum > target) {
                currSum -= nums[start++];
            }
            
            if (currSum == target) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            
            end++;
        }
        
        return maxLen == 0 ? -1 : n - maxLen;
    }
}