/*
Strange String
The question is super small and super simple. You are given an integer n. Initially you have an empty string. You need to construct the string of length n with the following rules:

Insert the first character in the beginning of string, the second in the end, the third in the beginning, fourth in the end, and so on.
The first character should be a, followed by b, c, and so on. z will be followed by a.
Input
The first and the only line of input contains a single number n.

Constraints:
1 <= n <= 500000

Output
In a new line, print the generated string..

Example
Input:
4
Output:
cabd
Explanation:
In the first case the string transforms as follows: "" -> "a" -> "ab" -> "cab" -> "cabd"
*/

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    char[] abcd = new char[26];
    char ch = 'a';
    for (; ch<='z'; ch++) {
      abcd[ch - 'a'] = ch;
    }
    ArrayList<String> result = new ArrayList<>();
    for (int i=0; i<n; i++) {
      if (ch>'z') {
        ch = 'a';
      }
      if (i==0 || i%2==0) {
        result.add(0, String.valueOf(ch++));
      }
      else {
        result.add(String.valueOf(ch++));
      }  
    }
    for (String x : result) {
      System.out.print(x);
    }
    System.out.println("");
  }
}
