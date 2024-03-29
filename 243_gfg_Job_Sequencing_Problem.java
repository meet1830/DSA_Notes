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


// O(nlogn + n * m), O(m) -> m = (size of jobSeq array)
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // sorting based on max profit
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        // finding max deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        
        // creating an array of size of max deadline + 1 as deadline cannot be 0 so no job sequencing at 0th index
        // performing the task on the last day of the deadline hence prev days are left to complete other tasks
        int[] jobSeq = new int[maxDeadline + 1];
        
        // traversing to the sorted array and performing the job of max profit at the last day of its deadline
        // if that day is occupied, then perform the job on any of its prev days which are empty (in jobseq array)
        int maxProfit = 0, countJobs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (jobSeq[j] == 0) {
                    jobSeq[j] = arr[i].id;
                    maxProfit += arr[i].profit;
                    countJobs++;
                    break;
                }
            } 
        }
        
        return new int[] {countJobs, maxProfit};
    }
}
