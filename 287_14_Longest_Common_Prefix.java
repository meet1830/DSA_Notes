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