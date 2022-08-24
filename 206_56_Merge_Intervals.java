/* 
 * 56. Merge Intervals
Medium

15584

560

Add to List

Share
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
*/



/*
    first get info if the intervals are sorted or not
    if no then in brute force approach first needs to sort the intervals
    (sort using overloaded arrays.sort using comparator or running for loop and using arrays.sort row wise)
    in brute if 1,3 2,6 2,7 then for 1,3 get all the intervals that are overlapping and then merge them all. a linear scan for every interval to get this is done. next for the interval 2,6 check if it lies in the previous interval, if yes then no need to do anything.
    tc - nlogn(sorting) + n^2(brute)
    
    optimal -> again if not sorted then need to sort.
    get first interval and store in pair. then start iterating through the intervals, if overlaps then update the pair. if the next interval does not overlap then store the pair in a data structure and update the pair to that interval
    tc - nlogn(sorting) + n(iterating through intervals) sc - n(for storing)
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        
        // base
        if(intervals == null || intervals.length == 0) 
            return res.toArray(new int[0][]);
        
        // sorting using overloaded arrays.sort method using lambda
        // can also use comparator
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int start = intervals[0][0], end = intervals[0][1];
        
        for(int[] i : intervals) {
            // checking if lies in the interval or not
            // 1,3 2,6 if overlapping then 2 has to be lower than or equal to 3
            if(i[0] <= end) {
                // merging
                end = Math.max(end, i[1]);
            }
            // if not merging
            else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        
        res.add(new int[]{start, end});
        
        return res.toArray(new int[0][]);
    }
}