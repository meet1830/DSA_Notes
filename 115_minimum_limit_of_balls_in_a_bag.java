/*
Minimum Limit of Balls in a Bag
You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.

You can perform the following operation at most maxOperations times:

Take any bag of balls and divide it into two new bags with a positive number of balls. For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls. Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.

Print the minimum possible penalty after performing the operations.

Input:
The first line of the input contains the number 𝑛(length of array) and m(maximum number of operations) The next n integers denotes the elements of the array.

Output:
print the index of the element if it satisfies the condition else print -1

Constraints:
1 <= nums.length <= 105
1 <= maxOperations, nums[i] <= 109
Sample Input 1
1 2
9
Sample Output 1
3

Explanation
Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
Sample Input 2
4 4
2 4 8 2
Sample Output 2
2
Explanation
Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2]. The bag with the most number of balls has 2 balls, so your penalty is 2 an you should return 2.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    int a[] = new int[n];
    int l = 1, r = 1;
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
      r = Math.max(a[i], r);
    }
    int ans = r;
    while (l <= r) {
      int m = (l + r) / 2;
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        cnt += (a[i] + m - 1) / m - 1;
      }
      if (cnt <= k) {
        r = m - 1;
        ans = m;
      } else {
        l = m + 1;
      }
    }
    System.out.println(ans);
  }
}
