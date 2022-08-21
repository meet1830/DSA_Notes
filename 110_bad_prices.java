/*
Bad Prices
Polycarp analyzes the prices of the new berPhone. At his disposal are the prices for n last days: a₁,a₂,…,aₙ, where ai is the price of berPhone on the day i.

Polycarp considers the price on the day i to be bad if later (that is, a day with a greater number) berPhone was sold at a lower price. For example, if n=6 and a=[3,9,4,6,7,5], then the number of days with a bad price is 3 — these are days 2 (a₂ = 9), 4 (a₄ = 6) and 5 (a₅=7).

Print the number of days with a bad price.

You have to answer t independent data sets.

Input
The first line contains an integer t (1≤t≤10000) — the number of sets of input data in the test. Input data sets must be processed independently, one after another.

Each input data set consists of two lines. The first line contains an integer n (1≤n≤150000) — the number of days. The second line contains n integers a₁,a₂,…,aₙ (1≤aᵢ≤10^6), where aᵢ is the price on the i-th day.

It is guaranteed that the sum of n over all data sets in the test does not exceed 150000.

Output
Print t integers, the j-th of which should be equal to the number of days with a bad price in the j-th input data set.

Example
Input

5
6
3 9 4 6 7 5
1
1000000
2
2 1
10
31 41 59 26 53 58 97 93 23 84
7
3 2 1 2 3 4 5
Output

3
0
1
8
2

*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int test = input.nextInt();
        for (int i = 0; i < test; i++) {
            int n = input.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = input.nextInt();
            }
            // int cnt = 0, min = 10000000;
            int cnt = 0, min = a[n - 1];
            // can also take min as last element of array and loop from n - 2
            // for(int j = n - 1; j >= 0; j--) {
            for (int j = n - 2; j >= 0; j--) {
                if (a[j] > min) {
                    cnt++;
                } else {
                    min = a[j];
                }
            }
            System.out.println(cnt);
        }
    }
}