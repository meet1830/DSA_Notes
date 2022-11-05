/* 
 * 14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

*/


// brute -> consider each character from start and iterate through all strings. if that character does not exist then do not update the string and return  

// O(n * m), O(1) n -> times outer loop runs, m -> times inner loop runs
// keep removing the last digit of the prefix string untill it becomes subset of strs[i] from start. 
// indexof searches prefix in strs[i] and if the first character of prefix matches at 0th index of strs[i] then returns its index which is 0 
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}


// vertical scanning
// O(n * minLen) -> n = length of 0th string, minLen = length of shortest string in array
// O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}


// divide and conquer - recursion
// O(n * m) best case O(n * minLen) worst case - size of all strings same
// O(mlogn) - m space to store res, logn calls
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l >= r) return strs[l];
        int mid = l + (r - l) / 2;
        String strsLeft = longestCommonPrefix(strs, l, mid);
        String strsRight = longestCommonPrefix(strs, mid + 1, r);
        return commonPrefix(strsLeft, strsRight);
    }
    private String commonPrefix(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, minLen);
    }
}