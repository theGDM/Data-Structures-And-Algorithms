import java.io.*;

public class Rotate_An_Array_Brute{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }
  
public static void rotateBrute(int[] b,int k) {
    int temp;
      for (int i = 1; i <= k; ++i) {
          temp = b[b.length-1];
          for (int j = b.length - 1; j >= 1; --j) {
              b[j] = b[j - 1];
          }
          b[0] = temp;
      }
  }

  public static void rotate(int[] a, int k){
    // write your code here
    
    //calculating size
    int n = a.length;
    
    //Handle larger k values
    k = k%n;
    
    //Handle -ve values
    if (k < 0) {
        k = k + n;
    }
    
    // brute force approach
    rotateBrute(a,k);
      
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