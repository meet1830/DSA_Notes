/* 
 * 2342. Max Sum of a Pair With Equal Sum of Digits
Medium

348

4

Add to List

Share
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

 

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
*/



// brute -> using hashmap to store sum of digits of number and priority queue to store the max values and not letting the size of pq increase more than 2 (we just want one max sum pair) if in case the freq of numbers having same sum of digits is more than 2, to get the max out of them.
// now iterate over all the sum values and sum up the values of pq for each and find max sum.
// O(nlogn -> (n for loop and n times operations in pq)), O(n -> (space of map and pq inside it))

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int sum = 0, temp = nums[i];
            
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            
            if (map.containsKey(sum)) {
                PriorityQueue<Integer> pq = map.get(sum);
                pq.offer(nums[i]);
                
                if (pq.size() > 2)
                    pq.poll();
                
                map.put(sum, pq);
            }
            else {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.offer(nums[i]);
                map.put(sum, pq);
            }
        }
        
        int sum = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> pq = entry.getValue();
            int tempSum = 0;
            if (pq.size() == 2) {
                tempSum = pq.poll() + pq.poll(); 
            }
            if (sum < tempSum)
                sum = tempSum;
        }
        
        return sum == 0 ? -1 : sum;
    }
}



// optimal -> use hashmap, but instead of pq just put integer maxvalue in that.
// if entry does not exist in map, create and add that nums as value
// if entry exists then sum up the new nums with value nums in separate varaible and put back the max(old nums, new nums) in map. repeat and at the end we have max sum.
// O(n), O(n)
class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i], digitSum = 0, tempSum = 0;
            
            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
            
            if (map.containsKey(digitSum)) {
                tempSum = map.get(digitSum) + nums[i];
                
                if (maxSum < tempSum)
                    maxSum = tempSum;
                
                map.put(digitSum, Math.max(map.get(digitSum), nums[i]));
            }
            
            else {
                map.put(digitSum, nums[i]);
            }
        }
        
        return maxSum == 0 ? -1 : maxSum;
    }
}