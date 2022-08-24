/* 
 * KMP-Algorithm
Given two strings, one is a text string, txt and other is a pattern string, pat. The task is to print the indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1.

Example 1:
Input:
txt = "batmanandrobinarebat", pat = "bat"
Output: 1 18
Explanation: The string "bat" occurs twice
in txt, one starts are index 1 and the other
at index 18. 

Example 2:
Input: 
txt = "abesdu", pat = "edu"
Output: -1
Explanation: There's not substring "edu"
present in txt.

Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string txt and the string pat as inputs and returns an array denoting the start indices (1-based) of substring pat in the string txt. 
Note: Return an empty list incase of no occurences of pattern. Driver will print -1 in this case.

Expected Time Complexity: O(|txt|).
Expected Auxiliary Space: O(|txt|).

Constraints:
1 ≤ |txt| ≤ 105
1 ≤ |pat| < |S|
*/


// O(n), O(m + n)
class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // adding char to keep pat and txt different for calculating lps values
        String st = pat + "#" + txt;
        
        // generating lps array
        int[] lps = new int[st.length()];
        int i = 1, len = 0;
        while (i < st.length()) {
            if (st.charAt(i) == st.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len > 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // adding to ans
        // lps size is according to modified string hence subtract added length plus
        // we need to add the starting index hence subtract for that too
        // for 0 based indexing pat.length() - 1 instead of pat.length() - 2
        ArrayList<Integer> ans = new ArrayList<>();
        for (int p = pat.length(); p < lps.length; p++) {
            if (lps[p] == pat.length())
                ans.add(p - (pat.length() + 1) - (pat.length() - 2));
        }
        
        return ans;
    }
}