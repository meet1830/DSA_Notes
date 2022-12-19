/*
3. Longest Substring Without Repeating Characters 
Question:
Given a string s, find the length of the longest substring without repeating characters. 

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. 

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

// remove elements till the curr ele and not the whole data structure

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int p = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(p));
                p++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }
}

