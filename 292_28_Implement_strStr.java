/* 
 * 28. Implement strStr()
Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1
 
Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
*/



class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (n < m)
            return -1;
        
        for (int i = 0; i <= n - m; i++) {
            int p = i;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(p) != needle.charAt(j))
                    break;
                p++;
                
                if (j == m - 1)
                    return i;
            }
        }
        return -1;
    }
}




// another approach -> if the first character of the text matches the first character of the pattern, then create substring of length of pattern and check for equality

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length(), p = 0;
        while (p + n - 1 < m) {
            if (haystack.substring(p, p + n).equals(needle))
                return p;
            while (p++ + n - 1 < m && haystack.charAt(p) != needle.charAt(0));
        }
        return -1;
    }
}




// kmp algo

class Solution {
    public int strStr(String txt, String pat) {
        // adding special char to keep pat and txt different in process of calculating lps values
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
        for (int p = pat.length(); p < lps.length; p++) {
            if (lps[p] == pat.length())
                return (p - (pat.length() + 1) - (pat.length() - 1));
        }
        
        return -1;
    }
}

// can also be solved using z algo