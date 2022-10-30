/* 
 * 239. Sliding Window Maximum
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
Example 2:
Input: nums = [1], k = 1
Output: [1]
 

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length

*/


// brute
// O(n^2), O(1)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                ans[i] = Math.max(ans[i], nums[j]);
            }
        }
        return ans;
    }
}


// optimal -> using deque the peek of it will always contain the maximum element for that subarray, since we will be checking and removing the elements that are less than
// O(n + n), O(k)
// after completion, all elements are added and removed once from deque hence 2n
// deque size never goes more than k
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();z
        int p = 0;
        
        for (int i = 0; i < n; i++) {
            // remove out of bound elements first
            // every element is added once in deque and removed from it afterwards, hence can check out of bound from index
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) 
                dq.pollFirst();
            
            // remove elements which are less then the current element for max
            // same logic as next greater element
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            
            dq.offer(i);
            
            // add first time when subarray size becomes equal to k and then add at every iteration
            if (i + 1 >= k)
                ans[p++] = nums[dq.peekFirst()];
        }
        
        return ans;
    }
}