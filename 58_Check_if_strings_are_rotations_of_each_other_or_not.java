/*
Check if strings are rotations of each other or not
Given two strings s1 and s2. The task is to check if s2 is a rotated version of the string s1. The characters in the strings are in lowercase.

Example 1:

Input: geeksforgeeks forgeeksgeeks Output: 1 Explanation: s1 is geeksforgeeks, s2 is forgeeksgeeks. Clearly, s2 is a rotated version of s1 as s2 can be obtained by left-rotating s1 by 5 units.

Example 2:

Input: mightandmagic andmagicmigth Output: 0 Explanation: Here with any amount of rotation s2 cant be obtained by s1.

Your Task:
Input 2 strings in different lines and complete the above given task.

Expected Time Complexity: O(N).
Expected Space Complexity: O(N).
Note: N = |s1|.

Constraints:
1 <= |s1|, |s2| <= 107
*/

import java.util.Scanner;

public class G1_Check_if_strings_are_rotations_of_each_other_or_not {
  public static void main (String args[]) {
    Scanner scan = new Scanner(System.in);
    String input = scan.next(), result = scan.next();
    String rotate = input;
    boolean f = true;
    for(int i=0; i<input.length(); i++) {
      // left rotate by 1
      rotate = rotate.substring(1)+rotate.substring(0,1);
      // right rotate by 1
      // rotate = rotate.substring(rotate.length()-1)+rotate.substring(0,rotate.length()-1);
      if(rotate.equals(result)) {
        System.out.println(1);
        f = true;
        break;
      } else {
        f = false;
      }
    }
    if(!f) System.out.println(0);
    scan.close();
  }
}

//in general rotate by d chars in string

//left rotate
// leftrotate(String str, int d)
// String ans = str.substring(d) + str.substring(0, d);

//right rotate
// return leftrotate(str, str.length() - d);
// rotate = rotate.substring(rotate.length()-d)+rotate.substring(0,rotate.length()-d);