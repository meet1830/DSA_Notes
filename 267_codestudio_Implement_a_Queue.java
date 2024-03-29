/* 
 * Implement a Queue
Implement a Queue Data Structure specifically to store integer data using a Singly Linked List or an array.
You need to implement the following public functions :
1. Constructor: It initializes the data members as required.

2. enqueue(data): This function should take one argument of type integer. It enqueues the element into the queue.

3. dequeue(): It dequeues/removes the element from the front of the queue and in turn, returns the element being dequeued or removed. In case the queue is empty, it returns -1.

4. front(): It returns the element being kept at the front of the queue. In case the queue is empty, it returns -1.

5. isEmpty(): It returns a boolean value indicating whether the queue is empty or not.
Operations Performed On The Queue :
Query-1(Denoted by an integer 1): Enqueues integer data to the queue.

Query-2(Denoted by an integer 2): Dequeues the data kept at the front of the queue and returns it to the caller, return -1 if no element is present in the queue.

Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the front of the queue but doesn't remove it, unlike the dequeue function, return -1 if no element is present in the queue.

Query-4(Denoted by an integer 4): Returns a boolean value denoting whether the queue is empty or not.

Input Format :
The first line contains an integer ‘t’ denoting the number of test cases.

For each test case, the first line contains an integer 'q' which denotes the number of queries to be run against each operation on the queue. 

Every 'q' lines represent an operation that needs to be performed.

For the enQueue operation, the input line will contain two integers separated by a single space, representing the type of the operation in the integer and the integer data being enqueued into the queue.

For the rest of the operations on the queue, the input line will contain only one integer value, representing the query being performed on the queue.

Output Format :
For Query-1, print the data being enqueued in the queue.
For Query-2, print the data being dequeued from the queue.
For Query-3, print the data kept on the front of the queue.
For Query-4, print 'true' or 'false'(without quotes).

Output for every query will be printed in a separate line.
Note :
You are not required to print anything explicitly. It has already been taken care of. Just implement the functions.

Constraints :
1 <= t <= 5
1 <= q <= 5000
1 <= x <= 4
1 <= data <= 2^31 - 1
Time Limit: 1 sec

Sample Input 1 :
1
7
1 17
1 23
1 11
2
2
2
2
Sample Output 1 :
17
23
11
-1
Explanation For Sample Output 1 :
The first three queries are of enQueue, so we will push 17, 23, and 11 into the queue.

The next four queries are of deQueue, so we will starting removing elements from the queue, so the first element will be 17, then 23, and then 11. And after the third dequeue query, the queue is now empty so for the fourth query, we will return -1.

Sample Input 2 :
1
3
2
1 10
3
Sample Output 2 :
-1 
10
*/


public class Queue {
    int front = -1;
    int rear = -1;
    int[] arr;
    int count = 0;
    
    Queue() {
        arr = new int[5001];    
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        return count == 0;
    }

    void enqueue(int data) {
        if (count == arr.length) 
            return;
        if (front == -1)
            front++;
        
        rear = (rear + 1) % arr.length;
        arr[rear] = data;
        count++;
    }

    int dequeue() {
        if (count == 0) 
            return -1;
        
        int x = arr[front];
        front = (front + 1) % arr.length;
        count--;
        
        if (count == 0) {
            front = -1;
            rear = -1;
        }
        
        return x;
    }

    int front() {
        if (count == 0)
            return -1;
        
        return arr[front];
    }

}
