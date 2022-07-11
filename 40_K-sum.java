/*
K-sum
Given an array arr[] of size N and a number K, the task is to find the smallest number M such that the sum of the array becomes lesser than or equal to the number K when every element of that array is divided by the number M.

Note: Each result of the division is rounded to the nearest integer greater than or equal to that element.
For example: 10/3 = 4 and 6/2 = 3

Input
The first line contains two integers N and K.
Next line contains N integers denoting the elements of arr[]

Constraints:
1 <= N <= 100000
1 <= arr[i] <= 100000
1 <= K <= 100000000

Output
Print a single integer the value of smallest number M.

Example
Input:
4 6
2 3 4 9
Output:
4 

Explanation:
When every element is divided by 4 - 2/4 + 3/4 + 4/4 + 9/4 = 1 + 1 + 1 + 3 = 6
When every element is divided by 3 - 2/3 + 3/3 + 4/3 + 9/3 = 1 + 1 + 2 + 3 = 7 which is greater than K.
Hence the smallest integer which makes the sum less than or equal to K = 6 is 4.
*/

// RECURSIVE APPROACH -> NOT OPTIMAL -> FAILS FOR LARGE VALUES
import java.util.*;

public class Main {
  public static int calcSum(int[] arr, int m, int k) {
    int sum = 0;
    for (int idx = 0; idx < arr.length; idx++) {
      if (arr[idx] % m != 0) {
        sum += 1 + arr[idx] / m;
      }
      else {
        sum += arr[idx] / m;
      }
    }
    if (sum <= k) {
      return m;
    }
    else {
      return calcSum(arr, m + 1, k);
    }
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }
    // calling recursive function 
    int m = calcSum(arr, 1, k);
    System.out.println(m);
  }
}



// BINARY SEARCH APPROACH -> OPTIMAL
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }
    int res = ksum(arr, k);
    System.out.println(res);
  }
  public static int ksum(int[] arr, int k) {
    int l = 1, r = Integer.MAX_VALUE;
    while(l < r) {
      int div = l + (r - l) / 2;
      int sum = 0;
      for (int x : arr) {
        sum += (x + div - 1) / div;
      }
      if (sum > k) {
        l = div + 1;
      }
      else {
        r = div;
      }
    }
    return l;
  }
}
