/* 
 * Magnet Array Problem

Given N Magnets which are placed linearly, with each magnet to be considered as of point object. Each magnet suffers force from its left sided magnets such that they repel it to the right and vice versa. All forces are repulsive. The force being equal to the inverse of the distance (1/d , d being the distance). Now given the positions of the magnets, the task to find all the points along the linear line where net force is ZERO. 

More Formally, Magnets are placed on X axis, the coordinates of which are given, you are asked to find out the X-co-ordinates of all the equilibrium points (i.e. the point where net force is zero). You notice the point each magnet repels each other, it means the polarity of the magnet is such that exerts +ve force in its right side and -ve force in left side, (here +ve is considered in +ve direction of x-axis). And that forces are inversely proportional to the distance, thus there lies an equilibrium point between every two magnetic points. Thus there will be total of N-1 equllibrium points. You have to find those N-1 points.

Note: Array M[] is sorted and distance have to be calculated with precision of 2 decimal places.


Example 1:
Input:
N = 2
M[] = {1, 2}
Output:
1.50
Explanation:
The mid point of two points will have 
net force zero, thus answer = 1.50

Example 2:
Input:
N = 4
M[] = {0, 10, 20, 30}
Output:
3.82, 15.00, 26.18

Your Task:  
You don't need to read input or print anything. Your task is to complete the function nullPoints() which takes the array M[], its size N as inputs and an answer array getAnswer[] to store the points having net force zero till precised two decimal places.

Expected Time Complexity: O(N2 * Log(N))
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ N ≤ 10^5
0 ≤  M[1] < ....M[i] < M[i+1] < ....M[N] ≤ 10^6
*/



// example two -> neutral point will exist for every two magnets but the point will have effect of repulsive forces of all the magnets.
// hence take limits as first and second magnet. then first take mid as midpoint of distance of two magnets. formula would be 1 upon the distance from that midpoint to that magnet.
// also calculate the forces for all magnets with respect to that chosen point
// the magnets on the left side will have positive forces whereas those on right side will have neg
// here for mid = 5 for limits magnets 0 and 1 we have 
// for magnet 0 -> 1 / 5 - 0
// for magnet 1 -> 1 / 5 - 10
// for magnet 2 -> 1 / 5 - 20
// for magnet 3 -> 1 / 5 - 30
// summing up all, will find that (ans is neg) npoint is to away from the left magnet weakening its force. hence it is needed to be searched in the left direction for npoint.

class Solution {
    public void nullPoints(int n, double magnets[], double getAnswer[]) {
        for (int i = 0; i < n - 1; i++) {
            getAnswer[i] = bSearch(magnets, n, magnets[i], magnets[i + 1]);
        }
    }
    
    public double bSearch(double[] magnets, int n, double l, double r) {
        double nPoint = 0;
        while (l < r) {
            double mid = l + (r - l) / 2;
            
            double force = 0;
            for (int i = 0; i < n; i++) {
                force += 1 / (mid - magnets[i]);
            }
            
            // if +- npoint nearer to this value then return as it can never be exactly 0
            if (Math.abs(force) < 0.000001) {
                nPoint = mid;
                break;
            }
            // ans precised hence cannot do 1 or -1 in limits
            else if (force < 0)
                r = mid;
            else 
                l = mid;
        }
        return nPoint;
    }
}

