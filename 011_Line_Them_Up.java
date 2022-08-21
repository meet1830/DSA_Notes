/*
Line Them Up
An eccentric coach asks players on the team to line up alphabetically at the start of practice. The coach does not tell the players whether they need to line up in increasing or decreasing order, so they guess. If they guess wrong, the coach makes them run laps before practice. Given a list of names, you are to determine if the list is in increasing alphabetical order, decreasing alphabetical order or neither.

Input
The input consists of a single test case. The first line will contain the number N of people on the team (2≤N≤20). Following that are N lines, each containing the name of one person. A name will be at least two characters and at most 12 characters in length and will consist only of capital letters, and with no white spaces (sorry BILLY BOB and MARY JOE). Duplicates names will not be allowed on a team.

Output
Output a single word: INCREASING if the list is in increasing alphabetical order, DECREASING if it is in decreasing alphabetical order, and otherwise NEITHER.

Constraints:
2 <= N <= 20

Example
Input:
5
JOE
BOB
ANDY
AL
ADAM
Output:
DECREASING
*/

import java.util.*;
import java.io.*;

public class A1_Line_Them_Up {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String[] names = new String[n];
    for (int i = 0; i < n; i++) {
      names[i] = input.next();
    }
    int[] state = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
      if (names[i + 1].compareTo(names[i]) < 0) {
        state[i]--;
      } else if (names[i + 1].compareTo(names[i]) > 0) {
        state[i]++;
      } 
      // else
        // state[i] = 0;
    }
    Arrays.sort(state);
    if (state[0] == -1 && state[n - 2] == -1) {
      System.out.println("DECREASING");
    } else if (state[0] == 1 && state[n - 2] == 1) {
      System.out.println("INCREASING");
    } else
      System.out.println("NEITHER");
    input.close();
  }
}
