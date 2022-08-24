/* 
 * N meetings in one room
 There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output: 
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
Example 2:

Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output: 
1
Explanation:
Only one meetings can be held
with given start and end timings.

Your Task :
You don't need to read inputs or print anything. Complete the function maxMeetings() that takes two arrays start[] and end[] along with their size N as input parameters and returns the maximum number of meetings that can be held in the meeting room.


Expected Time Complexity : O(N*LogN)
Expected Auxilliary Space : O(N)


Constraints:
1 ≤ N ≤ 10^5
0 ≤ start[i] < end[i] ≤ 10^5
*/


class Solution 
{
    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<int[]> meetingsList = new ArrayList<>();
        
        // adding to arraylist
        for (int i = 0; i < end.length; i++)
            meetingsList.add(new int[] {start[i], end[i]});
            
        // sorting according to end time because if initially the end time is lowest then we can have maximum number of meetings
        Collections.sort(meetingsList, (a, b) -> a[1] - b[1]);
        
        // traversing arraylist and checking if start time of i is more than end time of prev meet. if yes, then count it in ans and if not then dont count since two meetings cannot be held at the same time
        int res = 1, prev = 0;
        // taking res as 1 since first meeting will always be held
        for (int i = 1; i < n; i++) {
            if (meetingsList.get(i)[0] > meetingsList.get(prev)[1]) {
                res++;
                prev = i;
            }
        }
        
        return res;
    }
}


/* CodeStudio
 * Maximum activities
You are given N activities with their start time Start[] and finish time Finish[]. You need to tell the maximum number of activities a single person can perform.

Note:
A person can only work on a single activity at a time. The start time of one activity can coincide with the end time of another.

Input Format:
The first line contains an integer 'T' denoting the number of test cases or queries to be run. 

The first line of each test case or query contains a single integers 'N' denoting the number of activities. 

The second line of each test case contains N single space-separated integers denoting the starting time of N activities respectively.

The third line of each test case contains N single space-separated integers denoting the finishing time of N activities respectively.
Output Format:
For each test case, print the maximum number of activities a single person can perform.

Constraints:
1 <= T <= 5
1 <= N <= (10^5)
0 <= Start[i] < Finish[i] <= (10^9)
Time Limit: 1 sec

Sample Input 1:
2
4
1 6 2 4 
2 7 5 8 
3
1 1 1
4 5 9
Sample Output 1:
3
1
Explanation For Sample Input 1:
For test case 1: 
A person can perform maximum of 3 activities, by performing the activities in the given order 1 - > 3 -> 2.
For test case 2:
As the starting of all the activities is the same, a person can perform a maximum of 1 activity.

Sample Input 2:
2
4
1 3 2 5
2 4 3 6
2
1 2 
6 3 
Sample Output 2:
4 
1
*/

// same code