/*
Merge Sorted Array
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 
Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-10^9 <= nums1[i], nums2[j] <= 10^9

Follow up: Can you come up with an algorithm that runs in O(m + n) time?
*/



/*
    interviewer never tells to not use extra space. brute -> use an extra array, place all elements from both array in that array and then sort the array using .sort() method and then copy the elements in the original array updating it.
    tc -> nlogn + n(for putting elements in new array) + n(for putting back in original array)
    sc -> n
    
    better -> intuition based on that both the arrays we have is in sorted fashion
    hence if a1[i] > a2[0] then swap the elements. and then sort the second array. at the last element of first array we would have the first array such that if placed before second array, the group would be sorted.
    tc -> traversing a1 * sorting a2
    
    optimal -> GAP algo
    initial gap = (m+n)/2 if remainder then take ceil
    so first pointer at 0 other at 4th index if first greater than swap
    move both pointers ahead if greater then swap
    if not greater than dont swap move pointers ahead
    if next pointer out of bound then stop
    next gap = previous gap / 2 and again continue the same process
    when gap = 1 has completed stop the process
    the pointers have to move from one array to the other to complete the iteration
    search gfg merging two sorted array in o(1) space to see the code
*/


class Solution {
    // O(m) * nlogn + O(n), O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < m; i++) {
            if (nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
                Arrays.sort(nums2);
            }
        }
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
    }
}


// O(m + n), O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // putting nums2[] elements in nums1[]
        for(int i = m; i < (m + n); i++) {
            nums1[i] = nums2[i - m];
        }
        
        // calculating gap for first iteration and taking its ceil
        int gap = nums1.length / 2 + (nums1.length % 2);
        
        while(gap >= 1) {
            int start = 0, end = gap;
            while(end < nums1.length) {
                // swap
                if(nums1[start] > nums1[end]) {
                    int temp = nums1[start];
                    nums1[start] = nums1[end];
                    nums1[end] = temp;
                }
                
                start++;
                end++;
            }
            
            // update gap
            if(gap > 1) {
                int temp = gap;
                gap = temp / 2 + (temp % 2);
            }
            else
                break;
        }
    }
}


// gap algo when two arrays of size m and n respectively are given and have to be sorted distinctly, means sorted exchanging elements within the two arrays such that when both the arrays are placed side by side, the elements are sorted
// for eg => a1 = {1, 4, 5, 6, 10}, a2 = {2, 3, 9}
// ans => a1 = {1, 2, 3, 4, 5}, a2 = {6, 9, 10}

import java.util.*;
public class Main {
    public static void swap(int[] a1, int[] a2, int i, int j) {
        int temp = a1[i];
        a1[i] = a2[j];
        a2[j] = temp;
    }
    public static void mergeTwoSortedArrays(int[] a1, int[] a2) {
        int m = a1.length, n = a2.length;
        int gap = ((m + n) / 2) + ((m + n) % 2);
        // int gap =(int) Math.ceil((double)(n + m) / 2.0);
        while (gap > 0) {
            int start = 0, end = gap;
            while (end < (m + n)) {
                if (end < m && a1[start] > a1[end]) swap(a1, a1, start, end);
                else if (end >= m && start < m && a1[start] > a2[end - m]) swap(a1, a2, start, end - m);
                else if (end >= m && start >= m && a2[start - m] > a2[end - m]) swap(a2, a2, start - m, end - m);
                start++; end++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
            // gap =(int) Math.ceil((double) gap / 2.0);
        }
    }
    public static void main(String[] args) {
        int[] a1 = {1, 4, 5, 6, 10}, a2 = {2, 3, 9};
        mergeTwoSortedArrays(a1, a2);
        for (int x : a1) System.out.print(x + " ");
        System.out.println();
        for (int x : a2) System.out.print(x + " ");
    }
}