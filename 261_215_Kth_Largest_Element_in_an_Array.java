/* 
 * 215. Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
*/



// O(nlogn), O(1)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}



// O(logk), O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            
            if (pq.size() > k)
                pq.poll();
        }
        
        return pq.poll();
    }
}



// avoiding unnecessary poll operations everytime in above approach
// 1. build a Min heap of size K initially.
// 2. Now if the the current element in loop is greater than the top of the Min heap, pop the heap and insert the current element
// 3. At last pop the top of the heap to get the K th largest element
// O(nlogk), O(1)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // making pq of size k initially
        for (int i = 0; i < k; i++)
            pq.add(nums[i]);
        
        // add in pq if curr element is more than peek
        for (int i = k; i < nums.length; i++)
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        
        return pq.poll();
    }
}


// Quick Select Algo - similar to quick sort just reducing the sorting space each time.This brings down tc to on avg O(n)
// average tc - O(n), worst - O(N^2), sc - O(1)
class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, j, i);
            }
        }
        // bring pivot to the correct index
        swap(nums, i + 1, r);
        return i + 1;
    }
    private int quickSelect(int[] nums, int k, int l, int r) {
        int p = partition(nums, l, r);
        
        if (p == k - 1) return nums[p];
        else if (p < k - 1) 
            // move on the right side since p is to reach kth element
            return quickSelect(nums, k, p + 1, r);
        else 
            // move to left since p is ahead of k
            return quickSelect(nums, k, l, p - 1);
    }
    public int findKthLargest(int[] nums, int k) {
        // since largest asked and not smallest
        k = nums.length - k + 1;
        return quickSelect(nums, k, 0, nums.length - 1);
    }
}