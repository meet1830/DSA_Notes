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
            formula nCr = n! / (r! * (n-r)!)
            tc -> O(n) sc -> O(1)
    2. print the rth row of the pascal triangle
        nth row -> r-1_C_0, r-1_C_1, r-1_C_2 ... r-1_C_r-1
            use the same formula in smarter way 
            to optimize the formula 
            in above formula keep the number of terms in num same as den
            6C2 = 6*5 / 2*1; 7C3 = 7*6*5 / 3*2*1;
            and observing closely for a row we are just 
            multiplying (+1) number in num and (-1) in den while traversing
            and calculating
            can do this with the snippet
            for(int i = 0; i < k; i++) {
                res *= (n - 1 - i);
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


// PRINT KTH ROW OF A PASCALS TRIANGLE

// Approach 1
// O(n), O(n)
// binomial function runs overall n times
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int r = 0; r <= n; r++) {
            ans.add(binomial(n, r));
        }
        for (int x : ans) System.out.print(x + " ");
        System.out.println();
    }
    private static int binomial(int n, int r) {
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r;
        int ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= n - i;
            ans /= i + 1;
        }
        return ans;
    }
}
// 1 4 6 4 1

// Approach 2
// using the property nCr = (nCr-1 * (n - r + 1)) / r
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> ans = kthRow(n);
        for (int x : ans) System.out.print(x + " ");
        System.out.println();
    }
    private static ArrayList<Integer> kthRow(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int prev = 1;
        ans.add(prev);
        for (int r = 1; r <= n; r++) {
            int curr = (prev * (n - r + 1)) / r;
            ans.add(curr);
            prev = curr;
        }
        return ans;
    }
}
// 1 4 6 4 1