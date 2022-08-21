/*
NUMBER OF DAYS
Given the number of the month, your task is to calculate the number of days present in the particular month.

Note:- Consider non-leap year

User task: Since this is a functional problem you do not have to worry about the input. You just have to complete the function numberofdays() which contains M as a parameter.

Constraints:- 1 <= M <= 12

Output Print the number of days in the particular month.

Example Input

1
Output

31
*/

import java.util.Scanner;

public class Number_Of_Days {

  static void numberofdays(byte m) {
    if (m>0 && m<=12) {
      if (m>0 && m<=7 && m!=2) {
        if (m%2!=0) System.out.println("31");
        else System.out.println("30");
      } 
      else if (m>7 && m<=12) {
        if (m%2==0) System.out.println("31");
        else System.out.println("30");
      } 
      else System.out.println("28");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    byte M = sc.nextByte();
    numberofdays(M);
    sc.close();
  }
}