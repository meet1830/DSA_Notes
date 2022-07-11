/*
Armstrong numbers upto a number
Task is to print all the armstrong numbers which occur upto the given digit of numbers. For example, digit 4 means upto a 4 digit number.

Input: The digit upto which armstrong numbers are to be printed.

Output: All occuring armstrong numbers.

Constraints: input digit <7 and >0.

Eg:
Input: 
3

Output:
1
153
370
371
407

Explanation: Here 3 given as input means we have to print all occuring armstrong numbers uptill 3 digit numbers that is uptill 999. 
*/

import java.util.Scanner;
public class P1_Armstrong_numbers_upto_a_number {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int d = input.nextInt();
    long n = 0;
    for (int i=0; i<d; i++) {
      n = n*10 + 9;
    }
    // System.out.println(n);
    // 4 -> 9999
    long sum = 0, temp=0;
    for(long i=1; i<=n; i++) {
      temp = i;
      sum = 0;
      int count = 0;
      while (temp>0) {
        temp /= 10;
        count++;
      }
      temp = i;
      while(temp>0) {
        sum += Math.pow(temp%10, count);
        temp /= 10;
      }
      if(sum == i && sum >= 10) {
        System.out.println(i);
      }
    }
    input.close();
  }
}