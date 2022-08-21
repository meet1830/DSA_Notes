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
