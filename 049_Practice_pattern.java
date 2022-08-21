/*
Print Pattern
Print a sequence of numbers starting with N, without using loop, in which A[i+1] = A[i] - 5, if A[i]>0, else A[i+1] = A[i] + 5 repeat it until A[i]=N.

Note:- Once you change an operation you need to continue doing it till possible.

Input
The only line contains an integer, n.
Constraints
0 < N < 1000
Output
Print the pattern with space-separated integers.

Example
Sample Input

16
Sample Output

16 11 6 1 -4 1 6 11 16
Sample Input

10
Sample Output

10 5 0 5 10
Explanation

We basically first reduce 5 one by one until we reach a negative or 0. After we reach 0 or negative, we one by one add 5 until we reach N.
*/

import java.util.*;
import java.io.*;
public class C1_Practice_pattern {
    public static int patternneg (int n, int target) {
        if (n <= 0) {
            return n;
        }
        else {
            n -= 5;
            print(n);
            return patternneg (n, target);
        }
    }
    public static int patternpos (int n, int target) {
        if (n == target) {
            return 0;
        }
        else {
            n += 5;
            print(n);
            return patternpos (n, target);
        }
    }
    public static void print (int value) {
        System.out.print(value + " ");
    }
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        print(n);
        int garbage1 = patternneg(n, n);
        int garbage2 = patternpos(garbage1, n);
    }
}

/*
import java.util.*;
public class Main {
 
        public static void Pattern(int check, int current, Boolean flag) {
                System.out.print(current + " ");
 
                    if (flag == false && check==current) return;
 
                    if(flag) {
                        if (current-5 >0) Pattern(check, current-5, true);
                        else Pattern(check, current-5, false);
                    }
 
                    else{
                        Pattern(check, current+5, flag);
                    }
            
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
 
            // System.out.print(num + " ");
            Pattern(num,num,true);
 
        }
}
*/
