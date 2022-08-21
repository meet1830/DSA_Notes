/* 
 * 2337. Move Pieces to Obtain a String
Medium

398

30

Add to List

Share
You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:

The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left, and a piece 'R' can move to the right only if there is a blank space directly to its right.
The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.

 

Example 1:

Input: start = "_L__R__R_", target = "L______RR"
Output: true
Explanation: We can obtain the string target from start by doing the following moves:
- Move the first piece one step to the left, start becomes equal to "L___R__R_".
- Move the last piece one step to the right, start becomes equal to "L___R___R".
- Move the second piece three steps to the right, start becomes equal to "L______RR".
Since it is possible to get the string target from start, we return true.
Example 2:

Input: start = "R_L_", target = "__LR"
Output: false
Explanation: The 'R' piece in the string start can move one step to the right to obtain "_RL_".
After that, no pieces can move anymore, so it is impossible to obtain the string target from start.
Example 3:

Input: start = "_R", target = "R_"
Output: false
Explanation: The piece in the string start can move only to the right, so it is impossible to obtain the string target from start.
 

Constraints:

n == start.length == target.length
1 <= n <= 105
start and target consist of the characters 'L', 'R', and '_'.
*/


// base condition -> if length of both strings not same then return false but not needed here
// two pointers one for start string and other for target string
// first two while loops -> traversing over spaces for both strings so that both pointers point to either L or R
// first if condition -> considering true case in neglecting spaces if both pointers reach at end 
// second if -> considering false case if one of them reaches end and other does not due to encountering an L or R that means false case. Also if both encounter a character, then it should be equal in both the strings either L or R or else false case
// third if -> above condition not considered means both characters are equal. now check order of s and t. if char is L then in s should be less than t as L can only be moved leftwards. from start string to target the order of the characters remain same hence in first condition when skipping spaces we reach the same char that was moved in start string in the form of target string
// O(n), O(1)

class Solution {
    public boolean canChange(String start, String target) {
        
        int s = 0, t = 0;
        
        while (s < start.length() || t < target.length()) {
            while (s < start.length() && start.charAt(s) == '_')
                s++;
            while (t < target.length() && target.charAt(t) == '_')
                t++;
            
            if (s == start.length() && t == target.length())
                return true;
            
            if (s == start.length() || t == target.length() || start.charAt(s) != target.charAt(t))
                return false;
            
            if (s < start.length() && t < target.length()) {
                if (target.charAt(t) == 'L' && s < t)
                    return false;
                if (target.charAt(t) == 'R' && s > t)
                    return false;
            }
            
            s++; t++;
        }
        
        return true;
    }
}