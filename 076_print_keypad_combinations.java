/*
Print Kpc -> pepcoding

1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone. 
2. The following list is the key to characters map 0 -> .; 1 -> abc 2 -> def 3 -> ghi 4 -> jkl 5 -> mno 6 -> pqrs 7 -> tu 8 -> vwx 9 -> yz 
3. Complete the body of printKPC function - without changing signature - to print the list of all words that could be produced by the keys in str. Use sample input and output to take idea about output. 
Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= str.length <= 10 str contains numbers only

Format
Input
A string str

Output
Words that can be produced by pressed keys indictated by str in order hinted by Sample output

Example
Sample Input
78

Sample Output
tv
tw
tx
uv
uw
ux
*/

import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        String input = "67";
        printKpc(input, "");
    }
    static String[] codes = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"}; 
    public static void printKpc(String input, String ans) {
        //base
        if (input.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        char ch = input.charAt(0);
        String roq = input.substring(1);
        
        String codeforch = codes[ch - '0'];
        for (int i=0; i<codeforch.length(); i++) {
            char cho = codeforch.charAt(i);
            printKpc(roq, ans + cho);
        }
    }
}

/*
pt
pu
qt
qu
rt
ru
st
su
*/

/* 
Leetcode -> 17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: [] -> (not equal to [""] therefore if condition added in first function -> before it was getting output as [""].) 

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
 
Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

class Solution {
    static String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String input) {
        ArrayList<String> temp = new ArrayList<>();
        if (input.length() >= 1) {
            ArrayList<String> output = printKpc(input, "", temp);
            return output;
        }
        else {
            return temp;
        }
    }
    public static ArrayList<String> printKpc(String input, String ans, ArrayList<String> temp) {
        if (input.length() == 0) {
            temp.add(ans);
            return temp;
        }
        
        char ch = input.charAt(0);
        String roq = input.substring(1);
        
        String codeforch = codes[ch - '0'];
        for(int i=0; i<codeforch.length(); i++) {
            char co = codeforch.charAt(i);
            printKpc(roq, ans + co, temp);
        }
        return temp;
    }
}
