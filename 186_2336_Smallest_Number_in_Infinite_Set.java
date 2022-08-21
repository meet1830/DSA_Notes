/* 
 * 2336. Smallest Number in Infinite Set
Medium

203

17

Add to List

Share
You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 

Example 1:

Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]

Explanation
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                   // is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
 

Constraints:

1 <= num <= 1000
At most 1000 calls will be made in total to popSmallest and addBack.
*/



/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */


// use two data structures set for preventing duplicates and priority queue for getting smallest element
class SmallestInfiniteSet {
    HashSet<Integer> set;
    PriorityQueue<Integer> pq;
    
    public SmallestInfiniteSet() {
        set = new HashSet<>(1000);
        pq = new PriorityQueue<>(1000);
        
        // adding elements to both set and pq
        for (int i = 1; i <= 1000; i++) {
            set.add(i);
            pq.offer(i);
        }
    }
    
    public int popSmallest() {
        // save the element popped from pq and remove that element from set and return that element
        int el = pq.poll();
        set.remove(el);
        return el;
    }
    
    public void addBack(int num) {
        // adding in both if set does not contain num
        if (!set.contains(num)) {
            set.add(num);
            pq.add(num);
        }
    }
}



// prority queue also has .contains method hence can get rid of set altogether (the change in the code is remove all set lines and in last method use pq.contains) but takes tc of O(n) where as set .contains takes O(1).


// the java data structure which has properties of both the set and priority queue is tree set.
class SmallestInfiniteSet {
    TreeSet<Integer> tset;
    
    // O(logn) -> add method
    public SmallestInfiniteSet() {
        tset = new TreeSet<>();
        
        for (int i = 1; i <= 1000; i++) 
            tset.add(i);
    }
    
    // O(logn)
    public int popSmallest() {
        // pollfirst removes the first or the lowest element from tset
        // polllast removes the last or the highest element from tset
        return tset.pollFirst();
    }
    
    // O(logn)
    public void addBack(int num) {
        tset.add(num);
    }
}