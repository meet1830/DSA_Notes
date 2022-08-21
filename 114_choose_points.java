/*
Choose Points
You are given N points on a horizontal axis. Find the number of ways you can choose 3 points such that maximum distance between those points is not greater than d.

Input
The first line contains two integers: N and d . The next line contains N space separated integers x1, x2,...,xN, — the x-coordinates of the points that Petya has got.

Output
Print the number of ways to choose 3 points.

Constraints:
1 ≤ N ≤ 100000 1 ≤ d ≤ 1000000000 1 <= |x[i]| <= 1000000000

It is guaranteed that the coordinates of the points in the input strictly increase.

Sample Input:
4 3
1 2 3 4
Sample Output:
4
Explaination
1 2 3 1 2 4 2 3 4 1 3 4 are the required triplets
*/

import java.util.*;

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), d = input.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
      int l = i, r = n - 1;
      int idx = i;
      while (l <= r) {
        int mid = (l + r) / 2;
        if (a[mid] <= a[i] + d) {
          idx = mid;
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      int p = idx - i;
      ans += (long) p * (p - 1) / 2;
    }
    System.out.println(ans);
  }
}