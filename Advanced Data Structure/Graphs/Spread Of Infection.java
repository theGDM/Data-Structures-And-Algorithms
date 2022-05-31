import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   static class Pair{ 
      int v;
      int time;

      Pair(int v, int time){
         this.v = v;
         this.time = time;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      int[] visited = new int[vtces];
      Arrays.fill(visited, -1);

      int countOfInfected = countInfected(src, t, graph, visited);
      System.out.println(countOfInfected);
   }

   public static int countInfected(int src, int t, ArrayList<Edge>[] graph, int[] visited){
      Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, 1));
      int count = 0;
      while(q.size() != 0){
         Pair rPair = q.remove();

         if(visited[rPair.v] > 0){ //matlab pahle hi infected hai to kuchh nahi karna
            continue;
         }

         visited[rPair.v] = rPair.time; //mark visited

         if(rPair.time > t){
            break; 
         }
         ++count; //work

         for(Edge e : graph[rPair.v]){ //add all the non infected nbrs
            if(visited[e.nbr] == -1){
               q.add(new Pair(e.nbr, rPair.time + 1));
            }
         }
      }

      return count;
   }
}
