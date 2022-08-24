/* 
 * 84. Largest Rectangle in Histogram
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
 

Constraints:
1 <= heights.length <= 10^5
0 <= heights[i] <= 10^4

*/


// brute -> for every element find on the left side which element is smaller and same on the right side that is the maximum size that our rectangle for that element can be made, find this out for all elements and return the max
// O(n^2), O(1)

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            for (int j = left - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
                left = j;
            }
            
            int right = i;
            for (int j = right + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    break;
                }
                right = j;
            }
            
            int area = heights[i] * (right - left + 1);
            max = Math.max(max, area);
        }
        return max;
    }
}



// finding the next smaller element array and previous smaller element array for the given input array and we have left and right boundaries found out using the nested for loop in brute force approach
// next and prev smaller elements because we know that from the current element's index till the next or prev smaller index, we will have elements which are equal to or greater then the current element and can form a rectangle. 
// hence add to the ans array + 1 the index of the prev smaller element and - 1 the next smaller element. 
// O(3n), O(n)

class Solution {
    private int[] prevSmallerElem(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) 
                st.pop();
            
            if (!st.isEmpty()) 
                ans[i] = st.peek() + 1;
            else 
                ans[i] = 0; // left boundary
            
            st.push(i);
        }
        
        return ans;
    }
    
    private int[] nextSmallerElem(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) 
                st.pop();
            
            if (!st.isEmpty()) 
                ans[i] = st.peek() - 1;
            else 
                ans[i] = n - 1; // right boundary
            
            st.push(i);
        }
        
        return ans;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int[] pse = prevSmallerElem(heights, n);
        int[] nse = nextSmallerElem(heights, n);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (nse[i] - pse[i] + 1));
        }
        
        return max;
    }
}
