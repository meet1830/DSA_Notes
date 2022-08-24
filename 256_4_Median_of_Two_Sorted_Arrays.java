/* 
 * 4. Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6
*/



// brute -> use merge sort, merge two arrays into one using extra space, and find median
// O(m + n), O(m + n)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int s1 = nums1.length, s2 = nums2.length;
        
        int[] merged = new int[s1 + s2];
        int i = 0, j = 0, k = 0;
        
        while (i < s1 && j < s2) {
            if (nums1[i] <= nums2[j])
                merged[k++] = nums1[i++];
            else
                merged[k++] = nums2[j++];
        }
        while (i < s1)
            merged[k++] = nums1[i++];
        while (j < s2)
            merged[k++] = nums2[j++];
        
        double ans = 0;
        int n = merged.length;

        if (merged.length > 1 && (s1 + s2) % 2 == 0) 
            return ans = ((double)(merged[n / 2] + merged[n / 2 - 1]) / 2);
        else         
            return ans = merged[n / 2];
            
    }
}



// better naive -> optimize space by maintaining count of variables which are needed to calculate median instead of storing them all in an array
// O(m + n), O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int s1 = nums1.length, s2 = nums2.length;
        int limit = (s1 + s2) / 2 + 1;
        
        int count = 0;
        int i = 0, j = 0;
        double first = 0, second = 0;
        
        while (i < s1 && j < s2) {
            if (nums1[i] < nums2[j]) {
                count++;
                if (count == limit - 1)
                    first = nums1[i];
                if (count == limit)
                    second = nums1[i];
                i++;
            } else {
                count++;
                if (count == limit - 1)
                    first = nums2[j];
                if (count == limit)
                    second = nums2[j];
                j++;
            }
        }
        while (i < s1) {
            count++;
            if (count == limit - 1)
                first = nums1[i];
            if (count == limit)
                second = nums1[i];
            i++;
        }
        while (j < s2) {
            count++;
            if (count == limit - 1)
                first = nums2[j];
            if (count == limit)
                second = nums2[j];
            j++;
        }
        
        if ((s1 + s2) % 2 == 0)
            return ((double)(first + second) / 2);
        else 
            return second;
    }
}



// optimal -> binary search
// watch the video once if not remembering logic
// O(logn), O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int n1 = nums1.length, n2 = nums2.length;
        int lo = 0, hi = n1;
        
        while (lo <= hi) {
            int cut1 = lo + (hi - lo) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];
            
            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 != 0)
                    return (double)Math.max(left1, left2);
                else 
                    return (double)(Math.max(left1, left2) + Math.min(right1, right2)) / 2;
            }
            else if (left1 > right2)
                hi = cut1 - 1;
            else
                lo = cut1 + 1;
        }
        
        return (double)0;
    }
    
}