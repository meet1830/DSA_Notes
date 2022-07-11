/*
Merge Sort: Counting Inversions
In an array, arr , the elements at indices i and j (where i < j ) form an inversion if arr[i] > arr[j]. In other words, inverted elements arr[i] and arr[j] are considered to be "out of order". To correct an inversion, we can swap adjacent elements.

Example arr = [2, 4, 1] To sort the array, we must perform the following two swaps to correct the inversions:

swap(arr[1], arr[2])
swap(arr[0], arr[1])
The sort has two inversions: (4,1) and (2,1) .

Given an array , output the number of inversions to sort the array.

Input Format

The first line contains an integer, d, the number of datasets.

Each of the next d pairs of lines is as follows:

The first line contains an integer, n , the number of elements in arr .
The second line contains n space-separated integers, arr[i].
Output Format Print a single integer in a new line, which is the number of inversions.

Constraints

1 <= d <= 15

1 <= n <= 105

1 <= arr[i] <= 107

Sample Input

STDIN       Function
-----       --------
2           d = 2
5           arr[] size n = 5 for the first dataset
1 1 1 2 2   arr = [1, 1, 1, 2, 2]
5           arr[] size n = 5 for the second dataset     
2 1 3 1 2   arr = [2, 1, 3, 1, 2]

Sample Output

0  
4   
Explanation

We sort the following datasets:

arr = [1,1,1,2,2]is already sorted, so there are no inversions for us to correct.
arr = [2,1,3,1,2] -->(1 swap) [1,2,3,1,2] -->(2 swaps) [1,1,2,3,2] -->(1 swaps) [1,1,2,2,3]
We performed a total of swaps to correct inversions.

Expected Time Complexity = O(log n)
*/

import java.util.Scanner;
public class A1_merge_sort_counting_inversions {
  public static long count(int[] arr) {
    if (arr.length == 1) return 0;
    int mid = arr.length / 2;
    int[] left = new int[mid];
    int[] right = new int[arr.length - mid];
    for (int i=0; i<left.length; i++) {
      left[i] = arr[i];
    }
    for (int i=0; i<right.length; i++) {
      right[i] = arr[mid + i];
    }
    long cnt = count(left) + count(right);
    int i=0, j=0, k=0;
    while (i<left.length && j<right.length) {
      if (left[i]<=right[j]) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
        cnt += mid - i;
      }
    }
    while (i<left.length) {
      arr[k++] = left[i++];
    }
    while (j<right.length) {
      arr[k++] = right[j++];
    }
    return cnt;
  }
  public static void main (String args[]) {
    Scanner input = new Scanner(System.in);
    int testcases = input.nextInt();
    while (testcases-- > 0) {
      int n = input.nextInt();
      int arr[] = new int[n];
      for (int i=0; i<n; i++) {
        arr[i] = input.nextInt();
      }
      System.out.println(count(arr));
    }
  }
}
