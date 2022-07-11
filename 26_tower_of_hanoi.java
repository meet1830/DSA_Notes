/*
Tower of Hanoi

The Tower of Hanoi is a mathematical puzzle where we have 3 rods and N disks. The puzzle starts with all the disks in ascending order of size on the first row. The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:

Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.
No larger disk may be placed on top of a smaller disk.
-----x--x--x------

Let the rods have names A, B and C. Given N number of disks, numbered 1 to N from top to bottom, display all the moves required to move the disks from rod A to C in minimum number of steps. Watch this animation for getting a better feel: http://towersofhanoi.info/Animate.aspx

Input The only line of input contains an integer N denoting the number of disks

Constraints: 1 ≤ N ≤ 16 Output Print the sequence of moving disks, where each move is shown in the following format- {FromRod}->{ToRod} Each move in the sequence is separated by a new line Example Input 2

Output A->B A->C B->C
*/

import java.io.*;
import java.util.*;
public class Main {
  public static void toh(int n, char source, char dest, char aux) {
    if (n == 0) return;
    toh(n - 1, source, aux, dest);
    System.out.println(source + "->" + dest);
    toh(n - 1, aux, dest, source);
  }
    public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      toh(n, 'A', 'C', 'B');
    }
}

// Input -> 3

/*
A->C
A->B
C->B
A->C
B->A
B->C
A->C
*/
