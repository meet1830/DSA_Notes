/*
Greedy Florist
A group of friends want to buy a bouquet of flowers. The florist wants to maximize his number of new customers and the money he makes. To do this, he decides he will multiply the price of each flower by the number of that customers previously purchased flowers plus 1 . The first flower will be original price, (0 + 1) x original price , the next will be (1 + 1) x original price and so on.

Given the size of the group of friends, the number of flowers they want to purchase and the original prices of the flowers, determine the minimum cost to purchase all of the flowers. The number of flowers they want equals the length of the c array.

Example
c = [1,2,3,4]
k = 3
The length of c = 4, so they want to buy 4 flowers total. Each will buy one of the flowers priced [2,3,4] at the original price. Having each purchased x=1 flower, the first flower in the list, c[0], will now cost (current purchase + previous purchases) x c[0] = (1+1) x 1 = 2 . The total cost is 2+3+4+2 = 11.

Input Format
The first line contains two space-separated n integers and k, the number of flowers and the number of friends.

The second line contains n space-separated positive integers c[i], the original price of each flower.

Output Format
A single number, the minimum cost to purchase all flowers.

Constraints
1 <= n, k <= 100
1 <= c[i] <= 10⁶
answer < 2³¹
0 <= i < n
Sample Input 0

3 3
2 5 6
Sample Output 0

13
Explanation 0

There are n = 3 flowers with costs c = [2,5,6] and k = 3 people in the group. If each person buys one flower, the total cost of prices paid is 2 + 5 + 6 = 13 dollars. Thus, we print 13 as our answer.

Sample Input 1

3 2
2 5 6
Sample Output 1

15
Explanation 1

There are n = 3 flowers with costs c = [2,5,6] and k = 2 people in the group. We can minimize the total purchase cost like so:

The first person purchases 2 flowers in order of decreasing price; this means they buy the more expensive flower ( c1 = 5 ) first at price p1 = (0+1) x 5 = 5 dollars and the less expensive flower ( c0 = 2 ) second at price p0 = (1+1) x 2 = 4 dollars.

The second person buys the most expensive flower at price p2 = (0+1) x 6 = 6 dollars.

We then print the sum of these purchases, which is 5+4+6 = 15, as our answer.

Sample Input 2

5 3
1 3 5 7 9
Sample Output 2

29
Explanation 2

The friends buy flowers for 9, 7 and 3, 5 and 1 for a cost of 9 + 7 + 3 x (1+1) + 5 + 1 x (1+1) = 29.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Arrays.sort(a);
        int sum = 0, level = 1;
        for(int i = n - 1; i >= 0; i-= k) {
            for(int j = 0; j < k && i - j >= 0; j++) {                
              sum += level * a[i - j];
            }
            level++;
        }
        System.out.println(sum);
    }
}

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        byte N = Byte.parseByte(temp[0]);
        byte K = Byte.parseByte(temp[1]);
        temp = br.readLine().split(" ");
        int[] ar = new int[N];
        for (byte i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(ar);
        byte x = 1;
        int total = 0;
        for (byte i = N; i > 0; x++) {
            for (byte k = 0; i > 0 && k < K; k++) {
                total += x * ar[--i];
                System.out.print(ar[i] + " ");
            }
            System.out.println();
        }
        // System.out.println(total);
    }
}