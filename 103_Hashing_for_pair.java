/* 
Hashing for Pair
You are given an array arr (distinct integers) of size n, and you are also given a sum. You need to find if two numbers in arr exists that have sum equal to the given sum.

Input
line 1: contains two integers n and sum denoting size of array and target value.

line 2: contains n separated integers denoting elements of array.

Output
Print "1"(without quotes) if any pair found, othwerwise print "0"(without quotes) if not found.

Constraints
1 <= n <= 10^4

1 <= sum <= 10^5

1 <= arr[i] <= 10^4

Time Complexity:O(nlogn)

Only one valid answer exists.

Sample Input
4 9
2 7 5 11
Sample Output
1
Explanation
Because arr[0] + arr[1] == 9, we print 1. */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
        int size = input.nextInt(), sum = input.nextInt();
        int[] arr = new int[size];
      ArrayList<Integer> list = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
          list.add(arr[i]);
        }
      for(int i = 0; i < size; i++) {
        int second = sum - arr[i];
        if(list.contains(second)) {
          System.out.println(1);
          return;
        }
      }
      System.out.println(0);
	}
}