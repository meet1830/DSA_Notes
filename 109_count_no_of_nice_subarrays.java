/*
Count Number of Nice Subarrays
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

print the number of nice sub-arrays.

Input:
The first line contains a two integers n(size of array n) The next line contains n integers

Output:
print the number of nice sub-arrays.

Constraints
1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
Sample Input 1
5 3 1 1 2 1 1

Sample Output 1
2
Explanation
The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Sample Input 2
3 1
2 4 6
Sample Output 2
0
*/

// Java program to count the
// number of subarrays with
// m odd numbers
import java.util.*;

public class Main {

    // function that returns the count of
    // subarrays with m odd numbers
    public static int countSubarrays(int a[], int n, int m)
    {
        int count = 0;
        int prefix[] = new int[n + 1];
        int odd = 0;

        // Traverse in the array
        for (int i = 0; i < n; i++) 
        {
            prefix[odd]++;

            // If array element is odd
            if ((a[i] & 1) == 1)
                odd++;

            // When number of odd
            // elements >= M
            if (odd >= m)
                count += prefix[odd - m];
        }

        return count;
    }

    // Driver code
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
          arr[i] = input.nextInt();
        }
        // Function call
        System.out.println(countSubarrays(arr, arr.length, k));
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                arr[i] = 0;
            else
                arr[i] = 1;
        }

        // number of subarrays sum equal to k
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k)
                count++;

            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(count);
    }
}