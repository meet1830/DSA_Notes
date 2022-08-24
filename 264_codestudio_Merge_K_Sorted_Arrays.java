/* 
 * Merge K Sorted Arrays
You have been given ‘K’ different arrays/lists, which are sorted individually (in ascending order). You need to merge all the given arrays/list such that the output array/list should be sorted in ascending order.

Input Format :
The first line of input contains an integer T, the number of test cases.

The first line of each test case contains an integer that denotes the value of K.

The next 2*K lines of each test case follow: 
The first line contains an integer ‘N’ denoting the size of the array. 

The second line contains N space-separated integers. 

Output Format :
The first and only line of output contains space-separated elements of the merged and sorted array, as described in the task.
Note :
You don’t have to print anything; it has already been taken care of. Just implement the function. 

Constraints :
1 <= T <= 5
1 <= K <= 5
1 <= N <= 20
-10^5 <= DATA <= 10^5
Time Limit: 1 sec.

Sample Input 1:
1
2
3 
3 5 9 
4 
1 2 3 8   
Sample Output 1:
1 2 3 3 5 8 9 
Explanation Of Sample Input 1:
After merging the two given arrays/lists [3, 5, 9] and [ 1, 2, 3, 8], the output sorted array will be [1, 2, 3, 3, 5, 8, 9].

Sample Input 2:
1
4
3
1 5 9
2
45 90
5
2 6 78 100 234
1
0
Sample Output 2:
0 1 2 5 6 9 45 78 90 100 234
Explanation Of Sample Input 2 :
After merging the given arrays/lists [1, 5, 9], [45, 90], [2, 6, 78, 100, 234] and [0], the output sorted array will be [0, 1, 2, 5, 6, 9, 45, 78, 90, 100, 234].
*/



import java.util.*;

// brute create an ans arraylist traverse matrix and put all elements inside arraylist and return it after sorting it.
// O(n*k + (n*k)log(n*k))

// optimal -> use minheap, put k elements inside it, pull out the min and place in ans array, put the next element from the list of which element was removed. if end of that list dont put anything
// O(nlogn), O(n) assuming k <= n
public class Solution 
{
    public static class Pair implements Comparable<Pair> {
        int listI, dataI, val;
        public Pair (int li, int di, int val) {
            this.listI = li;
            this.dataI = di;
            this.val = val;
        }
        public int compareTo (Pair o) {
            return this.val - o.val;
        }
    }
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		ArrayList<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        // PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.val - b.val);
        
        // adding first elements of all lists in pq
        for (int i = 0; i < kArrays.size(); i++) {
            pq.add(new Pair (i, 0, kArrays.get(i).get(0)));
        }
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans.add(p.val);
            
            p.dataI++;
            
            if (p.dataI < kArrays.get(p.listI).size()) {
                p.val = kArrays.get(p.listI).get(p.dataI);
                pq.add(p);
            }
        }
        
        return ans;
	}
}
