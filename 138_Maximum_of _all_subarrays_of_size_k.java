/*
Maximum of all subarrays of size k
Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example 1:
Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output: 
3 3 4 5 5 5 6 
Explanation: 
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6

Example 2:
Input:
N = 10, K = 4
arr[] = 8 5 10 7 9 4 15 12 90 13
Output: 
10 10 10 15 15 90 90
Explanation: 
1st contiguous subarray = {8 5 10 7}, Max = 10
2nd contiguous subarray = {5 10 7 9}, Max = 10
3rd contiguous subarray = {10 7 9 4}, Max = 10
4th contiguous subarray = {7 9 4 15}, Max = 15
5th contiguous subarray = {9 4 15 12}, 
Max = 15
6th contiguous subarray = {4 15 12 90},
Max = 90
7th contiguous subarray = {15 12 90 13}, 
Max = 90
Your Task:  
You dont need to read input or print anything. Complete the function max_of_subarrays() which takes the array, N and K as input parameters and returns a list of integers denoting the maximum of every contiguous subarray of size K.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(k)

Constraints:
1 ≤ N ≤ 10^7
1 ≤ K ≤ N
0 ≤ arr[i] ≤ 10^7
*/

class Solution {
    // Function to find maximum of each subarray of size k.
    static ArrayList<Integer> max_of_subarrays(int a[], int n, int k) {
        Deque<Integer> d = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (d.size() > 0 && a[d.getLast()] <= a[i])
                d.removeLast();
            d.addLast(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = k - 1; i < n; i++) {
            while (d.size() > 0 && a[d.getLast()] <= a[i])
                d.removeLast();
            d.addLast(i);

            while (d.getFirst() < i - k + 1)
                d.removeFirst();
            ans.add(a[d.getFirst()]);
        }

        return ans;
    }
}

// Editorial
class Solution {
    // Function to find maximum of each subarray of size k.
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>(0);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int i = 0;

        // iterating over first k elements or first window of array.
        for (i = 0; i < k; i++) {
            // for every element, the previously smaller elements
            // are useless so removing them from deque.
            while (dq.isEmpty() == false && arr[i] >= arr[dq.peekLast()])
                dq.pollLast();

            // adding new element at back of deque.
            dq.add(i);
        }

        // iterating over the rest of the elements.
        for (; i < n; i++) {
            // the element at the front of the deque is the largest
            // element of previous window, so adding it to the list.
            res.add(arr[dq.peek()]);

            // removing the elements which are out of this window.
            while (dq.isEmpty() == false && (dq.peekFirst() <= i - k))
                dq.pollFirst();

            // removing all elements smaller than the element being
            // added currently (removing useless elements).
            while (dq.isEmpty() == false && (arr[i] >= arr[dq.peekLast()]))
                dq.pollLast();

            // adding new element at back of deque.
            dq.add(i);
        }

        // the element at the front of the deque is the largest
        // element of last window, so adding it to the list.
        res.add(arr[dq.peek()]);
        dq.pollFirst();

        // returning the list.
        return res;

    }
}