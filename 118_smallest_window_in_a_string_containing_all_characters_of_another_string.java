/*
Smallest window in a string containing all the characters of another string
Given two strings S and P. Find the smallest window in the string S consisting of all the characters(including duplicates) of the string P. Return "-1" in case there is no such window present. In case there are multiple such windows of same length, return the one with the least starting index.

Example 1:

Input: S = "timetopractice" P = "toc" Output: toprac **Explanation: "**toprac" is the smallest substring in which "toc" can be found.

Example 2:

Input: S = "zoomlazapzo" P = "oza" Output: apzo Explanation: **"**apzo" is the smallest substring in which "oza" can be found.

Your Task:
You need to read input , take two string S and P as input and print the smallest window in string S having all the characters of the string P. In case there are multiple such windows of same length, print the one with the least starting index.

Constraints:
1 ≤ |S|, |P| ≤ 105
*/

import java.util.*;

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    String t = input.next(), s = input.next();
    String ans = "";
    int min = 200;
    int f1[] = new int[26];
    int unique = 0;
    for (int i = 0; i < s.length(); i++) {
      if (f1[s.charAt(i) - 'a'] == 0)
        unique++;
      f1[s.charAt(i) - 'a']++;
    }
    int f2[] = new int[26];
    int l = 0;
    int start = -1;
    for (int r = 0; r < t.length(); r++) {
      f2[t.charAt(r) - 'a']++;
      if (f2[t.charAt(r) - 'a'] == f1[t.charAt(r) - 'a'])
        unique--;
      if (unique == 0) {
        while (unique == 0) {
          if (min > r - l + 1) {
            min = r - l + 1;
            start = l;
          }
          f2[t.charAt(l) - 'a']--;
          if (f2[t.charAt(l) - 'a'] < f1[t.charAt(l) - 'a']) {
            unique++;
          }
          l++;
        }
      }
    }
    ans = t.substring(start, start + min);
    System.out.println(ans);
  }
}