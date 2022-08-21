/*
 * Sort Array by Increasing Frequency
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Print the sorted array.

Input:
The first line of the input contains the number 𝑛(length of array) The next n integers denotes the elements of the array.

Output:
Print the sorted array

Constraints:
1 <= nums.length <= 100
-100 <= nums[i] <= 100
Sample Input 1
6
1 1 2 2 2 3
Sample Output 1
3 1 1 2 2 2
Explanation
'3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Sample Input 2
5   
2 3 1 3 2
Sample Output 2
1 3 3 2 2
Explanation
'2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class pair {
    int cnt, val;
}

class sortVal implements Comparator<pair> {
    public int compare(pair a, pair b) {
        if (a.cnt != b.cnt)
            return a.cnt - b.cnt;
        return b.val - a.val;
    }
}

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<Integer, Integer> f = new HashMap();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            int cnt = 0;
            if (f.containsKey(x))
                cnt = f.get(x);
            cnt++;
            f.put(x, cnt);
        }
        pair a[] = new pair[f.size()];
        int i = 0;
        for (int val : f.keySet()) {
            pair x = new pair();
            x.val = val;
            x.cnt = f.get(val);
            a[i++] = x;
        }
        Arrays.sort(a, new sortVal());
        for (i = 0; i < a.length; i++) {
            int count = a[i].cnt;
            int val = a[i].val;
            while (count-- > 0) {
                System.out.print(val + " ");
            }
        }
    }
}
