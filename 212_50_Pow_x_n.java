/* 
 * 50. Pow(x, n)
Medium

5454

6103

Add to List

Share
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
-10^4 <= x^n <= 10^4

*/


// algo called binary exponentiation
// pow function not accurate for large numbers and also here we use double
// for large numbers in question asks to return modulo of 10^9 then replace 
// ans *= x % modValue in algo below and
// x *= x % modValue
// above the algo are optimizations to suit the question
// here also neg powers, hence have to make power positive and divide it by 1 -x = 1/x
// 2^2 = 1/(2^2)
// another problem is that if input is 2^-31 and if convert it to positive, then also due to the limit of integer it will again downgrade to 2^-31 since 2^31 is not it range. dislikes in the question are because of that

class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long newN = n;
        
        // optimization starts
        if(newN < 0) {
            newN = Math.abs(newN);
            x = 1 / x;
        }
        
        // algo starts here
        while(newN > 0) {
            if(newN % 2 == 1)
                ans *= x;
            
            newN /= 2;
            x *= x;
        }
        
        return ans;
    }
}