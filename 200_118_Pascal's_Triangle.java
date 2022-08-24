/* 
 * 118. Pascal's Triangle
Easy

7519

248

Add to List

Share
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
*/



/*
3 variations in the question
    1. print rth and cth index of pascals triangle
            use formula (r - 1)C(c - 1)
            tc -> O(n) sc -> O(1)
    2. print the rth row of the pascal triangle
            use the same formula in smarter way 
            to optimize the formula 
            in above formula keep the number of terms in num same as den
            6C2 = 6*5 / 2*1; 7C3 = 7*6*5 / 3*2*1;
            and observing closely for a row we are just 
            multiplying (+1) number in num and (-1) in den while traversing
            and calculating
            can do this with the snippet
            for(int i = 0; i < k; i++) {
                res *= (n - i);
                res /= (i + 1);
            }
            tc -> O(N) sc -> O(n)
    3. this question
*/


class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // row defining current row and prev defining previous row
        List<Integer> row, prev = null;
        
        for(int i = 0; i < numRows; i++) {
            row = new ArrayList<Integer>();
            
            // j <= i as rows is always equal to columns
            for(int j = 0; j <= i; j++) {
                // for first and last column value is always equal to 1
                if(j == 0 || j == i)
                    row.add(1);
                else 
                    row.add(prev.get(j - 1) + prev.get(j));
            }
            
            prev = row;
                
            res.add(row);
        }
        
        return res;
    }
}