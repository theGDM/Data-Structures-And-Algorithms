import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        boolean res = haveDuplicateBrackets(s);
        System.out.println(res);
    }
    
    public static boolean haveDuplicateBrackets(String s){
        int count = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) == ')'){
                count = 0;
                while(s.charAt(stk.peek()) != '('){
                    stk.pop();
                    ++count;
                }
                stk.pop();
                if(count == 0){
                    return true;
                }
            }else{
                stk.push(i);
            }
        }
        return false;
    }
}
