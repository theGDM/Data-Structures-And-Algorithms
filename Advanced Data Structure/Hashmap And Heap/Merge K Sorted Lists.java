import java.io.*;
import java.util.*;

public class Main {

   public static class Pair implements Comparable<Pair>{
      int li; //list index
      int di; //data index
      int val; //value

      Pair(int li, int di, int val){
         this.li = li;
         this.di = di;
         this.val = val;
      }

      public int compareTo(Pair o){
         return this.val - o.val;
      }
   }

   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int i = 0;i < lists.size(); ++i){ //O(k)
         pq.add(new Pair(i, 0, lists.get(i).get(0))); //add the initial element of each list in pq, along 
      }                                               //with there list index in lists(AL of AL) and data index on that list 

      while(pq.size() > 0){ //n times
         Pair  rp = pq.remove(); //O(k)
         rv.add(rp.val); //O(1)
         ++rp.di; //increment the di of removed pair

         if(rp.di < lists.get(rp.li).size()){ //whether the incremented index is within limit
            rp.val = lists.get(rp.li).get(rp.di);
            pq.add(rp); //O(k);
         }
      }

      return rv;
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
