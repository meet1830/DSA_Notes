/*
744. Find Smallest Letter Greater Than Target

Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.

Note that the letters wrap around.

For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 
Example 1:
Input: letters = ["c","f","j"], target = "a"
Output: "c"

Example 2:
Input: letters = ["c","f","j"], target = "c"
Output: "f"

Example 3:
Input: letters = ["c","f","j"], target = "d"
Output: "f"

Example 4:
Input: letters = ["c","f","j"], target = "j"
Output: "c"

Example 5:
Input: letters = ["e", "e", "e", "n", "n"], target = "e"
Output: "n" 

Example 6:
Input: letters = ["e", "e", "e", "n", "n"], target = "n"
Output: "e" 

Constraints:

2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
*/


public class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        char result = Character.MIN_VALUE;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (target < letters[mid]) {
                result = letters[mid];
                r = mid - 1;
            }
            else {
                if (mid == letters.length - 1) {
                    return letters[0];
                }
                else {
                    l = mid + 1;
                }
            }
        }
        return result;
    }
}
