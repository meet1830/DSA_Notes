/* 
 * Help a Thief

You have to help a thief to steal as many as GoldCoins as possible from a GoldMine. There he saw N Gold Boxes an each Gold Boxes consists of Ai Plates each plates consists of Bi Gold Coins. Your task is to print the maximum gold coins theif can steal if he can take a maximum of T plates.

Example 1:
Input:
T = 3, N = 3 
A[] = {1, 2, 3}
B[] = {3, 2, 1}
Output:
7
Explanation:
The thief will take 1 plate of coins
from the first box and 2 plate of coins
from the second plate. 3 + 2*2 = 7.

Example 2:
Input:
T = 0, N = 3 
A[] = {1, 3, 2}
B[] = {2, 3, 1}
Output:
0
Explanation:
The thief can't take any plates.
So he can't steal any coins.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes 2 Integers T, and N and two arrays A and B of size N as input and returns the maximum number of gold coins the thief can steal if he can take a maximum of T plates.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)


Constraints:
0 <= T,N <= 10^4
1 <= A[i] <= 10^4
1 <= B[i] <= 10^4
*/


class Solution {
    static int maxCoins(int[] A, int[] B, int T, int N) {
        int count = 0;
        // storing in priority queue and sorting
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for (int i = 0; i < N; i++) {
            pq.add(new int[] {A[i], B[i]}); 
        }
        
        // T can be more than N hence run till pq is not empty
        while (T > 0 && !pq.isEmpty()) {
            // accessing pq and removing the plates after counting
            int coins = pq.peek()[1];
            int plates = pq.poll()[0];
            
            // taking min because if 2 plates of same number of coins and T left is 1 only then consider 1 plate
            count += coins * Math.min(plates, T);
            
            T -= Math.min(plates, T);
        }
        
        return count;
    }
}



// solve without priority queue
// will not pass all test cases due to tc constraint
class Solution {
    static int maxCoins(int[] A, int[] B, int T, int N) {
        int[][] list = new int[N][2];
        for (int i = 0; i < N; i++) {
            list[i] = new int[] {A[i], B[i]};
        }
        
        Arrays.sort(list, (a,b) -> b[1] - a[1]);
        
        int count = 0, i = 0;
        
        while (i < N) {
            if(T < 0) break; // for T more than N
            
            int coins = list[i][1];
            int plates = list[i++][0];
            
            count += coins * Math.min(plates, T);
            
            T -= Math.min(plates, T);
        }
        
        return count;
    }
}
