/*
First non-repeating character in a stream
Given an input stream of A of n characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream. If there is no such character then append # to the answer.

Input
First line contains a single string s

Output
Return string after being processed

Constraints:
1 <= Length of string <= 100000

Sample Input:
aabc
Sample Output:
a#bb
Explaination :
For every character first non repeating character is as follow- "a" - first non-repeating character is a "aa" - no non-repeating character so # "aab" - first non-repeating character is b "aabc" - first non-repeating character is b
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    String s = input.next();
    Queue<Integer> q = new LinkedList<>();
    int freq[] = new int[26];

    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i) - 'a';
      freq[c]++;
      q.add(c);
      while (!q.isEmpty() && freq[q.peek()] > 1)
        q.poll();

      if (q.isEmpty())
        System.out.print("#");
      else
        System.out.print((char) ('a' + q.peek()));
    }
  }
}