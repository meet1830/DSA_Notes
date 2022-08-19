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
    // occurrences can always be factors of the given x
    // for eg, if n = 12, and x = 12, then factors can be 
    // 4*3, 3*4, 12*1, 1*12, 2*6, 6*2 hence count = 6 -> ans
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


// The idea is based on the observation that the ith row contains all the multiples of i in the range [1, N]. 
// Therefore, X occurs in the ith row if and only if X is exactly divisible by i and X / i should be less than or equal to N. 
// If found to be true, increment the count by 1
// O(n), O(1)
public class Main {
  public static void main(String[] args) {
    int n = 5, x = 5, count = 0;
    for (int i = 1; i <= n; i++) {
      if (x % i == 0 && x / i <= n)
        count++;
    }
    System.out.println(count);
  }
}
// 2