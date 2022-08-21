/* 
 * 239. Sliding Window Maximum 
Question:
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
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length
*/



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> l = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            if(!l.isEmpty() && l.peek() < i - k + 1) {
                // not part of current window
                l.poll();
            }
            
            while(!l.isEmpty() && nums[i] >= nums[l.peekLast()]) {
                l.pollLast();
                // remove rear
            }
            
            l.offer(i);
            
            if(i - k + 1 >= 0) res[i - k + 1] = nums[l.peek()];
        }
        
        return res;
    }
}