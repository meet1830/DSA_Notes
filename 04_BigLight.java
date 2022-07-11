/*
BigLight
Gian and Suneo want their heights to be equal so they asked Doraemons help. Doraemon gave a big light to both of them but both big lights have different speeds of magnifying. Let us assume the big light given to Gian can increase the height of a person by v1 m/s and that of Suneos big light is v2 m/s. At the end of each second Doraemon check if their heights are equal or not.

Given the initial height of Gian and Suneo, your task is to check whether the height of Gian and Suneo will become equal at some point or not, assuming they both started at the same time.

Input
The only line of the input contains 4 spaced integers, h1(height of gian), h2(height of suneo), v1(speed of Gians big light), and v2(speed of Suneos big light).

Constraints
1 <= h2 < h1<=10000 1 <= v1 <= 10000 1 <= v2 <=10000

Output
Print true if their height will become equal at some point (as seen by Doraemon) else print false.

Example
Sample input
4 2 2 4

Sample output
true

Explanation
Height of Gian goes as- 4 6 8 10. . height of Suneo goes as:- 2 6 10.. at the end of 1 second their height will become equal.

Sample Input
5 4 1 6

Sample Output
false
*/

/*
import java.util.Scanner;

public class BigLight {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int h1 = sc.nextInt();
    int h2 = sc.nextInt();
    int v1 = sc.nextInt();
    int v2 = sc.nextInt();
    int state = 0;
    while(h1<=10000 && h2<=10000) {
      h1 += v1;
      h2 += v2;
      if (h1 == h2) {
        state = 1;
        break;
      }
    }
    if (state == 1) System.out.println(true);
    else System.out.println(false);
    sc.close();
  }
}
*/

/*
import java.util.Scanner;

public class BigLight {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    float h1 = sc.nextFloat();
    float h2 = sc.nextFloat();
    float v1 = sc.nextFloat();
    float v2 = sc.nextFloat();
    float n;
    //ap formula for nth term
    //a1+(n-d1) = a2+(n-d2);
    //solve for n
    n = (h2-h1)/(v1-v2) + 1;
    // System.out.println(n);
    if (n%1==0.0) System.out.println(true);
    else System.out.println(false);
    sc.close();
  }
}
*/

import java.util.*;

public class BigLight {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int h1 = sc.nextInt(), h2 = sc.nextInt(), v1 = sc.nextInt(), v2 = sc.nextInt();
    // n = (h2-h1)/(v1-v2) + 1;
    if (v1 == v2) {
      if (h1 == h2)
        System.out.println("true");
      else
        System.out.println("false");
    } 
    else {
      if ((h1 - h2) % (v2 - v1) == 0 && (h1 - h2) / (v2 - v1) > -1)
        System.out.println("true");
      else
        System.out.println("false");
    }
    sc.close();
  }
}
