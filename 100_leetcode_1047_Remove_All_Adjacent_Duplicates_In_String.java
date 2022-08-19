/*
1047 - Remove All Adjacent Duplicates In String

You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.

*/

class Solution {
    public String removeDuplicates(String s) {
        // cannot be solved through recursion because once pair removed, if its adjacent are same then they also should be removed.
        Stack<Character> st = new Stack<>();
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(st.isEmpty()) {
                // for first character or else peek will give underflow error
                st.push(c);
            }
            else {
                if(st.peek() == c) {
                    // removing matching characters
                    st.pop();
                }
                else {
                    // stack up with non repeating characters
                    st.push(c);
                }
            }
        }
        // return string left in stack as ans is reverse manner(as stored in stack)
        while(!st.isEmpty()) {
            // res = res + st.pop() -> not in reverse manner
            res = st.pop() + res;
        }
        return res;
    }
}
