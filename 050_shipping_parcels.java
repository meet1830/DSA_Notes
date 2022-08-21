/*
Shipping Parcels
A conveyor belt has parcels that must be shipped from one point to another within D days.

The i-th parcel on the conveyor belt has a weight of weights[i]. Each day, we load the ship with parcels on the conveyor belt (in the order given). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the parcels on the conveyor belt being shipped within D days.

Input
First line contains N, size of the conveyor belt and D days separated by space.
Second line contains weights of parcels.

Constraints:
1 <= D <= N <= 5*10^4
1 <= weights[i] <= 500

Output
Print the least weight capacity of the ship that will result in all the parcels on the conveyor belt being shipped within D days in new line.

Example
Input:
10 5
1 2 3 4 5 6 7 8 9 10
Output:
15 
Explaination:
A ship capacity of 15 is the minimum to ship all the parcels in 5 days like this:

1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10
Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the parcels into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
*/

import java.util.Scanner;
public class Main {
public static int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), d = input.nextInt();
    int[] arr = new int[n];
    for (int i=0; i<n; i++) {
      arr[i] = input.nextInt();
    }
    int ans= shipWithinDays(arr,d);
    System.out.println(ans);
  }
}

/*
Explanation of this solution:

The key is left = max(weights), right = sum(weights),
which are the minimum and maximum possible weight capacity of the ship.

Therefore the question becomes Binary Search to find the minimum weight capacity of the ship between left and right.
We start from
mid = (left + right) / 2 as our current weight capacity of the ship.
need = days needed == 1
cur = current cargo in the ship == 0

Start put cargo into ship in order.
when need > D, it means the current ship is too small, we modify left = mid + 1 and continue
If all the cargo is successfully put into ships, we might have a chance to find a smaller ship, so let right = mid and continue.
Finally, when our left == right, we reach our answer
*/
