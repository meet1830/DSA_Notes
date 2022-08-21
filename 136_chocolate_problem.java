/*
 * Chocolate Problem
Given an array/list of integer numbers 'CHOCOLATES' of size 'N', where each value of the array/list represents the number of chocolates in the packet. There are ‘M’ number of students and the task is to distribute the chocolate to their students. Distribute chocolate in such a way that:

Each student gets at least one packet of chocolate.
The difference between the maximum number of chocolate in a packet and the minimum number of chocolate in a packet given to the students is minimum.
Example: Given 'N' : 5 (number of packets) and 'M' : 3 (number of students) And chocolates in each packet is : {8, 11, 7, 15, 2}

All possible way to distribute 5 packets of chocolates among 3 students are -

( 8,15, 7 ) difference of maximum-minimum is ‘15 - 7’ = ‘8’ ( 8, 15, 2 ) difference of maximum-minimum is ‘15 - 2’ = ‘13’ ( 8, 15, 11 ) difference of maximum-minimum is ‘15 - 8’ = ‘7’ ( 8, 7, 2 ) difference of maximum-minimum is ‘8 - 2’ = ‘6’ ( 8, 7, 11 ) difference of maximum-minimum is ‘11 - 7’ = ‘4’ ( 8, 2, 11 ) difference of maximum-minimum is ‘11 - 2’ = ‘9’ ( 15, 7, 2 ) difference of maximum-minimum is ‘15 - 2’ = 13’ ( 15, 7, 11 ) difference of maximum-minimum is ‘15 - 7’ = ‘8’ ( 15, 2, 11 ) difference of maximum-minimum is ‘15 - 2’ = ‘13’ ( 7, 2, 11 ) difference of maximum-minimum is ‘11 - 2’ = ‘9’

Hence there are 10 possible ways to distribute ‘5’ packets of chocolate among the ‘3’ students and difference of combination (8, 7, 11) is ‘maximum - minimum’ = ‘11 - 7’ = ‘4’ is minimum in all of the above.

Input Format : The first line of input contains an integer ‘T’ denoting the number of test cases. The next ‘2*T’ lines represent the ‘T’ test cases.

The first line of each test case contains two space-separated integers ‘N’ denoting the number of packets of chocolate and ‘M’ denotes the number of students.

The second line of each test case contains ‘N’ space-separated integers denoting the number of chocolate in each of ‘N’ packets.

Output Format : For each test case, print the minimum difference of the chocolates contained in the packets distributed to the students.

Constraint : 1 <= T <= 50 2 <= M <= N <= 10^4 1 <= CHOCOLATES[i] <= 10^9

Sample Input 1 : 2 3 2 7 2 4 4 3 3 5 1 6

Sample Output 1 : 2 3

Explanation For Sample Input 1 : Test Case 1 :

All possible way to distribute 3 packets of chocolate among 2 students are -

( 7, 2 ) difference is ‘7 - 2’ = ‘5’ ( 7, 4 ) difference is ‘7 - 4’ = ‘3’ ( 2, 4 ) difference is ‘4 - 2’ = ‘2’

There are three ways to distribute 3 packets of chocolate among 2 students but pair ( 4, 2 ) has minimum difference in ‘maximum - minimum’ = ‘4 - 2’ = ‘2’ Hence answer is ‘2’

Test Case 2 :

All possible way to distribute 4 packets of chocolate among 3 students are -

( 3, 5, 1 ) difference is ‘5 - 1’ = ‘4’ ( 5, 1, 6 ) difference is ‘6 - 1’ = ‘5’ ( 1, 6, 3 ) difference is ‘6 - 1’ = ‘5’ ( 6, 5, 3 ) difference is ‘6 - 3’ = ‘3’

There are four options to choose 3 packets of chocolate. Only ( 6, 5, 3 ) pair has the minimum difference ‘6 - 3’ = ‘3’ comparing other pair of difference ( 4, 5, 5 ) Hence answer is ‘3’
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int test = input.nextInt();
        while (test-- > 0) {
            int n = input.nextInt(), s = input.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int diff[] = new int[n - s + 1];
            Arrays.sort(arr);
            for (int i = 0; i <= n - s; i++) {
                diff[i] = arr[i + s - 1] - arr[i];
            }
            Arrays.sort(diff);
            System.out.println(diff[0]);
        }
    }
}