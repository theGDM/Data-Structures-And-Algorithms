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

   static class Pair{
      int v;
      String psf;
      int lvl;

      Pair(int v, String psf, int lvl){
         this.v = v;
         this.psf = psf;
         this.lvl = lvl;
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

      int[] visited = new int[vtces];
      Arrays.fill(visited, -1);

      for(int v = 0; v < vtces; ++v){
         if(visited[v] == -1){
            boolean isCompBipartite = checkCompBipartite(v, graph, visited);
            //if any of the component of the graph is not bipartite, then whole graph is not bipartite!
            if(isCompBipartite == false){
               System.out.println(false);
               return;
            }
         }
      }
      //if all the component of the graph is bipartite, then only whole graph is bipartite!
      System.out.println(true);
   }

   public static boolean checkCompBipartite(int src, ArrayList<Edge>[] graph, int[] visited){
      Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, src + "", 0));

      while(q.size() != 0){
         Pair rPair = q.remove(); //remove
         if(visited[rPair.v] != -1){
            //jo removed pair ka vertex hai uska old level visited me pada hai, aur new
            //level pair me pada hai
            if(rPair.lvl != visited[rPair.v]){ //odd cycle detected, not bipartite
               return false;
            }
         }
            
         visited[rPair.v] = rPair.lvl; //mark visited
         for(Edge e : graph[rPair.v]){ //add all unvisited nbrs
            if(visited[e.nbr] == -1){
               q.add(new Pair(e.nbr, rPair.psf + e.nbr, rPair.lvl + 1));
            }
         }
      } 

      return true;
   }
}
