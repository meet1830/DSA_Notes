/* 
 * Rabin-Karp Algorithm
Given two strings, one is a text string and other is a pattern string. The task is to print the indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1.

Example 1:
Input:
S = "batmanandrobinarebat", pat = "bat"
Output: 1 18
Explanation: The string "bat" occurs twice
in S, one starts are index 1 and the other
at index 18. 

â€‹Example 2:
Input: 
S = "abesdu", pat = "edu"
Output: -1
Explanation: There's not substring "edu"
present in S.

Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string S and the string pat as inputs and returns an array denoting the start indices (1-based) of substring pat in the string S. 

Expected Time Complexity: O(|S|*|pat|).
Expected Auxiliary Space: O(1).

Constraints:
1<=|S|<=105
1<=|pat|<|S|
*/


// O(m + n), O(1)
class Solution
{
    ArrayList<Integer> search(String pat, String txt)
    {
        int m = pat.length(), n = txt.length();
        ArrayList<Integer> ans = new ArrayList<>();
        int d = 256; // no of types of characters possible
        int q = 101; // prime number
        int h = 1;
        int p = 0;
        int t = 0;
        
        // calculating h
        for (int i = 1; i < m; i++) 
            h = (h * d) % q;
            
        // calculating hashcode for first window
        for (int i = 0; i < m; i++) {
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }
        
        // sliding window and comparing hashcode
        for (int i = 0; i <= n - m; i++) {
            // hashcode matching then check char by char
            if (p == t) {
                if (txt.substring(i, i + m).equals(pat))
                    ans.add(i + 1);
            }
            
            // calculate for next window 
            // t = t - prev char + new char
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                
                // if t neg revert it to pos
                if (t < 0)
                    t += q;
            }
        }
        
        // if no match
        if (ans.size() == 0)
            ans.add(-1);
            
        return ans;
    }
}