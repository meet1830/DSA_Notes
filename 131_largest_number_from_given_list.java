/*
 * Largest number from given list
Given an array of N integers, your task is to calculate the largest number that can be formed by appending the numbers from the given array. For eg:- If the numbers are { 10, 3, 31} then the largest number will be 33110

Input
First line of input contains a single integer N, next line contains N space separated integers depicting values of array.

Output
Print the largest number that can be formed using the array elements.

Constraints:
1 < = N < = 100000 1 < = Arr[i] < = 100000

Sample Input:
3
10 3 31
Sample Output:
33110
*/

import java.util.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String a[] = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = input.next();

        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String s = a + b;
                String t = b + a;
                return t.compareTo(s);
            }
        });

        for (int i = 0; i < n; i++)
            System.out.print(a[i]);
    }
}