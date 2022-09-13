/*
 * Odd Even Problem
Given a string S of lowercase english characters, find out whether the summation of X and Y is even or odd, where X is the count of characters which occupy even positions in english alphabets ("a" occupies position 1 , "b" occupies position 2 and so on "z" occupies position 26) and have positive even frequency, and Y is the count of characters which occupy odd positions in english alphabets and have positive odd frequency. Note: Positive means greater than zero.

Input
First line contains single string denoting S

Output
Print "ODD" (Without quotes) if X + Y is odd Print "EVEN" (Without quotes) if X + Y is even

Constraints:
1 <= Length of String <= 100000

Sample Input:
abbbcc
Sample Output:
ODD
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int f[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (f[i] != 0 && i % 2 != f[i] % 2) {
                ans++;
            }
        }
        System.out.println((ans % 2 == 1 ? "ODD" : "EVEN"));
    }
}



/* 
 * Odd Even Problem

Given a string S of lowercase english characters, find out whether the summation of X and Y is even or odd, where X is the count of characters which occupy even positions in english alphabets and have positive even frequency, and Y is the count of characters which occupy odd positions in english alphabets and have positive odd frequency.

Note: Positive means greater than zero.

Example 1:
Input: S = "abbbcc"
Output: "ODD"
Explanation: X = 0 and Y = 1 so (X + Y) is 
ODD. 'a' occupies 1st place(odd) in english 
alphabets and its frequency is odd(1), 'b' 
occupies 2nd place(even) but its frequency 
is odd(3) so it doesn't get counted and 'c' 
occupies 3rd place(odd) but its frequency 
is even(2) so it also doesn't get counted.

Example 2:
Input: S = "nobitaa"
Output: "EVEN"
Explanation: X = 0 and Y = 2 so (X + Y) is
EVEN.

Your Task:  
You dont need to read input or print anything. Complete the function evenOdd() which takes S as input parameter and returns "EVEN"  if  X + Y is even, "ODD" otherwise.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1) 

Constraints:
1 ≤ |S| ≤ 1000
*/


class Solution{
    static String oddEven(String S) {
        int[] freq = new int[26];
        for(int i = 0; i < S.length(); i++) {
            freq[S.charAt(i) - 'a']++;
        }
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0 && freq[i] % 2 == 0 && i % 2 != 0) {
                count++;
            } else if(freq[i] != 0 && freq[i] % 2 == 1 && i % 2 == 0) {
                count++;
            }
        }
        if(count % 2 == 0) {
            return "EVEN";
        } else {
            return "ODD";
        }
    }
}