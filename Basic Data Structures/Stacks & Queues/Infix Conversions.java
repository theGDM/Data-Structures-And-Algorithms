import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<String> prefixStk = new Stack<>();
    Stack<String> postfixStk = new Stack<>();
    Stack<Character> operator = new Stack<>();
    for(int i = 0;i < exp.length(); ++i){
        char ch = exp.charAt(i);
        if(ch >= 'a' && ch <= 'z'){
            //push operand in both infix as well as postfix stack
            prefixStk.push(ch + "");
            postfixStk.push(ch + "");
        }else if(ch == '('){
            operator.push(ch);
        }else if(ch == ')'){
            //operator -> + or - or * or /
            while(operator.peek() != '('){
                char op = operator.pop();
                prePostOperation(prefixStk, postfixStk, op);
            }
            operator.pop();//pop opening bracket as well
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operator.size() > 0 && operator.peek() != '(' 
            && precedence(operator.peek()) >= precedence(ch)){
                char op = operator.pop();
                prePostOperation(prefixStk, postfixStk, op);
            }
            operator.push(ch);
        }
    }
    while(operator.size() > 0){
        char op = operator.pop();
        prePostOperation(prefixStk, postfixStk, op);
    }
    
    System.out.println(postfixStk.peek());
    System.out.println(prefixStk.peek());
 }

 public static void prePostOperation(Stack<String> prefixStk, Stack<String> postfixStk, char op){
    //prefix work
    String prefV2 = prefixStk.pop();
    String prefV1 = prefixStk.pop();
    prefixStk.push(op + prefV1 + prefV2);
                
    //postfix work
    String postfV2 = postfixStk.pop();
    String postfV1 = postfixStk.pop();
    postfixStk.push(postfV1 + postfV2 + op);
 }

 public static int opPerform(int a, char op, int b){
     switch(op){
         case '+' : return a + b;
         case '-' : return a - b;
         case '*' : return a * b;
         case '/' : return a / b;
     }
     return 0;
 }

 public static int precedence(char op){
     if(op == '/' || op == '*'){
         return 2;
     }else if(op == '+' || op == '-'){
         return 1;
     }else {
         return 0;
     }
 }
}
