import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> valueStack = new Stack<>();
    Stack<String> infixStack = new Stack<>();
    Stack<String> postfixStack = new Stack<>();

    for(int i = exp.length() - 1;i >= 0; --i){
        char ch = exp.charAt(i);
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            char operator = ch;
            //infix work
            int val1 = valueStack.pop();
            int val2 = valueStack.pop();
            int res = operation(val1, operator, val2);
            valueStack.push(res);
            //infix work
            String infixV1 = infixStack.pop();
            String infixV2 = infixStack.pop();
            String infixRes = "(" + infixV1 + operator + infixV2 + ")";
            infixStack.push(infixRes);
            //prefix work
            String postfixV1 = postfixStack.pop();
            String postfixV2 = postfixStack.pop();
            String postfixRes = postfixV1 + postfixV2 + operator;
            postfixStack.push(postfixRes);
        }else{
            valueStack.push(ch - '0');
            infixStack.push(ch + "");
            postfixStack.push(ch + "");
        }
    }

    System.out.println(valueStack.peek());
    System.out.println(infixStack.peek());
    System.out.println(postfixStack.peek());
 }

 public static int operation(int a, char operator, int b){
     int res = 0;
     switch(operator){
        case '+' : res = a + b;
                    break;
        case '-' : res = a - b;
                    break;
        case '*' : res = a * b;
                    break;
        case '/' : res = a / b;
                    break;
     }
     return res;
 }
}
