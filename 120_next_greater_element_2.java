/*
Next Greater Element
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, print -1 for this number.

Input:
The first line contains a single integer n Second line conatins n spaced integers

Output:
print the next greater element for each array value and if it doesnt exist then print -1

Constraints
1 <= nums.length <= 10^4 -10^9 <= nums[i] <= 10^9

Sample Input 1
3 1 2 1

Sample Output 1
2 -1 2
Explanation
The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Sample Input 2
6
1 2 3 4 3 3
Sample Output 2
2 3 4 -1 4 4
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    int size = input.nextInt();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++)
      arr[i] = input.nextInt();

    Stack<Integer> stack = new Stack<>();
    int[] res = new int[size];

    for (int i = 2 * size - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[i % size] >= stack.peek())
        stack.pop();
      if (i < size) {
        if (!stack.isEmpty())
          res[i] = stack.peek();
        else
          res[i] = -1;
      }
      stack.push(arr[i % size]);
    }

    for (int x : res)
      System.out.print(x + " ");
  }
}