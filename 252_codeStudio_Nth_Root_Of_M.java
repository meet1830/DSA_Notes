/* 
 * You are given two positive integers N and M. You have to find the Nth root of M i.e. M^(1/N).
Note:
N'th root of an integer M is a real number, which when raised to the power N gives M as a result.

N'th root of the M should be correct up to 6 decimal places.
Input Format:
The first line of the input contains an integer T denoting the number of test cases.

The first and only line of each test case consists of two space-separated integers N and M.
Output Format:
For each test case, print a real number with precision up to 6 decimal places that denote the Nth root of M in a separate line.
Note:
You don't have to print anything, it has already been taken care of. Just Implement the given function.
Constraints:
1 <= T <= 100
1 <= N <= 300
1 <= M <= 10^9

Time Limit: 1 sec.
Sample Input 1:
1
3 27
Sample Output 1:
3.000000
Explanation For Sample Input 1:
3rd Root of 27 is 3.000000, as (3.000000)^3 is equal to 27.
Sample Input 2:
1
4 69
Sample Output 2:
2.882121
*/



// Binary search
// reducing the search space till then we reach the limit of accuracy for our ans
// here the seach space is not from 1, 2, 3 .. m. here it is 1.000001, 1.000002, 1000003, etc to m. 
// to understand if we had to find for upto one decimal then search space would be 1, 1.1, 1.2, 1.3, etc till m. hence instead of logn, it would be logn(10 * n) because every n has 10 decimal values 1.1, 1.2, 1.3 till 2. 
// similarly for d decimal spaces, it is log(n * 10^d). also considering the multiply function
// O(n * log(10^d * n)), O(1)

public class Solution {
    public static double multiply(double mid, int n) {
        double ans = 1;
        
        for (int i = 0; i < n; i++) 
            ans *= mid;
        
        return ans;
    }
    public static double findNthRootOfM(int n, long m) {
        double l = 0, r = m;
        double eps = 1e-7; //epsilon
        
        while ((r - l) > eps) {
            double mid = (r + l) / 2;
            if (multiply(mid, n) < m)
                l = mid;
            else 
                r = mid;
        }
        
        return l;
    }
}