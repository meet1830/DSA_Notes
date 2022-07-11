/*
Time Conversion
Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

Note: -
12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.

12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

Example
S = 12:01:00PM

Return 12:01:00

S = 12:01:00AM

Return 00:01:00

Function Description
Complete the code in the editor. It should take the input string and return a new string representing the input time in 24 hour format.

Input
string s: a time in 12 hour format

Output
string: the time in 12 hour format

Input Format
A single string that represents a time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM).

Constraints
All input times are valid

Sample Input 0
07:05:45PM

Sample Output 0
19:05:45
*/

import java.util.Scanner;

public class A1_Time_Conversion {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String t = input.next();
    String h = t.substring(0,2);
    int hr = Integer.parseInt(h);
    // System.out.println(hr);
    String state = t.substring(8);
    // System.out.println(state);
    if (state.equals("PM") && hr<12){
        int temp = hr + 12;
        h = String.valueOf(temp);
    } 
    if(state.equals("AM") && hr==12){
      h = "00";
    }
    System.out.println(h + t.substring(2, 8));
    input.close();
  }
}
