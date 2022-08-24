/* 
 * Job Sequencing Problem
Given a set of N jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.


Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).
Example 2:

Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).

Your Task :
You don't need to read input or print anything. Your task is to complete the function JobScheduling() which takes an integer N and an array of Jobs(Job id, Deadline, Profit) as input and returns the count of jobs and maximum profit.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(N)


Constraints:
1 <= N <= 105
1 <= Deadline <= 100
1 <= Profit <= 500
*/



/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

// sorting jobs array in descending order of profit
// to find length of array finding largest deadline
// new array to find out sequence of order of work to be undertaked for maximum profit (full sequence not needed, but if interviewer asks what would be the sequence then can return array contents which are not 0 in order)
// here approach will be conduct the job first whose deadline is nearest and in the order of max profit (if deadline is same)
// traversing through arr and scheduling work in sq array at the same index as deadline

class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        int maxLen = 0;
        for (int i = 0; i < n; i++) 
            maxLen = Math.max(maxLen, arr[i].deadline);
            
        int[] seq = new int[maxLen + 1];
        int countJobs = 0, maxProfit = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (seq[j] == 0) {
                    // seq[j] = i + 1;
                    seq[j] = arr[i].id;
                    
                    countJobs++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        return new int[] {countJobs, maxProfit};
    }
}