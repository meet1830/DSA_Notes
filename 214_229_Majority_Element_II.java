/* 
 * 229. Majority Element II
Medium

5726

302

Add to List

Share
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
 

Follow up: Could you solve the problem in linear time and in O(1) space?
*/



// brute -> two nested loops 

// better -> use freq array or hashmap same way as used in majority element 1

/*
// optimal -> use boyer moore voting algo 
at max two elements in an array can occur more than floor of n/3 times.
here also as per majority element 1 if count is 0 then we are changing elements
*/

// as per algorithm cannot be sure if the returned ele1 and ele2 are occuring more than n / 3 times hence have to check and then put in ans

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = -1, ele2 = -1;
        int cnt1 = 0, cnt2 = 0;
        
        for (int x : nums) {
            if (x == ele1)
                cnt1++;
            else if (x == ele2)
                cnt2++;
            else if (cnt1 == 0) {
                ele1 = x;
                cnt1 = 1;
            }
            else if (cnt2 == 0) {
                ele2 = x;
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        
        cnt1 = 0; cnt2 = 0;
        for (int i : nums) {
            if (i == ele1) cnt1++;
            else if (i == ele2) cnt2++;
        }
        
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if (cnt1 > n / 3) ans.add(ele1);
        if (cnt2 > n / 3) ans.add(ele2);
        
        return ans;
    }
}