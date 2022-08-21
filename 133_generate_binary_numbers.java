/*
 * Generate Binary Numbers
Given a number N. The task is to generate and print binary representation for all numbers from 1 to N.
Try solving this using a queue.

Input
The only line of input contains a single integer N.

Constraints:
1 <= N <= 50000

Output
In a new line, print binary representation for all numbers from 1 to N.

Example
Input:
5
Output:
1 10 11 100 101
Explanation:
For n=1, binary representation is 1. 
For n=2, binary representation is 10. 
For n=3, binary representation is 11. 
For n=4, binary representation is 100. 
For n=5, binary representation is 101. 
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Deque<Integer> q = new LinkedList();
        q.add(1);
        System.out.print(1 + " ");
        int size = 1;
        for (int i = 2; i <= n; i++) {
            int carry = 1;
            for (int j = 0; j < size; j++) {
                int x = q.poll();
                q.add((x + carry) % 2);
                carry = (x + carry) / 2;
            }
            if (carry == 1) {
                q.add(carry);
                size++;
            }
            for (int j = 0; j < size; j++) {
                int x = q.peekLast();
                q.removeLast();
                System.out.print(x);
                q.addFirst(x);
            }
            System.out.print(" ");
        }
    }
}
