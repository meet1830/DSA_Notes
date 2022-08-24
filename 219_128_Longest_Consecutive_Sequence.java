/* 
 * 128. Longest Consecutive Sequence
Medium

12686

529

Add to List

Share
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
*/



// brute solution - sorting and linear traversal

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        
        // base
        if (n < 1)
            return 0;
        
        Arrays.sort(nums);
        
        int prev = nums[0], count = 1, maxCount = 1;
        
        for (int i = 1; i < n; i++) {
            if(nums[i] == prev + 1)
                count++;
            
            // if duplicate then continue with same count
            
            else if (nums[i] != prev) 
                count = 1;
            
            prev = nums[i];
            maxCount = Math.max(count, maxCount);
        }
        
        return maxCount;
    }
}


// optimal solution using hashset
// add all elements to the hashset - traverse array and if set contains 1 less than curr element that means it is not the minimum element for that sequence. if set does not contains one less than curr, that means min is found and can now proceed to calculate length by checking if set contains element 1 more than curr. if yes then increment length. 
// tc -> n(adding to set) + n(iterating nums) + n(while loop) // sc -> n

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        
        // base
        if (n < 1)
            return 0;
        
        HashSet<Integer> set = new HashSet<>();
        int len = 0, maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i] - 1)) {
                len = 0;
                int val = nums[i];
                while (set.contains(val++))
                    len++;
            }
            
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}



// optimal solution -> using hashmap
// in hashmap put all the values and mark them as true
// now traverse the array and if map has curr element - 1 that means it id not the starting point of that sequence. hence mark it as false. at the end all for the sequences of the array only starting points will have true.
// count and figure out longest sequence.
class Solution {
    public int longestConsecutive(int[] nums) { 
        int n = nums.length;   
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for (int x : nums) 
            map.put(x, true);
        
        // finding starting points in the array for different sequences
        for (int x : nums) {
            if (map.containsKey(x - 1))
                map.put(x, false);
        }
        
        // counting length of longest sequence from all sequences
        int len = 0, maxLen = 0;
        for (int x : nums) {
            if (map.get(x) == true) {
                len = 1;
                while (map.containsKey(x + 1)) {
                    len++;
                    x++;   
                }
                
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}