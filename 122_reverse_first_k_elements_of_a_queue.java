/*
Reverse First K elements of Queue
Given an integer K and a queue of integers with N elements, your task is to reverse the order of the first K elements of the queue, leaving the other elements in the same relative order.

Input
The first line of input contains two integers N and K, the next line contains N space-separated integers depicting values in queue.

Output
You need to Print the modified Queue.

Constraints:
1 <= K <= N <=10000 1 <= elements <=10000

Sample Input:
5 3
1 2 3 4 5
Sample Output:
3 2 1 4 5
Explaination
1 2 3 are first K element now reversing their order = 3 2 1 then adding it to queue keeping all others as it is
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
      public static void main(String[] args) throws java.lang.Exception {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt(), k = input.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++)
                  queue.add(input.nextInt());

            Stack<Integer> stack = new Stack<>();
            Queue<Integer> res = new LinkedList<>();

            for (int i = 0; i < k; i++)
                  stack.add(queue.poll());

            for (int i = 0; i < k; i++)
                  res.add(stack.pop());

            for (int i = k; i < n; i++)
                  res.add(queue.poll());

            for (int i = 0; i < n; i++)
                  System.out.print(res.poll() + " ");
      }
}