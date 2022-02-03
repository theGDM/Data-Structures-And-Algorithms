import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] nsel = nextSmallerElementLeft(a);
    int[] nser = nextSmallerElementRight(a);
    
    int largestArea = Integer.MIN_VALUE;
    for(int i = 0;i < a.length; ++i){
        int width = nser[i] - nsel[i] - 1;
        int height = a[i];
        int currArea = width * height;
    
        if(currArea > largestArea){
           largestArea = currArea;
        }
    }
    System.out.println(largestArea);
  }

  public static int[] nextSmallerElementLeft(int[] arr) {
    int[] nsel = new int[arr.length];
    Stack<Integer> stk = new Stack<>();
    for (int i =  0; i < arr.length; ++i) {
      while (stk.size() > 0 && arr[i] <= arr[stk.peek()]) {
        stk.pop();
      }

      if (stk.size() > 0) {
        nsel[i] = stk.peek();
      } else {
        nsel[i] = -1;
      }

      stk.push(i);
    }
    return nsel;
  }
  
  public static int[] nextSmallerElementRight(int[] arr) {
    int[] nser = new int[arr.length];
    Stack<Integer> stk = new Stack<>();
      
    for(int i =  arr.length - 1;i >= 0; --i){
        while(stk.size() > 0 && arr[i] <= arr[stk.peek()]){
            stk.pop();
        }
    
        if(stk.size() > 0){
           nser[i] = stk.peek(); 
        }else{
           nser[i] = arr.length; 
        }
        
        stk.push(i);
    }
    return nser; 
  }
}
