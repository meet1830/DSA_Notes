/* 
 * 460. LFU Cache
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
 

Constraints:
0 <= capacity <= 104
0 <= key <= 105
0 <= value <= 109
At most 2 * 105 calls will be made to get and put.
*/


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// optimal using two hashmaps and doubly linked list
// implementing lru cache at every node frequency

// capacity -> total capacity of lfu cache
// currSize -> currSize of lfu cache
// minFreq -> frequency of last linked list (min freq of entire lfu cache)
// cache -> map used to store all nodes with their addresses irrespective of there frequency
// freqMap -> storing a doubly linked list for every freq

class LFUCache {
    private final int capacity;
    private int currSize;
    private int minFreq;
    private Map<Integer, Node> cache;
    private Map<Integer, DoubleLinkedList> freqMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    // check if in the cache map and if there then update node by, remove it from the current linked list and include it in the double linked list of higher frequency
    public int get(int key) {
        Node currNode = cache.get(key);
        
        if (currNode == null)
            return -1;
        updateNode(currNode);
        
        return currNode.val;
    }
    
     
    public void put(int key, int value) {
        // corner case
        if (capacity == 0)
            return;
        
        // if cache contains the node then just update the node with new freq
        if (cache.containsKey(key)) {
            Node currNode = cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        }
        
        else {
            currSize++;
            if (currSize > capacity) {
                // delete the lru node at minFreq
                // for that get min freq list
                DoubleLinkedList minFreqList = freqMap.get(minFreq);
                
                // removing the lru node from cache
                cache.remove(minFreqList.tail.prev.key);
                
                // removing that node from the minFreqList
                minFreqList.removeNode(minFreqList.tail.prev);
                
                currSize--;
            }
            // resetting minFreq to 1 since adding fresh node
            minFreq = 1;
            
            Node newNode = new Node (key, value);
            
            // get the list with freq 1, and add the newNode just after the head, if does not exist, then create one
            DoubleLinkedList currList = freqMap.getOrDefault(1, new DoubleLinkedList());
            currList.addNode(newNode);
            freqMap.put(1, currList);
            cache.put(key, newNode);
        }
    }
    
    
    
    private void updateNode (Node currNode) {
        int currFreq = currNode.freq;
        
        DoubleLinkedList currList = freqMap.get(currFreq);
        
        currList.removeNode(currNode);
        
        // if currList is the list which has the minFreq and is now empty then we need to remove the entire list and increase the minFreq
        if (currFreq == minFreq && currList.listSize == 0) {
            minFreq++;
        }
        
        // by updateNode the currNode is being called somewhere either in get or put methods hence update its frequency
        currNode.freq++;
        
        // now that its frequency has updated, we need to place it the list of this updated frequency.
        // if the list exists then get the list at that frequency, otherwise create new doublelinkedlist
        DoubleLinkedList newList = freqMap.getOrDefault(currNode.freq, new DoubleLinkedList());
        
        newList.addNode(currNode);
        
        // place the list at the new frequency in freqMap
        freqMap.put(currNode.freq, newList);
    }
    
    
    
    private class Node {
        int key, val, freq;
        Node next, prev;
        
        Node (int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    
    private class DoubleLinkedList {
        int listSize;
        Node head, tail;
        
        DoubleLinkedList () {
            this.listSize = 0;
            this.head = new Node (0, 0);
            this.tail = new Node (0, 0);
            head.next = tail;
            tail.prev = head;
        }
        
        // insert new node at front as most recently used node
        public void addNode (Node currNode) {
            Node nextNode = head.next;
            
            currNode.next = nextNode;
            currNode.prev = head;
            head.next = currNode;
            nextNode.prev = currNode;
            
            listSize++;
        }
        
        public void removeNode (Node currNode) {
            Node prevNode = currNode.prev;
            Node nextNode = currNode.next;
            
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            
            listSize--;
        }
    }
}