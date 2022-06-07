import java.io.*;
import java.util.*;

public class Main {

   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
      //T.C. = O(k * ni * log(ni));
      while(true){
         int minV = Integer.MAX_VALUE;
         int minI = 0;
         int count = 0;
         int k = 0;
         for(int i = 0;i < lists.size(); ++i){ //O(k)
            ArrayList<Integer> list = lists.get(i);
            // System.out.println(list);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j = 0; j < list.size(); ++j){ //O(nilog(ni))
               pq.add(list.get(j));
            }

            if(pq.size() > 0) {
               int r = pq.remove(); //remove smallest element from the current pq
               if(r < minV){ 
                  minV = r;
                  k = i;
               }
            }else{ 
               ++count;
            }
         }
      
         if(count == lists.size()){
            return rv;
         }

         rv.add(minV);
         lists.get(k).remove(0);
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
