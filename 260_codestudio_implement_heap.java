/* 
 * Min Heap
Implement the Min Heap data structure.

You will be given 2 types of queries:-
0 X
Insert X in the heap.

1
Print the minimum element from the heap and remove it.

Input Format :
The first line will contain the integer 'T', denoting the number of test cases.

For each test case, the first line will contain a single integer 'N', the number of queries.

Then, each of the next ‘N’ lines contains two types of query either 0 ‘X’ or 1.

Output Format :
For each test case, output the answer for query of type 1.

Note :
You don't need to print anything. It has already been taken care of. Just implement the given function.

Constraints :
1 <= T <= 5
1 <= N <= 10^5
1 <= X <= 50
Time Limit: 1 sec

Sample Input 1 :
2
3
0 2
0 1
1
2
0 1
1
Sample Output 1 :
1
1
Explanation Of Sample Input 1 :
For the first test case:-
Insert 2 in the heap and currently, 2 is the smallest element in the heap.
Insert 1 in the heap and now the smallest element is 1.
Return and remove the smallest element which is 1.

For the second test case:-
Insert 1 in the heap and currently, 1 is the smallest element in the heap.
Return the smallest element from the heap which is 1 and remove it.

Sample Input 2 :
2
5
0 5
1
0 43
0 15
0 5
2
0 4
1
Sample Output 2 :
5
4
*/



import java.util.*;

// heap is a complete binary tree. means all nodes should have two children except for the second last row which can have 1 or 0 children but it needs to be on left side of the parent
// first property -> in max heap, children will always be of lesser value than the parent node. vice versa for mean heap. second property -> a complete binary tree has height logn for n nodes
// convert cbt to array -> first index empty -> start from first index and fill the array -> root node - 1, left child - 2, right child - 3, left left child - 4 left right child - 5, right left child - 6, right right child - 7
// if any child is not present them 0 at that node
// hence node is denoted with index i
// i's parent node = floor of i / 2
// i's left child = 2 * i
// i's right child = 2 * i + 1
public class Solution {
    // minHeap function which take size of Queries and Queries as Input.
    // Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        Heap pq = new Heap(n + 1);
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int[] query : q) {
            if (query[0] == 0)
                pq.insert(query[1]);
            else 
                res.add(pq.delete());
        }
        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) 
            ans[i] = res.get(i);
        
        return ans;
    }
}
// consider 1 based indexing

// insert at last and then heapify the tree (arr) by swapping the values

// usually index of the element to be deleted is given
    // but here since we need to and delete the min element of the heap, the element to be deleted is always the root or the first element
    // hence swap it with the last value and reduce size

class Heap {
    int[] arr;
    int currSize;
    
    Heap(int n) {
        currSize = 0;
        arr = new int[n];
        arr[0] = -1; // consider 1 based indexing
    }
    
    void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // insert at last and then heapify the tree (arr) by swapping the values
    // works for both max and min heap
    void insert(int val) {
        currSize++;
        int i = currSize;
        arr[i] = val;
        
        while (i > 1) {
            int parent = i / 2;
            if (arr[parent] > arr[i]) {
                swap(parent, i);
                i = parent;
            }
            else 
                return;
        }
    }
    
    // usually index of the element to be deleted is given
    // but here since we need to and delete the min element of the heap, the element to be deleted is always the root or the first element
    // hence swap it with the last value and reduce size
    
    // for min heap
    int delete() {
        if (currSize == 0)
            return -1;
        
        int delElem = arr[1];
        arr[1] = arr[currSize];
        currSize--;
        
        int i = 1;
        while (i < currSize) {
            int left = 2 * i;
            int right = 2 * i + 1;
            int smaller = i;
            
            if (left <= currSize && arr[smaller] > arr[left])
                smaller = left;
            
            if (right <= currSize && arr[smaller] > arr[right])
                smaller = right;
            
            if (i == smaller)
                break;
            
            swap(i, smaller);
            i = smaller;
        }
        
        return delElem;
    }
    
    // for max heap
    int delete() {
        int delElem = arr[1];
        arr[1] = arr[currSize];
        currSize--;
        int i = 1;
        
        while (i >= 1) {
            int left = 2 * i;
            int right = left + 1;
            
            if (left > currSize || right > currSize)
                break;
            
            int larger = arr[left] > arr[right] ? left : right;
            
            if (arr[i] > arr[larger]) {
                swap(i, larger);
                i = larger;
            }
            else 
                break;
        }
        
        return delElem;
    }
}





//     Time complexity: O( N * log( N ) )
//     Space complexity: O( N )

//     Where N is the size of heap array.


public class Solution {

    // Left child of the node.
    static int left(int k) {
        return 2 * k + 1;
    }

    // Right child of the node.
    static int right(int k) {
        return 2 * k + 2;
    }

    // Returns the parent node.
    static int parent(int k) {
        return (k - 1) / 2;
    }

    // Heapify the heap
    static void heapify(int[] heap, int k, int size) {

        // Find the left child of the node.
        int l = left(k);

        // Find the right child of the node.
        int r = right(k);

        // Find the smallest element between the current node and its children.
        // Check if the left child is smallest.
        int smallest = k;

        if (l < size && heap[l] < heap[k]) {
            smallest = l;
        }

        // Check if the right node is smallest then the previous smallest.
        if (r < size && heap[r] < heap[smallest]) {
            smallest = r;
        }

        // If the smallest element is not in the current node.
        // We have to heapify the Heap to take that element to the top.
        if (smallest != k) {

            // Swap the values of current node and the smallest node value.
            int tempp = heap[k];
            heap[k] = heap[smallest];
            heap[smallest] = tempp;

            // Call the heapify function on smallest value node which now contains the value of parent node.
            heapify(heap, smallest, size);
        }
    }

    static int sz;

    // Insert a val in the heap.
    // Function contains heap array, val to inserted and the current size of the heap.
    static void insert(int[] heap, int val) {

        // Insert the val at the end of the heap.
        heap[sz] = val;

        // If There is nore than 1 node in the Heap.
        // MinHeapify the heap by checking the val at its parent node.
        // Also do it until the heap property is not satisfied.
        int i = sz;

        sz += 1;

        while (i != 0 && heap[parent(i)] > heap[i]) {

            // Swap the value of current node with its parent.
            int tmp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = tmp;

            // Check that if the parent element of current element is satisfying the heap property.
            i = parent(i);
        }
    }

    static int extractMin(int[] heap) {

        // Check if the current node is the only node in the heap.
        if (sz == 1) {
            sz -= 1;
            return heap[0];
        }

        // Takeout the min value and remove it from the heap.
        int val = heap[0];

        // Put last node on the top of heap.
        heap[0] = heap[sz - 1];

        // Decrease the size of heap as the minimum element is removed.
        sz -= 1;

        // Heapify the heap to satisfy the heap property.
        heapify(heap, 0, sz);

        return val;
    }

    // minHeap function which take size of Queries and Queries as Input.
    // Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {

        int size = 0;

        int[] heap = new int[n];

        // Define an array which stores the min elements.
        int tot = 0;
        for(int i=0;i<n;i++){
            if(q[i][0]==1)tot++;
        }

        int[] ans = new int[tot];
        int id = 0;

        // For each query in the array Q.
        for (int i = 0; i < n; i++) {

            // If query is of type 1 then insert the value in the heap.
            // Else take min element from the heap and append it in the ans.
            if (q[i][0] == 0) {
                sz = size;
                insert(heap, q[i][1]);
                size = sz;
            } else {
                sz = size;
                ans[id++] = extractMin(heap);
                size = sz;
            }
        }

        // Return the ans array.
        return ans;
    }
}
