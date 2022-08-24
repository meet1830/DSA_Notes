/* codestudio - allocate books
Ayush is studying for ninjatest which will be held after 'N' days, And to score good marks he has to study 'M' chapters and the ith chapter requires TIME[i] seconds to study. The day in Ayush’s world has 100^100 seconds. There are some rules that are followed by Ayush while studying.
1. He reads the chapter in a sequential order, i.e. he studies i+1th chapter only after he studies ith chapter.
2. If he starts some chapter on a particular day he completes it that day itself.
3. He wants to distribute his workload over 'N' days, so he wants to minimize the maximum amount of time he studies in a day.

Your task is to find out the minimal value of the maximum amount of time for which Ayush studies in a day, in order to complete all the 'M' chapters in no more than 'N' days.

For example
if Ayush want to study 6 chapters in 3 days and the time that each chapter requires is as follows:
Chapter 1 = 30
Chapter 2 = 20
Chapter 3 = 10
Chapter 4 = 40
Chapter 5 = 5
Chapter 6 = 45

Then he will study the chapters in the following order 

| day 1 : 1 , 2 | day 2 : 3 , 4 | day 3 : 5 , 6 |
Here we can see that he study chapters in sequential order and the maximum time to study on a day is 50, which is the minimum possible in this case.

Input Format:
The first line of the input contains a single positive integer 'T', denoting the number of test cases.

The first line of each test case contains two space-separated positive integers 'N' and 'M', denoting the number of days he can study before the ninja test and the number of chapters he has to study for the ninja test respectively.

The second line of each test case contains 'M' space-separated positive integers, where the ith integer denotes the time required to study the ith chapter.

Output Format:
For each test case print a single line containing a single integer denoting the maximum time Ayush studies in a day.

The output of each test case will be printed in a separate line.
Note:
You don't have to print anything, it has already been taken care of. Just Implement the given function.

Constraints:
1 <= T <= 10
1 <= N , M <= 10 ^ 4
1 <= TIME[i] <= 10 ^ 9 
It is considered that there are infinite seconds in a day, on the planet where Ayush lives.

Time limit: 1 sec.

Sample Input 1:
1
3 5
1 2 2 3 1
Sample Output 1:
4
Explanation Of Sample Input 1:
The ayush will read the chapter as follows,
Day 1 : 1 , 2         Time required : 3
Day 2 : 3             Time required : 2
Day 3 : 4 , 5         Time required : 4
So the maximum time in a day is 4.

Sample Input 2:
1
4 7
2 2 3 3 4 4 1 
Sample Output 2:
6
Explanation Of Sample Input 2:
The ayush will read the chapter as follows,
Day 1 : 1 , 2          Time required : 4
Day 2 : 3 , 4          Time required : 6
Day 3 : 5              Time required : 4
Day 4 : 6 , 7          Time required : 5
So the maximum time in a day is 6.
*/


/* interview bit - allocate books
Given an array of integers A of size N and an integer B.

College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return that minimum possible number
Constraints

1 <= N <= 10^5
1 <= A[i] <= 10^5
For Example

Input 1:
    A = [12, 34, 67, 90]
    B = 2
Output 1:
    113
Explanation 1:
    There are 2 number of students. Books can be distributed in following fashion : 
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

        Of the 3 cases, Option 3 has the minimum pages = 113.

Input 2:
    A = [5, 17, 100, 11]
    B = 4
Output 2:
    100

*/


// binary search -> consider the sum of books as mid or call it the limit of sum of books[i] each student would have,  the lower limit to be the first book since every student has to be assigned a book, and upper limit as sum of books just in case the number of students is 1. 
// through is possible func find out the number of students within the limits and if the students are more than the given, that means that the books alloted is very less, mid or limit is very less and increase the limit. if possible then to find out minimum books alloted decrease the limit.
// O(n * logn) -> ispossible func + bsearch
// O(1)
public class Solution {
    public static boolean isPossible(int[] books, long limit, int students) {
        long count = 1, sum = 0;
        for (int i = 0; i < books.length; i++) {
            if (sum + books[i] > limit) {
                count++;
                sum = books[i];
                
                // if new sum, i.e books[i] is greater than limit
                if (sum > limit)
                    return false;
            } 
            else
                sum += books[i];
        }
        
        if (count <= students)
            return true;
        
        return false;
    }
    public static long ayushGivesNinjatest(int students, int n, int[] books) {
        if (students > n)
            return -1;
        
        long lo = books[0], hi = 0;
        for (int i = 0; i < n; i++)
            hi += books[i];
        
        long res = -1;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (isPossible(books, mid, students)) {
                res = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        
        // return res;
        return lo;
    }
}