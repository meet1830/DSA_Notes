/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Constraints:
1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.

*/


class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i= 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else {
                if(!st.isEmpty()) {
                // will work for nested brackets because what was added last will have closing brackets first for valid string
                    char x = st.pop();
                    if(!isEqual(x, ch)) {
                        return false;
                    }
                }
                else {
                    // stack is empty means closing bracket encountered without matching opening bracket
                    return false;
                }
            }
        }
        // parenthesis left in stack means not valid
        if(st.isEmpty()) {
            return true;
        }
        return false;
    }
    public boolean isEqual(char x, char ch) {
        if(x == '(' && ch == ')') {
            return true;
        }
        else if(x == '{' && ch == '}') {
            return true;
        }
        else if(x == '[' && ch == ']') {
            return true;
        }
        return false;
    }
}



class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') 
                st.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (!st.isEmpty() && isMatching(c, st.peek())) {
                    st.pop();
                }
                else return false;
            }
        }
        if (st.isEmpty()) return true;
        return false;
    }
    private boolean isMatching(Character c, Character o) {
        if (o == '{' && c == '}') return true;
        if (o == '(' && c == ')') return true;
        if (o == '[' && c == ']') return true;
        return false;
    } 
}



// O(n), O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (Character b : s.toCharArray()) {
            if (b == '(' || b == '{' || b == '[')
                st.push(b);
            
            else {
                if (st.isEmpty())
                    return false;

                char c = st.pop();
                if (b == ')' && c == '(') { continue; }
                if (b == '}' && c == '{') { continue; }
                if (b == ']' && c == '[') { continue; }

                else 
                    return false;
            }
        }
        
        if (!st.isEmpty())
            return false;
        return true;
    }
}