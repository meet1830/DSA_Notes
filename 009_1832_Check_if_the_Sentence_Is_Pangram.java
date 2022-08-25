/*
Pangrams
A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is a pangram in the English alphabet. Ignore case. Return either pangram or not pangram as appropriate.

Input
The first line inputs a string, S.

Constraints:
0 < length of s <= 1000
Each character of s, s[i]∈{a-z,A-Z,space}

Output
In a new line, print "pangram" if string contains every letter of the alphabet else "not pangram".

Example
Input:
We promptly judged antique ivory buckles for the next prize
Output:
pangram
Explanation:
All of the letters of the alphabet are present in the string.

Input:
We promptly judged antique ivory buckles for the prize
Output:
not pangram
Explanation:
The string lacks an x.
*/


import java.util.*;

public class A1_pangram {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    String s = input.nextLine();
    s = s.toLowerCase();
    boolean f = true;
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (s.contains(String.valueOf(' ')))
        f = true;
      if (!s.contains(String.valueOf(ch))) {
        f = false;
        break;
      }
    }
    if (f)
      System.out.println("pangram");
    else
      System.out.println("not pangram");
    input.close();
  }
}
// Time Complexity: O(26) 
// Auxiliary Space: O(1)


// O(N), O(N)
import java.util.Scanner;

public class A1_pangram {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int n = s.length();
    int[] a = new int[26];
    for(int i=0; i<n; i++) {
      if(s.charAt(i)>='a' && s.charAt(i)<'z'){
        a[s.charAt(i)-'a'] = 1;
      } else if (s.charAt(i)>='A' && s.charAt(i)<'Z') {
        a[s.charAt(i)-'A'] = 1;
      }
    }
    //above same as s.toLowerCase();
    input.close();
    for(int i=0; i<26; i++) {
      if(a[i]==0) {
        System.out.println("not pangram");
        return;
      } 
    }
    System.out.println("pangram");
  }
}



/* 
 * 1832. Check if the Sentence Is Pangram

A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.


Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.

Example 2:
Input: sentence = "leetcode"
Output: false
 

Constraints:
1 <= sentence.length <= 1000
sentence consists of lowercase English letters.

*/


class Solution {
  public boolean checkIfPangram(String sentence) {
      // calculating freq
      int[] freq = new int[26];
      for(int i = 0; i < sentence.length(); i++) {
          freq[sentence.charAt(i) - 'a']++;
      }
      // check if any value is 0
      for(int i = 0; i < 26; i++) {
          if(freq[i] == 0) {
              return false;
          }
      }
      return true;
  }
}