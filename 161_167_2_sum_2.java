/* 
 * 167. Two Sum II - Input Array Is Sorted 
Question:
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:
2 <= numbers.length <= 3 * 10^4
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
*/



// brute -> two for loops

// hashmap original solution for two sum will also work but the array is sorted so consider approach taking that into account

// better approach -> take every element once and binary search for target - element
// tc -> n*logn sc -> 1 

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        
        for (int i = 0; i < numbers.length; i++) {
            int search = bSearch(target - numbers[i], numbers, i);
            if(search != -1) {
                ans[0] = i + 1;
                ans[1] = search + 1;
                
                return ans;
            }
        }
        
        return ans;
    }
    
    public int bSearch(int currTarget, int[] arr, int i) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if(arr[mid] == currTarget && mid != i) 
                return mid;
            else if(arr[mid] > currTarget) 
                r = mid - 1;
            else 
                l = mid + 1;
        }
        
        return -1;
    }
}



// optimal -> two pointers
// tc = n sc = 1
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0, last = numbers.length - 1;
        int[] res = new int[2];
        
        while (first <= last) {
            int sum = numbers[first] + numbers[last];
            
            if (sum == target)
                break;
            else if (sum < target) 
                first++;
            else 
                last--;
        }
        
        res[0] = first + 1;
        res[1] = last + 1;
        
        return res;
    } 
}