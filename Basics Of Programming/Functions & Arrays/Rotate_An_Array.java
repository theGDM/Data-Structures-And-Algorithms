import java.io.*;

public class Rotate_An_Array{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }
  
  public static void reverse(int[] b,int left,int right){
      int temp;
      while(left < right){
          //swap
          temp = b[left];
          b[left] = b[right];
          b[right] = temp;
          //update left and right
          ++left;
          --right;
      }
  }

  public static void rotate(int[] a, int k){
    // write your code here
    
    //calculating size
    int n = a.length;
    
    //Handle larger k values
    k = k%n;
    
    //Handle -ve values
    if(k<0){
        k=k+n;
    }
    
    // 1. Reverse First Block
    reverse(a,0,n-k-1);
    // 1. Reverse First Block
    reverse(a,n-k,n-1);
    // 1. Reverse Entire Array
    reverse(a,0,n-1);
      
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}