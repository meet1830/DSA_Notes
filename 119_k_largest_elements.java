/*
K largest elements
Given an array of N positive integers, print K largest elements from the array.

Input
The first line contains an integer N and integer K.
The second line contains N spaced integers, the elements of the array.
Constraints
1 ≤ N ≤ 10⁴
K <= N
1 ≤ arr[i] ≤ 10⁶
Output
Print the K largest elements in descending order.

Expected Time Complexity: O(N*logK)
Expected Auxiliary Space: O(K)

Example
Sample Input

5 2
12 5 787 1 23
Sample Output

787 23
Explanation

First largest element in the array is 787 and the second largest
is 23.
Sample Input

7 3
1 23 12 9 30 2 50
Sample Output

50 30 23
Explanation

Three Largest element in the array are 50, 30 and 23.
*/

import java.util.*;

// here cannot use sorting decreasing and printing first k elements 
// because then the tc will be nlogn and we need here nlogk
// also cannot use max heap for the same reason

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int n = input.nextInt(), k = input.nextInt();
    for (int i = 0; i < n; i++) {
      pq.add(input.nextInt());

      if (i >= k)
        pq.poll();
    }

    // values stored in pq from smallest to biggest
    Stack<Integer> st = new Stack<Integer>();
    for (int i = 0; i < k; i++) {
      st.push(pq.poll());
    }

    while (!st.isEmpty())
      System.out.print(st.pop() + " ");
  }
}