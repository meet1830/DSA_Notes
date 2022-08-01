/*
X Occurence
For a given number N, Consider a table of N X N in which elements at the intersection of ith row and jth column are the product of i and j, i. e i x j. Also given a positive integer X. Your task is to count the number of elements in the table that contain the integer X.

Input User Task: Write a program that takes the integer N and the integer X as parameter.

Constraints:- 1 <= N <= 10^5 1 <= X <= 10^9

Output Return the count of X.

Example: Sample Input:- 5 5

Sample Output:- 2

Explanation:- table :- 1 2 3 4 5 2 4 6 8 10 3 6 9 12 15 4 8 12 16 20 5 10 15 20 25

Count of occurrence of X is : 2

Sample Input:- 10 13

Sample Output:- 0
*/

import java.io.*;
import java.util.*;
public class Main {
  public static void G2_x_occurence (String args[]) {
    Scanner input = new Scanner(System.in);
    // finding and printing the count of factors of x 
    // this solution is of complexity O(root(n))
    int n = input.nextInt(), x = input.nextInt(), ans = 0;
    for (int i=1; i*i<=x; i++) {
      if (x%i==0) {
        int a = i, b = x/i;
        if (a>n || b>n) {
          continue;
        }
        if (a != b) {
          ans += 2;
        }
        else {
          ans++;
        }
      }
    }
    System.out.println(ans);
  }
}

/*
Explanation: Here x can be written in pairs of its factors as product of i and j that is the product of a row and column of the table matrix. 
*/
