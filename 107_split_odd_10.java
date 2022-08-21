/*
splitOdd10
Given an array of ints, is it possible to divide the ints into two groups, so that the sum of one group is a multiple of 10, and the sum of the other group is odd. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitOdd10(). (No loops needed.)

Input:
The first line contains a single integer n(number of elements) The second line contains n space integers

Output:
Print YES if its possible to divide it into two groups with given condition else print NO

Constraints:
1 <= n <= 100
-100<=a[i]<=100
Sample Input 1
3
5 5 5
Sample Output 1
YES
Sample Input 2
3
5 5 6
Sample Output 2
NO
*/

// here if the sum of all elements is odd then it can be divided into groups as in first group if multiple of 10 then it is even and when added to odd hte total sum becomes odd. 
// they have told us that every element should be in one or the other group. they have not told us that there should be at least one element in both groups or there should be elements from the array in both the groups. hence consider first group single element as 0 and just check for second condition.
import java.util.*;

public class Main {
    public static int sum(int i, int[] a) {
        if (i == -1) {
            return 0;
        }
        return a[i] + sum(i - 1, a);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        if (sum(size - 1, arr) % 2 == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}