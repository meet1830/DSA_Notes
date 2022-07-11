/*
409. Longest Palindrome

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1

Example 3:
Input: s = "bb"
Output: 2

Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

*/

class Solution {
    public int longestPalindrome(String s) {
        // longest palindrome is the one consisting of all characters who have a even number of frequency in the string, number of frequencies - 1 for all characters having odd number of frequency, and all characters of frequency for any of any of odd number of frequency characters.
        // abccccdd
        // a-1, b-1, c-4, d-2
        // longest palindrome length -> b-1, c-4, d-2 OR a-1, b-0, c-4, d-2
        
        // calculating frequencies of characters of input string
        // using hashmap for frequency because case sensitive 
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, 1 + freq.getOrDefault(ch, 0));
        }
        
        int count = 0;
        boolean taken = false;
        for(int i : freq.values()) {
            // if count of freq is even take all
            if(i % 2 == 0) {
                count += i;
            }
            else {
                // if for any odd all freq is taken
                if (taken == false) {
                    count += i;
                    taken = true;
                }
                // if true then for all others take -1 of freq
                else {
                    count += i - 1;
                }
            }
        }
        
        return count;
    }
}
