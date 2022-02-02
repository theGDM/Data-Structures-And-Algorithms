import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        
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
                    System.out.println("true");
                    break;
                }
            }else{
                stk.push(i);
            }
        }
        if(count != 0){
            System.out.println("false");
        }
    }
}
