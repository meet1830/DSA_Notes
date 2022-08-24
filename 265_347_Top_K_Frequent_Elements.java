/* 
 * 347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.


Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/



// optimal
// store freq of all array elements using hashmap
// then store them as int[2] inside a heap
// poll out heap elements and store inside an array
// if use maxheap then delete the line if (pq.size > k then poll) but tc increases to nlogn
// O(nlogk), O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int el : nums) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for (int el : map.keySet()) {
            pq.add(new int[] {el, map.get(el)});
            
            if (pq.size() > k)
                pq.poll();
        }
        
        int[] ans = new int[k];
        
        int i = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            ans[i++] = temp[0];
        }
        
        return ans;
    }
}