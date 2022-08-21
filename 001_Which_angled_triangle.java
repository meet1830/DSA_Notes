/*
Which angled triangle
Given the 3 sides of a triangle, find out whether it is acute-angled, right-angled, or obtuse-angled.

You need to output 1 for acute, 2 for right-angled, and 3 for an obtuse-angled triangle. You can assume that the input values always form a triangle and are valid integers.

Note:
A triangle is acute-angled, if twice the square of the largest side is less than the sum of squares of all the sides. --> 1

A triangle is right-angled, if twice the square of its largest side is exactly equal to the sum of squares of all the sides. --> 2

A triangle is obtuse-angled, if twice the square of its largest side is greater than the sum of squares of all the sides. --> 3


Input:
3 4 5

Output:
2

Explanation:
Since 2x5x5 is equal to 5x5 + 3x3 + 4x4, So this is a right-angled triangle and hence, the answer is 2.

Input:
3 3 3

Output:
1

Explanation:
Since 2x3x3 is less than 3x3 + 3x3 + 3x3, So this is an acute-angled triangle and hence, the answer is 1.
*/

import java.util.Scanner;

public class A1_Which_angled_triangle {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
    int max = Math.max(a, Math.max(b, c));
    if (2*max*max < a*a + b*b + c*c) System.out.println(1);
    else if (2*max*max == a*a + b*b + c*c) System.out.println(2); 
    else System.out.println(3);
    input.close();
  }
}
