/* 
 * 350. Intersection of Two Arrays II 
Question:
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 
Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/



// refer problem 349 intersection of two arrays 1 for more methods
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // calculating frequency of both arrays
        int[] freq1 = new int[1001], freq2 = new int[1001];
        
        for(int i = 0; i < nums1.length; i++) 
            freq1[nums1[i]]++;
        for(int i = 0; i < nums2.length; i++) 
            freq2[nums2[i]]++;
        
        // taking min of the freq of that element from freq arrays and adding to list
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < freq1.length; i++) {
            if(freq1[i] > 0) {
                int minCount = Math.min(freq1[i], freq2[i]);
                // adding to list
                while(minCount --> 0)
                    list.add(i);
            }
        }
        
        // storing ans in array
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) 
            res[i] = list.get(i);
        
        return res;
    }
}


