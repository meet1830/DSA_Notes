// convert infix expression to postfix expression 
// prefix -> operator before operands
// infix -> operator between operands
// postfix -> operator after operands
import java.util.*;

public class Main {
  public static int getPrec(char op) {
    switch(op) {
      case '+': 
        return 1;
      case '-':
        return 1;
      case '*':
        return 2;
      case '/':
        return 2;
      case '^':
        return 3;
      default:
        return 0;
    }
  }
  
  public static String intoPost(String s) {
    Stack<Character> st = new Stack<>();
    String postFix = "";
    
    for(Character c : s.toCharArray()) {
      if(c == '(') {
        st.push(c);
      }
      else if(c == ')') {
        while(st.peek() != '(') {
          // here isempty condition because if wrong expression entered
          // or input does not have any operators then will return error
          postFix += st.pop();
        }
        // removing opening bracket from stack
        st.pop();
      }
      else if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
        // if c is an operator
        while(!st.isEmpty() && getPrec(c) <= getPrec(st.peek())) {
          // isempty check if does not have any operator
          // or wrong expression entered returns error
          // if prec of operator is smaller than or 
          // equal to top of the stack then pop out
          postFix += st.pop();
        }
        // after all lower precedence operators are added
        // then at last add operator of higher precedence
        st.push(c);
      }
      else {
        // c is operand then just add to result
        postFix += c;
      }
    }
    
    // remove all elements from stack
    while(!st.isEmpty()) {
      postFix += st.pop();
    }
    
    return postFix;
  }
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println(intoPost(input.next()));
  }
}
