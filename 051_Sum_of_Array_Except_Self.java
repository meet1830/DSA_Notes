/*
Sum of Array Except Self
Given an array of n integers where n > 1, return an array output such that output[i] is equal to the sum of all the elements of nums except nums[i]. Input consists of N in the first line and then the n integer array. All integers in array are greater than 0.

Input
Input consists of the first line containing integer n followed by n numbers for the array.

Constraints:
1 <= n <= 5000
1 <= a[i] <= 1000000
It is guaranteed that the sum of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Output
In a new line, print the updated array.

Example
Input:
4
4 3 2 10
Output:
15 16 17 9
Explaination:
After updation, 
a[0]=15 i.e., 3+2+10
a[1]=16 i.e., 4+2+10
a[2]=17 i.e., 4+3+10
a[3]=9  i.e., 4+3+2 
*/

import java.util.*;

public class G1_Sum_of_Array_Except_Self {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = input.nextInt();
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += arr[i];
        }
        int ans = sum;
        for (int i=0; i<n; i++) {
            ans = sum - arr[i];
            System.out.print(ans + " ");
            ans = sum;
        }
        input.close();
    }
}