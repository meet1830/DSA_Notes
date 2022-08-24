/*
Median in a row-wise sorted Matrix
Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Expected Time Complexity: O(32 * R * logC)
Expected Auxiliary Space: O(1)

Input
The first line contains two integers R and C.
The next r lines contains c spaced integers , elements of matrix.
Constraints
1<= R,C <=150
1<= matrix[i][j] <=2000
Output
Print the median of the matrix.

Example
Sample Input

3 3
1 3 5 
2 6 9 
3 6 9
Sample Output

5
Explanation

Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median.
Sample Input

3 1
1
2
3
Sample Output

2
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  public static boolean possible(int a[][], int x, int median) {
    int n = a.length;
    int m = a[0].length;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      int l = 0, r = m - 1, smaller = 0;
      while (l <= r) {
        int mid = (l + r) / 2;
        if (a[i][mid] < median) {
          smaller = mid + 1;
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      cnt += smaller;
      // System.out.print(smaller + " ");
    }
    // System.out.println();
    // System.out.println(cnt);
    // System.out.println(cnt <= x);
    return (cnt <= x);
  }

  public static void main(String[] args) throws java.lang.Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int a[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = input.nextInt();
      }
    }
    int x = n * m / 2;
    int l = 1, r = 2000, ans = 0;
    while (l <= r) {
      int median = l + (r - l) / 2;
      // System.out.println(median);
      if (possible(a, x, median)) {
        ans = median;
        l = median + 1;
      } else {
        r = median - 1;
      }
    }
    System.out.println(ans);
  }
}



/* Codestudio Matrix median
 * You have been given a matrix of ‘N’ rows and ‘M’ columns filled up with integers where every row is sorted in non-decreasing order. Your task is to find the overall median of the matrix i.e if all elements of the matrix are written in a single line, then you need to return the median of that linear array.
The median of a finite list of numbers is the "middle" number when those numbers are listed in order from smallest to greatest. If there is an odd number of observations, the middle one is picked. For example, consider the list of numbers [1, 3, 3, 6, 7, 8, 9]. This list contains seven numbers. The median is the fourth of them, which is 6.
Input Format:
The first line contains a single integer ‘T’ representing the number of test cases. 

The first line of each test case will contain two integers ‘N’ and ‘M’ denoting the number of rows and columns, respectively.

Next ‘N’ lines contain ‘M’ space-separated integers each denoting the elements in the matrix.
Output Format:
For each test case, print an integer which is the overall median of the given matrix.

Output for every test case will be printed in a separate line.
Note:
You don’t need to print anything; It has already been taken care of. Just implement the given function.
Constraints:
1 <= 'T' <= 50
1 <= 'N' , 'M' <= 100
1 <= 'MATRIX'['I']['J'] <= 10 ^ 5
'N' * 'M' is always an odd number.

Where 'MATRIX'['I']['J']  denotes the value at ('I', 'J')th cell in the matrix.

Time limit: 1 sec
Sample Input 1:
2
1 3
1 2 3
3 3
2 6 9
1 5 11
3 7 8
Sample Output 1:
2
6
Explanation Of Sample Input 1:
In the first test case, the overall median of the matrix is 2.

In the second test case, the overall median of the matrix is 6.
Sample Input 2:
2
3 3
2 6 8
1 4 7
6 8 9
3 5
1 2 6 6 10
2 4 4 5 7
2 5 5 6 6
Sample Output 2:
2
5
Explanation For Sample Input 2:
In the first test case, the overall median of the matrix is 2.

In the second test case, the overall median of the matrix is 5.
*/


import java.util.*;

// brute -> traverse the matrix and put all the elements in an array or arraylist. then sort the array and find the median. return the mid element if length is odd or calculate the median from middle two elements.
// O(m * n + (m * n)log(m * n)), O(m * n)

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < matrix.size(); i++)
            for (int j = 0; j < matrix.get(0).size(); j++) 
                list.add(matrix.get(i).get(j));
        
        Collections.sort(list);
        
        if (matrix.size() % 2 != 0)
            return list.get(list.size() / 2);
        else {
            int first = list.get(list.size() / 2);
            int second = list.get(list.size() / 2 - 1);
            return (first - second) / 2;
        }
	}
}



public class Solution
{
    public static int countLessThan(int val, ArrayList<Integer> list) {
        int lo = 0, hi = list.size() - 1;
        int len = 0;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= val) {
                lo = mid + 1;
                len = lo;
            }
            else 
                hi = mid - 1;
        }
        
        return len;
    }
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int m = matrix.size(), n = matrix.get(0).size();
        int lo = 1, hi = Integer.MAX_VALUE;
        int ans = 0;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            int count = 0;
            for (int i = 0; i < m; i++) 
                count += countLessThan(mid, matrix.get(i));
            
            if (count == m * n / 2)
                ans = mid;
            if (count <= m * n / 2) {
                lo = mid + 1;
                ans = lo;
            }
            else 
                hi = mid - 1;
        }
        
        return ans;
    }
}



// optimal -> observe that m * n is always odd. hence the case in even numbers where we have to average middle two numbers to find median is eliminated. 
// now observe that the amount of numbers before the median and after the median in an array is same. 
// that means if the amount of numbers before a certain element in an array is equal to size of array / 2 then that element is median. 
// now if we have an array then we will find the amount of numbers that are less than the considered number. if it is equal to size/2 then that is median. 
// similarly here we find through binary search for each row the amount of numbers lesser than the considered value. limits from 1 to int max or as per constraints. 
// if amount is less then lo increases and if amount is more than hi decreases. in above code not below, if no repeated values then also will give 1 less than the median value. 
// hence in next if added +1. if not written ans = mid + 1 in next if then will not update the ans simply because for repeated values the count of numbers may not exactly equal to mn/2.
// O((int_max)log(int_max) * nlogn), O(1)

public class Solution
{
    public static int countLessThan(int val, ArrayList<Integer> list) {
        int lo = 0, hi = list.size() - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= val) {
                lo = mid + 1;
            }
            else 
                hi = mid - 1;
        }

        return lo;
    }
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int m = matrix.size(), n = matrix.get(0).size();
        int lo = 1, hi = Integer.MAX_VALUE;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            int count = 0;
            for (int i = 0; i < m; i++) 
                count += countLessThan(mid, matrix.get(i));
            
            if (count <= m * n / 2) {
                lo = mid + 1;
            }
            else 
                hi = mid - 1;
        }
        
        return lo;
    }
}