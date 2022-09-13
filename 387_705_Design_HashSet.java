/* 
 * 705. Design HashSet

 Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

Example 1:
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
 

Constraints:
0 <= key <= 10^6
At most 10^4 calls will be made to add, remove, and contains.

*/



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

 
// data intensive solution consumes a huge memory but time efficient O(1)

class MyHashSet {
    boolean[] set = null;
    public MyHashSet() {
        set = new boolean[1000001];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }
}




// data extensive but time inefficient
// use array of arraylists to store keys
// design function for hashcode for each key to determine the arraylist for the key to get added 
class MyHashSet {
    private int capacity = 0;
    private List<Integer>[] set = null;
    
    private int getHash(int key) {
        return key % capacity; 
    }
    
    public MyHashSet() {
        capacity = 1500; // random value
        set = new List[capacity];
    }
    
    public void add(int key) {
        int hash = getHash(key);
        
        if (set[hash] == null)
            set[hash] = new LinkedList<Integer>();
        
        // if does not exist in the list then add
        if (set[hash].indexOf(key) == -1)
            set[hash].add(key);
    }
    
    public void remove(int key) {
        if (this.contains(key)) {
            int hash = getHash(key);
            set[hash].remove(set[hash].indexOf(key));
            // remove method accepts indexes
        }
    }
    
    public boolean contains(int key) {
        int hash = getHash(key);
        if (set[hash] == null || set[hash].indexOf(key) == -1)
            return false;
        return true;
    }
}