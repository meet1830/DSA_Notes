/*
Product of Array Except Self
Given an array of n integers where n > 1, print an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Input
line 1: contains an integer n denoting number of elements of array.

line 2: contains n separated integers denoting elements of array. All integers are greater than 0.

Output
print an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Constraints
It is guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Time Complexity:O(n)

Sample Input
4
4 3 2 10
Sample Output
60 80 120 24
*/

import java.util.Scanner;
public class G2_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        long prod = 1;
        for (int i=0; i<n; i++) {
            arr[i] = input.nextInt();
            prod *= arr[i];
        }
        for (int i=0; i<n; i++)
            System.out.println(prod/arr[i] + " ");
        input.close();
    }
}
