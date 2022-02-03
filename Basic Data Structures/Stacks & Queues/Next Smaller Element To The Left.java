import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
  }

  public static int[] solve(int[] arr) {
    int[] nse = new int[arr.length];
    Stack<Integer> stk = new Stack<>();
      
    for(int i =  0;i < arr.length; ++i){
        //pop greater or equal elements to the left(in the stack)
        while(stk.size() > 0 && arr[i] <= arr[stk.peek()]){
            stk.pop();
        }
        //if any element exits in the stack that means, that is
        //the nse of current index, as all the equal and greater element compare
        //to the current element have been popped from the stack.It means only          
        //smaller element left.
        if(stk.size() > 0){
           nse[i] = arr[stk.peek()]; 
        }else{
           nse[i] = -1; 
        }
        //push ourself to find our nse to the left
        stk.push(i);
    }
    return nse; 
  }

}
