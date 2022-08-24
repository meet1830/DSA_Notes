/* 
 * 151. Reverse Words in a String
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
*/


// O(n + n(string.split)), O(m -> number of spaces + 1 or word array size -> O(1) as it is generally ignored as it is a language dependent thing and also the function parameters can be defined to char[])

class Solution {
    public String reverseWords(String s) {
        // replacing consecutive spaces and separating words by a comma
        s = s.replaceAll("\\s+", ",");
        String[] word = s.split(",");
        
        int l = 0, r = word.length - 1;
        while (l < r) {
            String temp = word[l];
            word[l] = word[r];
            word[r] = temp;
            l++; r--;
        }
        
        // return String.join(" ", word);
        // this cannot be used here since we do not need to include the word[i] which is a space
        
        String res = word[0];
        for (int x = 1; x < word.length; x++) {
            if (word[x] != "")
                res = res + " " + word[x];
        }
        return res;
    }
}



// in-space solution with no split, tochararray methods
class Solution {
    private String cleanSpaces(char[] ch, int n) {
        int i = 0, j = 0;
        
        while (j < n) {
            // skip spaces
            while (j < n && ch[j] == ' ') j++;
            
            // keep non spaces -> copy elements to front
            while (j < n && ch[j] != ' ') ch[i++] = ch[j++];
            
            // skip spaces
            
            while (j < n && ch[j] == ' ') j++;
            // keep only one space
            if (j < n) ch[i++] = ' ';
        }
        
        return new String(ch).substring(0, i);
    }
    private void reverseWords(char[] ch, int n) {
        int i = 0, j = 0;
        
        while (i < n) {
            // skip spaces
            while (i < j || i < n && ch[i] == ' ') i++;
            
            // skip non spaces
            while (j < i || j < n && ch[j] != ' ') j++;
            
            // reverse each word
            reverse(ch, i, j - 1);
        }
    }
    private void reverse(char[] ch, int l, int r) {
        while (l < r) {
            char temp = ch[l];
            ch[l++] = ch[r];
            ch[r--] = temp;
        }
    }
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        
        // 1. reverse whole string
        reverse(ch, 0, n - 1);
        
        // 2. reverse each word
        reverseWords(ch, n);
        
        // 3. remove spaces
        return cleanSpaces(ch, n);
    }
}