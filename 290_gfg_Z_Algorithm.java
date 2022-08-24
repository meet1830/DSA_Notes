/* 
 * Search Pattern (Z-algorithm)
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
Note: You don't need to return -1 yourself when there are no possible answers, just return an empty list.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1 ≤ |S| ≤ 10^5
1 ≤ |pat| ≤ |S|
*/


// here z function is longest subsring starting at index i which is also a proper prefix
// hence search area is whole string, while the string starting at i matches with each character of string starting from 0 (prefix), the length of ans can extend to whole string as overlapping is allowed
// hence prefix keeps on increasing with the string starting from i
// first character always has answer string.length() - 1 as string starting from 0 and string starting from i are same and 1 less than length as proper
// first character ans does not matter

// brute
// O(m*n) average, O(n^2) worst (eg -> aaaaa)
// calculating only z function array for brute force

class Solution
{
    private int[] zfunc(String st) {
        int n = st.length();
        int[] z = new int[n];
        
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            while (i + z[i] < n && st.charAt(z[i]) == st.charAt(i + z[i])) {
                z[i]++;
            }
        }
        
        return z;
    }
}




// optimized to reduce tc to O(2 * n)
// in z function added two if statements
// this calculates the prev matching values for the i and gives it a kickstart
// the while function then calculates the additional matching values whose information we did not have in the first if condition
// call the string starting after i as suffix for now
// min condition compares the prev suffix and this suffix and gets the value which are same
// and z[i - l] compares prev prefix and this suffix and gets the same values
// its min is to be taken as the larger value may not have all same values
// second if updates the range values if after executing while loop i has gone out of range of l and r
// here the while loop does not run for values prev to i and only runs forward
// for loop and while loop runs individually run n times hence 2 * n

class Solution
{
    private int[] zfunc(String st) {
        int n = st.length();
        int[] z = new int[n];
        
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            
            while (i + z[i] < n && st.charAt(z[i]) == st.charAt(i + z[i])) {
                z[i]++;
            }
            
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        
        return z;
    }
    ArrayList<Integer> search(String pat, String S)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        String st = pat + "#" + S;
        int[] z = zfunc(st);
        
        for (int i = 1; i < st.length(); i++) {
            if (z[i] == pat.length())
                ans.add(i - pat.length());
                // i - pat.length() - 1 for 0 based indexing
        }
        
        return ans;
    }
}
