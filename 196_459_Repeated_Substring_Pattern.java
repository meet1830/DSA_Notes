/* 
 * 459. Repeated Substring Pattern
Easy

3684

339

Add to List

Share
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

Constraints:

1 <= s.length <= 10^4
s consists of lowercase English letters.
*/



// memory limit exceeds for small input (17 characters)
/*
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1)
            return true;
        if (s.length() % 2 != 0)
            return false;
        
        int i = 1;
        while (i <= s.length() / 2) {
            String pre = s.substring(0, i);
            
            if (s.length() % pre.length() == 0) {
                while (pre.length() != s.length()) {
                    pre = pre + pre;
                }
                if (s.equals(pre))
                    return true;
                i++;
            }
        }
        return false;
    }
}
*/



// optimal -> same code but using stringbuilder
// O(n ^ 2), O(1)
// run for n / 2 times cause one string will at least have two copies with it
// if case -> check if the string to be built matches the length else continue
// create the string by repeatedly appending the string considered to make the input string
// then check is the string made matches the input string

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String str = s.substring(0, i);
            
            if (len % str.length() == 0) {
                StringBuilder sb = new StringBuilder(str);
                
                int times = len / str.length() - 1;
                while (times --> 0) {
                    sb.append(str);
                }
                
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}



// kmp algo
// consider eg 'abcabcabcabc' 
// take the whole input string as input for lps since no pattern here
// lps = [0 0 0 1 2 3 4 5 6 7 8 9]
// this is because at last index with overlapping 9 characters are eligible for longest proper(excluding the whole string) prefix and suffix
// hence at last 12 % (12 - 9) = 0
// O(n), O(n)
class Solution {
    private int[] kmp (String st) {
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
        return lps;
    }
    public boolean repeatedSubstringPattern(String s) {
        int[] lps = kmp(s);
        int n = s.length();
        int len = lps[n - 1];
        return (len > 0 && n % (n - len) == 0);
    }
}