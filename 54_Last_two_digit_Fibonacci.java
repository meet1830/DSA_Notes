/*
Last two digit Fibonacci
Easy Accuracy: 49.36% Submissions: 1668 Points: 2

Given a number N. Find the last two digits of the Nth fibonacci number.
Note: If the last two digits are 02, return 2.

Example 1:

Input: N = 13 Output: 33 Explanation: The 13th Fibonacci number is 233. So last two digits are 3 and 3.

Example 2:

Input: N = 255 Output: 70 Explanation: The 255th fibonacci number is 875715953430- 18854458033386304178158174356588264390370. Thus, last two digits are 7 and 0.

Your Task:
You need to read input. Take a number N as input parameter and returns the last two digits of the Nth fibonacci number.

Constraints:
1<=N<=1018
*/

import java.util.*;

public class G1_Last_two_digit_Fibonacci {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int count = 1;
    int start = 0, first = 1, next = 0;
    if (n == 1)
      next = 1;
    while (count < n) {
      if (next < 10) {
        next = start + first;
        start = first;
        first = next;
        count++;
        // System.out.print("start = " + start + " ");
        // System.out.print("first = " + first + " ");
        // System.out.println("next = " + next + " ");
      } else {
        next = start + first;
        start = first;
        first = next;
        count++;
        start %= 100;
        first %= 100;
        next %= 100;
        // System.out.print("start = " + start + " ");
        // System.out.print("first = " + first + " ");
        // System.out.println("next = " + next + " ");
      }
    }
    if (next < 10) System.out.println("0" + next);
    else System.out.println(next);
    input.close();
  }
}

/*
Program to find nth fibonacci term


import java.util.Scanner;

public class G1_Last_two_digit_Fibonacci {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), sum=0;
        if (n==0) {
            System.out.println(0);
        }
        int i = 0, j = 1, steps = 2;
        if (n==1 || n==2) {
            System.out.println(1);
        } else {
            while (steps < n) {
                sum = i + j;
                i = j;
                j = sum;
                steps++;
            }
            System.out.println(sum);
        }
    }
}
*/
