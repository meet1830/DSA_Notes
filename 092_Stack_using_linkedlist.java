public class Stack_using_linkedlist {
  public static void main(String[] args) {
    Stack st = new Stack();
        
    System.out.println(st.size());
        
    st.push(10);
    st.push(20);
    st.push(30);
    st.push(40);
    st.push(50);
    st.push(60);
    
    st.printStack();

    System.out.println(st.size());
		System.out.println(st.isEmpty());

    System.out.println(st.peek());
		System.out.println(st.pop());
        
    System.out.println(st.size());
  }
}

/* 0
60 50 40 30 20 10 
6
false
60
60
5 */