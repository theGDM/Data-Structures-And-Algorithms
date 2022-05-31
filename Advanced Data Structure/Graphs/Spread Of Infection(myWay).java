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
      int t;

      Pair(int v, int t){
         this.v = v;
         this.t = t;
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
      
      boolean[] visited = new boolean[vtces];
      int countOfInfected = countInfected(src, t, graph, visited);
      System.out.println(countOfInfected);
   }

   public static int countInfected(int src, int limit, ArrayList<Edge>[] graph, boolean[] visited){
      Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, 1));
      int count = 0;
      while(q.size() != 0){
         Pair rPair = q.remove();
         if(rPair.t > limit){
            break;
         }

         if(visited[rPair.v] == true){ //matlab pahle hi infected hai to kuchh nahi karna
            continue;
         }

         visited[rPair.v] = true; //mark visited
         ++count; //work

         for(Edge e : graph[rPair.v]){ //add all the non infected nbrs
            if(visited[e.nbr] == false){
               q.add(new Pair(e.nbr, rPair.t + 1));
            }
         }
      }

      return count;
   }
}
