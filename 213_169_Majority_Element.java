/* 
 * 169. Majority Element
 Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/


// brute -> take first element and iterate over the array for it to find it count, if more than floor of n / 2, then return that element.

// better -> take frequency array or hashmap to store count or frequency of each element in the array and traverse through them to find out the element.
// tc -> o(n) for freq arr and o(nlogn) for hashmap

// optimal -> moore's voting algo
// algo principle -> if the majority element was x, and it by any chance appears on the left prefix, then its count at max can be (lengthofleftprefix/2). and since it has to appear more than n / 2 times, it is bound to appear as a majority in the last suffix. if it does not appear on the left as a majority, then it is clear that it will be the majority at the right.

class Solution {
    public int majorityElement(int[] nums) {
        int ele = 0, c = 0;
        for (int x : nums) {
            if (ele == x) 
                c++;
            else if (c == 0) 
                ele = x;
            else c--;
        }
        return ele;
    }
}