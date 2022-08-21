/*
Pair sum divisible by K
Given an array of N integers and an integer K, your task is to calculate the count of pairs whose sum is divisible by K.

Input The first line of input contains two integers N and K, the next line contains N space-separated integers depicting values of an array.

Constraints:-

1 < = N < = 100000

1 < = Arr[i] <= 100000

1 <= K <= 100000

Output

Print the count of required pairs.

Example

Sample Input 5 4 1 2 3 4 5

Sample Output 2

Sample Input 5 3 1 2 3 4 5

Sample Output 4

Explanation:- In Sample 2, (1 5), (1 2), (2 4), and (4 5) are the required pairs
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int a[] = new int[n];
    HashMap<Integer, Integer> cnt = new HashMap();
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
      int count = 0;
      if (cnt.containsKey(a[i] % k)) {
        count = cnt.get(a[i] % k);
      }
      count++;
      cnt.put(a[i] % k, count);
    }
    long ans = 0;
    if (cnt.containsKey(0)) {
      long count = cnt.get(0);
      ans += count * (count - 1) / 2;
    }
    if (k % 2 == 0 && cnt.containsKey(k / 2)) {
      long count = cnt.get(k / 2);
      ans += count * (count - 1) / 2;
    }
    for (int i = 1; i < (k + 1) / 2; i++)
      if (cnt.containsKey(i) && cnt.containsKey(k - i)) {
        ans += (long) cnt.get(i) * cnt.get(k - i);
      }
    System.out.println(ans);
  }
}