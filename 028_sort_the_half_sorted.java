/*
SORT THE HALF SORTED
Given an integer array of which both first half and second half are sorted. The task is to merge two sorted halves of the array into a single sorted array.

Note: The two halves can be of arbitrary sizes.

Input
line 1: contains an integer n denoting size of array.

line 2: contains n spaced integers denoting elements of array.

Output
Print an array consisting of n elements denoting the sorted array.

Constraints
1<=n<=10^5

-10^6<=arr[i]<=10^6

Expected Time Complexity: O(N)

Expected Space Complexity: O(N)

Sample Input
6
2 3 8 -1 7 10
Sample Output
-1 2 3 7 8 10
*/

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      int[] arr = new int[n];
      for (int i=0; i<n; i++) {
        arr[i] = input.nextInt();
      }
      ArrayList<Integer> left = new ArrayList<>(), 
        right = new ArrayList<>();
      int i = 0;
      for (; i<n-1; i++) {
        if (arr[i+1] > arr[i]) {
          left.add(arr[i]);
        }
        else {
          left.add(arr[i++]);
          break;
        }
      }
      for (; i<n; i++) {
        right.add(arr[i]);
      }
      
      // compare the elements ans place them in originals array
      i = 0;
      int l = 0, r = arr.length - 1;
      int j = 0, k = l;
      while (i<left.size() && j<right.size()) {
        if (left.get(i) <= right.get(j)) {
          arr[k++] = left.get(i++);
        }
        else {
          arr[k++] = right.get(j++); 
        }
      }

      // add remaining elements to array
      while (i<left.size()) {
        arr[k++] = left.get(i++);
      }
      while (j<right.size()) {
        arr[k++] = right.get(j++);
      }
      
      // print array
      for(int x : arr) {
        System.out.print(x + " ");
      }
      System.out.println("");
    }
}
