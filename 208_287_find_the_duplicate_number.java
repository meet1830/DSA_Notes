/* 
287. Find the Duplicate Number 
Question:
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
 
Constraints:
1 <= n <= 10^5
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.

Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
*/



/*
brute -> sort the array and linearly traverse the array to find the duplicate
tc - nlogn + n sc - 1
better -> use frequency array. if freq more than 1 return the element
tc - n sc - n
xor method wont work due to test cases generated to violate that. for example 2, 2, 2, 2 wont return 2 if xor method is used.
optimal -> taking a look at question numbers start from 1, number length is from 1 to n.
hence can use linkedlist cycle method
here cycle detection loop works as: first value x then next value at index x in the array. and for fast pointer, if value x then two times the same. 
*/

// Binary search solution
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(arr);
        
        // applying bsearch
        int n = arr.length;
        int l = 1, r = n - 1;
        while (l < r) {
            // here input value from 1 to n
            int mid = (l + (r - l) / 2);
            
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] <= mid) 
                    c++;
            }
            
            if (c > mid)
                r = mid;
            else 
                l = mid + 1;
        }
        return l;
    }
}



class Solution {
    public int findDuplicate(int[] nums) {
        // initialize slow and fast pointers
        int slow = nums[0], fast = nums[0];
        
        // detecting cycle 
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);
            
        // keep slow where it was and fast to first element
        fast = nums[0];
        
        // again run loop to meet them both but this time slow and fast both move by 1
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        // return slow or fast
        return fast;
    }
}

