/*
Catch Me If You Can
There are one policeman, k thieves, and one hiding spot on a coordinate line. The policeman is located at the point 0, the hiding spot is located at the point n. All the thieves are located between the policeman and the hiding spot: the i-th thief is located at the point xi (0 < xi < n). At each point, many thieves can be located.

In one second, the following happens. First, exactly one thief moves to the right by 1. If the thief reaches the hiding spot, it hides (i.e. the policeman will not be able to catch him). Then (after that the thief has finished its move) the policeman moves to the right by 1. If at the new policemans position, some thieves are located, the policeman catches them (they will not be able to move after that). The actions are performed until any thief has not been hidden or isnt caught.

In other words, the first move is made by a thief. If the thief has reached the hiding, it is saved. Then the policeman makes a move. The policeman catches the thief located at the point the policeman has reached (if the policeman has reached the hole, it catches nobody).

Each second, you can select a thief that will make a move. What is the maximum number of thieves that can reach the hiding without getting caught?

Input
The first line contains two integers n and k.
The second line contains k integers x1, x2, . . ., xk (1 ≤ xi < n) — the initial coordinates of the thieves.
Constraints
2 ≤ n ≤ 10⁹
1 ≤ k ≤ 4⋅10⁵
1 ≤ xi < n
Output
Print an integer t (t ≥ 0) — the maximum number of thieves that can reach the hiding without getting caught.

Example
Sample Input

10 6
8 7 5 4 9 4
Sample Output

3
Sample Input

2 8
1 1 1 1 1 1 1 1
Sample Output

1
Sample Input

12 11
1 2 3 4 5 6 7 8 9 10 11
Sample Output

4
*/

// catch me if you can
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hidePos = input.nextInt(), size = input.nextInt();
        int[] thievesPos = new int[size];
        for (int i = 0; i < size; i++) {
            thievesPos[i] = input.nextInt();
        }
        Arrays.sort(thievesPos);
        int ans = 0, pos = 0;
        for (int i = thievesPos.length - 1; i >= 0; i--) {
            if (thievesPos[i] <= pos) {
                break;
            }
            ans++;
            int travel = hidePos - thievesPos[i];
            pos += travel;
        }
        System.out.println(ans);
    }
}