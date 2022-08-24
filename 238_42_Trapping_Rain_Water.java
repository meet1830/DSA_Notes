/* 
 * 42. Trapping Rain Water
Hard

21264

292

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 10^4
0 <= height[i] <= 10^5
*/



// consider blocks 3123 water will be filled between 3-3 regardless of height of blocks in between provided there height is less than 3
// here considered only one array for max of both the sides, if considered two different arrays for max of both sides
// then calculate same way by taking min of both blocks and considering curr block(in our maxValue), but if the curr block is more than the min block then in calculation will get neg ans, hence have to put a condition to only take the value if it is positive.
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxValue[] = new int[n];
        int max = 0; // max so far
        
        // find max for left side
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            maxValue[i] = max;
        }
        
        int ans = 0;
        max = 0;
        
        // find max for right side
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            
            // taking min from max of both the sides 
            maxValue[i] = Math.min(maxValue[i], max);
        }
        
        for (int i = 0; i < n; i++) {
            // ans will be water filled for that particular block minus the height of that block
            ans += maxValue[i] - height[i];
        }
        
        return ans;
    }
}