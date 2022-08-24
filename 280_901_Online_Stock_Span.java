/* 
 * 901. Online Stock Span
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 

Constraints:
1 <= price <= 105
At most 104 calls will be made to next.
*/


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

// if the price array was given, then was a normal question of previous greater element or next greater element to the left

public class Main {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int n = arr.length;
        int[] span = new int[n];
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            if (st.isEmpty())
                span[i] = 1;
            else 
                span[i] = i - st.peek();
            st.push(i);
        }
        for (int x : span)
            System.out.print(x + " ");
    }
}
// span array ans -> 1 1 1 2 1 4 6 



// We should have a stack of a pair of (current  price, maximum number of consecutive days)
// Since we don't have an access to the indicies.
// can use arrays instead of pairs
// O(2 * n), O(n) as each element is added to stack and then removed

class StockSpanner {
    Stack<Pair<Integer, Integer>> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        while (!st.isEmpty() && st.peek().getKey() <= price) {
            span += st.peek().getValue();
            st.pop();
            // span++ not because we have to take into account the elements that were removed and their consecutive days is stored in stack as span for some other element nums[i] for whom the element was popped
        }
        
        st.push(new Pair (price, span));
        
        return span;
    }
}
