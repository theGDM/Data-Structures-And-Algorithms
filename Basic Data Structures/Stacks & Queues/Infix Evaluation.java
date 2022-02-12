import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Integer> operandStk = new Stack<>();
    Stack<Character> operator = new Stack<>();
    for(int i = 0;i < exp.length(); ++i){
        char ch = exp.charAt(i);
        if(ch >= '0' && ch <= '9'){
            //push operand in operand stack
            operandStk.push(ch - '0');
        }else if(ch == '('){
            operator.push(ch);
        }else if(ch == ')'){
            //operator -> + or - or * or /
            while(operator.peek() != '('){
                int b = operandStk.pop();
                int a = operandStk.pop();
                char op = operator.pop();
                int res = opPerform(a, op, b);
                operandStk.push(res);
            }
            operator.pop();//pop opening bracket as well
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operator.size() > 0 && operator.peek() != '(' 
            && precedence(operator.peek()) >= precedence(ch)){
                int b = operandStk.pop();
                int a = operandStk.pop();
                char op = operator.pop();
                int res = opPerform(a, op, b);
                operandStk.push(res);
            }
            operator.push(ch);
        }
    }
    while(operator.size() > 0){
        int b = operandStk.pop();
        int a = operandStk.pop();
        char op = operator.pop();
        int res = opPerform(a, op, b);
        operandStk.push(res);
    }

    System.out.println(operandStk.peek());
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
