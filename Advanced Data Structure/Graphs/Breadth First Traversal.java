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

      boolean[] visited = new boolean[vtces];
      Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, "" + src));

      while(q.size() != 0){
         Pair rVtce = q.remove(); //remove
         if(visited[rVtce.src] == true){
            continue;
         }

         visited[rVtce.src] = true; //mark visited
         System.out.println(rVtce.src + "@" + rVtce.psf); //print
         
         for(Edge e : graph[rVtce.src]){ //add all the unvisited child
            if(visited[e.nbr] == false){
               q.add(new Pair(e.nbr, rVtce.psf + e.nbr));
            }
         }
      } 
   }

   static class Pair {
      int src;
      String psf;
      Pair(int src,  String psf){
         this.src = src;
         this.psf = psf;
      }
   }

}
