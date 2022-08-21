/* 
 * 119. Pascal's Triangle II 
Question:
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]

Constraints:
0 <= rowIndex <= 33

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
*/



class Solution {
    public List<Integer> getRow(int rowIndex) {
        // detailed explanation in pascal triangle I
        List<Integer> res = new ArrayList<Integer>(rowIndex);
        
        // first element of triangle for any row is always 1
        res.add(1);
        int temp = 1;
        
        // works only for rowindex upill 29
        // as number of rows and column is same always
        // for(int i = 0; i < rowIndex; i++) {
            // temp *= (long)(rowIndex - i);
            // temp /= (long)(i + 1);
            
        
        // divide nCr / nC(r-1) to get factor for division -> (n - i + 1) / i
        // temp = previous * factor
        for(int i = 1; i <= rowIndex; i++) {
            temp = (int) (((long)res.get(i - 1) * (rowIndex - i + 1)) / i);
            res.add(temp);
        }
        
        return res;
    }
}


