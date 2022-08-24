/* 
31. Next Permutation 
Question:
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1] 

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100
*/



// brute force
// finding all subsets storing them in a list, finding the input array, and returning the array after it.
// O(n!), O(n), O(n) for recursion levels
// will work only till string length 8, then TLE

class Solution {
    public String swap(String s, int x, int y) {
        char[] arr = s.toCharArray();
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        String res = "";
        for (char i : arr) {
            res += i;
        }
        return res;
    }
    public void getPerm(String s, List<String> ans, int idx, List<Character> list) {
        if (idx == s.length()) {
            String add = s;
            ans.add(add);
            return;
        }
        
        for (int i = idx; i < s.length(); i++) {
            s = swap(s, idx, i);
            getPerm(s, ans, idx + 1, list);
            s = swap(s, idx, i);
        }
    }
    public void nextPermutation(int[] nums) {
        String s = "";
        for (int i : nums)
            s += i;
        
        List<String> ans = new ArrayList<>();
        getPerm(s, ans, 0, new ArrayList<Character>());
        
        Collections.sort(ans, (a,b) -> a.compareTo(b));
        
        int i = 0;
        String temp = "";
        for (String x : ans) {
            if (x.equals(s)) {
                if (i == ans.size() - 1) 
                    temp = ans.get(0);
                else 
                    temp = ans.get(i + 1);
            } 
            i++;
        }
        
        for (i = 0; i < s.length(); i++) 
            nums[i] = temp.charAt(i) - '0';
    }
}




// Algorithm
    // step 1: traverse from reverse find index of a[i] < a[i + 1]
    // step 2: again reverse traverse find index a[i] > a[idx in first step]
    // step 3: swap both indexes
    // step 4: sort/reverse all elements after the index found in step 1
    // edge case: will not work for last permutation -> all elements reversed
    // perform step 4 and return first permutation
// O(n + n + n) -> first index + second index + reversing, O(1) -> no extra space
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        for (int i = n - 2; i >= 0; i--) {
            // 1. calculating first index = i
            if (nums[i] < nums[i + 1]) {
                // 2. calculating second index = j
                int j = n - 1;
                while (nums[j] <= nums[i])
                    j--;
                
                // 3. swapping
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                // 4. sorting
                Arrays.sort(nums, i + 1, n);
                
                return;
            }
        }
        
        // edge case -> nums reverse sorted
        Arrays.sort(nums);
    }
}