import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        boolean res = balancedBrackets(s);
        System.out.println(res);
    }
    
    public static boolean balancedBrackets(String s){
        Stack<Integer> stk = new Stack<>();
        for(int i = 0;i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stk.push(i);
            }else if(ch == ')' || ch == '}' || ch == ']'){
                if(stk.isEmpty()){
                    return false;
                }else if(s.charAt(stk.peek()) ==  '(' && ch == ')'){
                    stk.pop();
                }else if(s.charAt(stk.peek()) ==  '{' && ch == '}'){
                    stk.pop();
                }else if(s.charAt(stk.peek()) ==  '[' && ch == ']'){
                    stk.pop();
                }else{
                    return false; //"(}"
                }
            }
        }
        //only opening brackets are left
        if(stk.size() != 0){ //"(", "(}"
            return false;
        }else{
            return true;
        }
    }
}
