import java.io.*;
import java.util.*;

public class Main {

   public static class Pair implements Comparable<Pair>{
      int v; //value
      int i; //index at which it is located

      Pair(int v, int i){
         this.v = v;
         this.i = i;
      }

      public int compareTo(Pair o){
         return this.v - o.v;
      }
   }

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
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for(int j = 0; j < list.size(); ++j){ //O(nilogg(ni))
               pq.add(new Pair(list.get(j), j));
            }

            if(pq.size() > 0) {
               Pair r = pq.remove(); //remove smallest element from the current pq
               if(r.v < minV){ 
                  minV = r.v;
                  minI = r.i;
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
         lists.get(k).remove(minI);
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
