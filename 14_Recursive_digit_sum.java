/*
Recursive Digit Sum Problem
We define super digit of an integer n using the following rules:
Given an integer, we need to find the super digit of the integer n.
If n has only 1 digit, then its super digit is n.
Otherwise, the super digit of n is equal to the super digit of the sum of the digits of n.

superDigit has the following parameter(s):

string n: a string representation of an integer
int k: the times to concatenate n to make p.

Input
The first line contains two space separated integers, n and k.

Constraints:
1 <= n <= 10^100000
1 <= k <= 100000

Output
In a new line, print the the super digit of n repeated k times.

Example
Input:
148 3
Output:
3
Explanation:
Here n=148 and k=3 , so p=148148148.

super_digit(p) = super_digit(148148148) 
               = super_digit(1+4+8+1+4+8+1+4+8)
               = super_digit(39)
               = super_digit(3+9)
               = super_digit(12)
               = super_digit(1+2)
               = super_digit(3)
               = 3
*/

import java.util.Scanner;
public class A2_Recursive_digit_sum {
  public static String superDigit(String sumn) {
    if(sumn.length()==1) {
      return sumn;
    }
    else {
      long sum = 0;
      for (int i=0; i<sumn.length(); i++) {
        sum += (sumn.charAt(i) - '0');
      }
      return superDigit(Long.toString(sum));
    }
  }
  public static void main (String args[]) {
    Scanner input = new Scanner(System.in);
    String n = input.next();
    int k = input.nextInt();
    String sumn = "";
    for (int i=0; i<k; i++) {
      sumn += n;
    }
    // System.out.println(sumn);
    System.out.println(superDigit(sumn));
  }
}
