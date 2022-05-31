import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      boolean[] visited = new boolean[vtces];
      for(int v = 0; v < vtces; ++v){
         if(visited[v] != true){
            boolean isCycle = isCyclic(v, graph, visited);
            if(isCycle){
               System.out.println(true);
               return;
            }
         }
      }
      System.out.println(false);
   }

   public static boolean isCyclic(int src, ArrayList<Edge>[] graph, boolean[] visited){
      Queue<Integer> q = new ArrayDeque<>();
      q.add(src);

      while(q.size() != 0){
         int rSrc = q.remove(); //remove
         if(visited[rSrc] == true){ //cycle detected
            return true;
         }

         visited[rSrc] = true; //mark visited

         for(Edge e : graph[src]){ //add all unvisited nbrs
            if(visited[e.nbr] == false){
               q.add(e.nbr);
            }
         }
      }

      return false;
   }
}
