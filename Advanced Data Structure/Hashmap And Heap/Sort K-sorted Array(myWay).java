import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      
      //min heap
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      for(int i = 0;i < arr.length; ++i){
         if(i <= k){ //make funnel of k + 1 elements, as the element can go upto that range only
            pq.add(arr[i]);
         }else{
            System.out.println(pq.remove()); //release
            pq.add(arr[i]); //acquire
         }
      }

      while(pq.size() > 0){ //remaining elements in the queue
         System.out.println(pq.remove());
      }
   }

}
