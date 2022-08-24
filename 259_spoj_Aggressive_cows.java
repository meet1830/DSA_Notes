/* 
 * SPOJ - Aggressive cows
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.

Example
Input:
1
5 3
1
2
8
4
9

Output:
3
Output details:

FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a minimum distance of 3.
*/


/* codestudio - chess tournament
Chess tournament is going to be organized in Ninjaland. There will be C chess players going to attend the tournament. All the players will be staying in a hotel. The hotel has N free rooms available for the players, where one player will choose one room to live in. The ith room is at position[i] in the hotel. All rooms are in distinct positions.
Focus level of a chess player is defined as the minimum distance between his room and the room of another player. The overall focus of a tournament is defined as the minimum focus level among all players. You as an organizer obviously want the overall focus as high as possible so you assign the rooms to players such that the overall focus is as high as possible.

For Example,
let say we have 3 players and 5 rooms available and the rooms are at positions:  1 2 3 4 6
Here the optimal allocation is in rooms 1 3 6 and the overall focus level is 2.

Input Format :
The first line of input contains a single integer T, representing the number of test cases or queries to be run. 

Then the T test cases follow.

The first line of each test case contains two positive integers N and C, which represent the number of rooms in the hotel and the number of chess players.

The next line contains N space-separated positive integers representing the position of available room in the hotel.

Output Format :
For each test case, print a single integer, representing the maximum overall focus of the tournament.

Print the output of each test case in a separate line.
Note:
You do not need to print anything. It has already been taken care of. Just implement the given function.

Constraints:
1 <= T <= 10
2 <= N <= 10 ^ 4
2 <= C <= N
1 <= positions[i] <= 10 ^ 9

Time Limit: 1 sec

Sample Input 1 :
1
5 3
1 2 3 4 6
Sample Output 1 :
2

Sample Input 2 :
2
4 2
5 4 2 1
6 4
6 7 9 13 15 11
Sample Output 2 :
4
2
Explanation For Sample Output 2:
In test case 1, 
we only have to allocate rooms to 2 players so we can assign rooms that are first and last which are 1 and 5, so our answer is 5 - 1 = 4.

In test case 2, 
there is no way by which we can allocate rooms such that every player will have the 3 or more as its least distance to other players. So the answer is 2 and one possible allocation of rooms is as follows.
    Player1 = 6
    Player2 = 9
    Player3 = 11
    Player4 = 13 
 */


import java.util.*;

// brute -> calculate for all possible distances if cows can fit in or not. if they can fit then update the ans.
// O(n^2), O(1)
/*
public class Solution {
    public static boolean isPossible (int[] arr, int n, int cows, int dist) {
        int count = 1;
        int left = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - left >= dist) {
                count++;
                left = arr[i];
            }
            if (count == cows)
                return true;
        }
        return false;
    }
    public static int chessTournament(int[] stall, int n,  int cows) {
        Arrays.sort(stall);
        int ans = -1;
        int maxD = stall[n - 1] - stall[0];
        for (int i = 1; i <= maxD; i++) {
            if(isPossible(stall, n, cows, i)) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }
}
*/



// optimal -> binary search -> Since applying binary seach needs sorted array is input, sort the array. 
// apply binary search to find the max distance between cows. take left as 1 as this can be min dist and take last value - first value of array as upper limit since max dist possible would be that. 
// since need maximum dist, if cows are possible to be placed at a dist of 2 for example, then increase mid to find max ans.
// in placecows function, calculate if given number of cows can be placed within the given mid distance. greedily, first cow should be placed at first position always for max dist possible between the cows
// O(nlogn), O(1)

public class Solution {
    public static boolean placeCows(int[] arr, int n, int cows, int minDist) {
        int left = arr[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - left;
            if (diff >= minDist) {
                count++;
                left = arr[i];
            }
            if (count == cows) 
                return true;
        }
        return false;
    }
    public static int chessTournament(int[] stall, int n,  int cows) 
	{
        Arrays.sort(stall);
        int lo = 1, hi = stall[n - 1] - stall[0];
        int res = 0;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (placeCows(stall, n, cows, mid)) {
                res = mid;
                lo = mid + 1;
            }
            else 
                hi = mid - 1;
        }
        
        // return res;
        return hi;
    }

}