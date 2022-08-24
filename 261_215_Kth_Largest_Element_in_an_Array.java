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



// quick select algo
// avg case tc -> O(n), worst case -> O(n^2), sc -> O(1)
class Solution {
    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public int partition (int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // to get the pivot element to correct index
        swap(arr, i + 1, r);
        return i + 1;
    }
    public int quickSelect(int[] arr, int k, int lo, int hi) {
        int p = partition(arr, lo, hi);
        
        if (p == k - 1)
            return arr[p];
        else if (p < k - 1)
            return quickSelect(arr, k, p + 1, hi);
        else 
            return quickSelect(arr, k, lo, p - 1);
    }
    public int findKthLargest(int[] nums, int k) {
        int newK = nums.length- k + 1;
        return quickSelect(nums, newK, 0, nums.length - 1);
    }
}