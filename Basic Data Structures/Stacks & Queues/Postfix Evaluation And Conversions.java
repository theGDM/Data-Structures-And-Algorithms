import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> valueStack = new Stack<>();
    Stack<String> infixStack = new Stack<>();
    Stack<String> prefixStack = new Stack<>();

    for(int i = 0;i < exp.length(); ++i){
        char ch = exp.charAt(i);
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            char operator = ch;
            //infix work
            int val2 = valueStack.pop();
            int val1 = valueStack.pop();
            int res = operation(val1, operator, val2);
            valueStack.push(res);
            //infix work
            String infixV2 = infixStack.pop();
            String infixV1 = infixStack.pop();
            String infixRes = "(" + infixV1+ operator + infixV2 + ")";
            infixStack.push(infixRes);
            //prefix work
            String prefixV2 = prefixStack.pop();
            String prefixV1 = prefixStack.pop();
            String prefixRes = operator + prefixV1 + prefixV2;
            prefixStack.push(prefixRes);
        }else{
            valueStack.push(ch - '0');
            infixStack.push(ch + "");
            prefixStack.push(ch + "");
        }
    }

    System.out.println(valueStack.peek());
    System.out.println(infixStack.peek());
    System.out.println(prefixStack.peek());
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
