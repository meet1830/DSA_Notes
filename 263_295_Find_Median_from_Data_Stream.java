/* 
 * 295. Find Median from Data Stream
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-10^5 <= num <= 10^5
There will be at least one element in the data structure before calling findMedian.
At most 5 * 10^4 calls will be made to addNum and findMedian.
 

Follow up:
If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
*/


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


// use two heaps one max heap and other min heap. 
// The largest element of the max heap should be lower than the min element of the min heap.
// after every operation above property should be followed between the heaps
/*
class MedianFinder {

    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;
    
    public MedianFinder() {
        max = new PriorityQueue<Integer>((a,b) -> b - a);
        min = new PriorityQueue<Integer>();
    }
    
    // O(logn)
    public void addNum(int num) {
        if (min.size() == 0 || max.peek() >= num) {
            max.offer(num);
        }
        else {
            min.offer(num);
        }
        
        balance();
    }
    
    // O(logn)
    public double findMedian() {
        // odd case
        if (max.size() > min.size()) {
            return max.peek();
        }
        // odd case
        else if (min.size() > max.size()) {
            return min.peek();
        }
        // even case
        else {
            return (min.peek() + max.peek()) / 2.0;
        }
    }
    
    // O(logn)
    private void balance() {
        if (max.size() - min.size() > 1) {
            min.offer(max.poll());
        }
        else if (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }
        // after balance the property remains same
    }
}
*/

// follow-up 1
// maintain an array of frequencies
/*
class MedianFinder {
    
    private int[] a = null;
    private int n = 0;
    
    public MedianFinder() {
        a = new int[101];
    }
    
    // O(1)
    public void addNum(int num) {
        a[num]++;
        n++;
    }
    
    // O(100)
    public double findMedian() {
        int count = 0;
        
        // find first median
        int first = 0;
        while (count < (n + 1) / 2) {
            count += a[first++];
        }
        
        // find second median
        int second = first;
        while (count < n / 2 + 1) {
            count += a[second++];
        }
        
        // find median
        // i and j -1 because at the end of loop incremented one more time
        return (n % 2 == 1) ? --first : (--first + --second) / 2.0;
    }
}
*/


// follow-up 2
// there can be two cases for 1% of numbers that they can be negative or they can be more than 100
// but our median will always stay between 0 - 100
// hence count negative numbers from input and add to the count in last func to consider those values. do not need to do this for more than 100 since counting till middle
// but in first function if value is more than 100 then dont increment or it will give out of bound error
/*
class MedianFinder {
    
    private int[] a = null;
    private int n = 0, lessThanZero = 0;
    
    public MedianFinder() {
        a = new int[101];
    }
    
    // O(1)
    public void addNum(int num) {
        if (num < 0)
            lessThanZero++;
        
        if (num >= 0) a[num]++;
        n++;
    }
    
    // O(100)
    public double findMedian() {
        int count = lessThanZero;
        
        // find first median
        int first = 0;
        while (count < (n + 1) / 2) {
            count += a[first++];
        }
        
        // find second median
        int second = first;
        while (count < n / 2 + 1) {
            count += a[second++];
        }
        
        // find median
        // i and j -1 because at the end of loop incremented one more time
        return (n % 2 == 1) ? --first : (--first + --second) / 2.0;
    }
}
*/



/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


// use two heaps one max heap and other min heap. 
// The largest element of the max heap should be lower than the min element of the min heap.
// after every operation above property should be followed between the heaps

class MedianFinder {

    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;
    
    public MedianFinder() {
        max = new PriorityQueue<Integer>((a,b) -> b - a);
        min = new PriorityQueue<Integer>();
    }
    
    // O(logn)
    public void addNum(int num) {
        if (min.size() == 0 || max.peek() >= num) {
            max.offer(num);
        }
        else {
            min.offer(num);
        }
        
        balance();
    }
    
    // O(logn)
    public double findMedian() {
        // odd case
        if (max.size() > min.size()) {
            return max.peek();
        }
        // odd case
        else if (min.size() > max.size()) {
            return min.peek();
        }
        // even case
        else {
            return (min.peek() + max.peek()) / 2.0;
        }
    }
    
    // O(logn)
    private void balance() {
        if (max.size() - min.size() > 1) {
            min.offer(max.poll());
        }
        else if (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }
        // after balance the property remains same
    }
}


// follow-up 1
// maintain an array of frequencies

class MedianFinder {
    
    private int[] a = null;
    private int n = 0;
    
    public MedianFinder() {
        a = new int[101];
    }
    
    // O(1)
    public void addNum(int num) {
        a[num]++;
        n++;
    }
    
    // O(100)
    public double findMedian() {
        int count = 0;
        
        // find first median
        int first = 0;
        while (count < (n + 1) / 2) {
            count += a[first++];
        }
        
        // find second median
        int second = first;
        while (count < n / 2 + 1) {
            count += a[second++];
        }
        
        // find median
        // i and j -1 because at the end of loop incremented one more time
        return (n % 2 == 1) ? --first : (--first + --second) / 2.0;
    }
}



// follow-up 2
// there can be two cases for 1% of numbers that they can be negative or they can be more than 100
// but our median will always stay between 0 - 100
// hence count negative numbers from input and add to the count in last func to consider those values. do not need to do this for more than 100 since counting till middle
// but in first function if value is more than 100 then dont increment or it will give out of bound error

class MedianFinder {
    
    private int[] a = null;
    private int n = 0, lessThanZero = 0;
    
    public MedianFinder() {
        a = new int[101];
    }
    
    // O(1)
    public void addNum(int num) {
        if (num < 0)
            lessThanZero++;
        
        if (num >= 0) a[num]++;
        n++;
    }
    
    // O(100)
    public double findMedian() {
        int count = lessThanZero;
        
        // find first median
        int first = 0;
        while (count < (n + 1) / 2) {
            count += a[first++];
        }
        
        // find second median
        int second = first;
        while (count < n / 2 + 1) {
            count += a[second++];
        }
        
        // find median
        // i and j -1 because at the end of loop incremented one more time
        return (n % 2 == 1) ? --first : (--first + --second) / 2.0;
    }
}
