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

      int src = Integer.parseInt(br.readLine());
      boolean[] visited = new boolean[vtces];
      pathAndCycle(src, src, graph, visited, "" + src);
   }

   public static void pathAndCycle(int startPoint, int src, ArrayList<Edge>[] graph, boolean[] visited, String psf){
      if(psf.length() == graph.length){
         boolean isCycle = false;
         //checking if the last added vertex has src vertex in its neighbour, if so it is the hamiltonian cycle
         //else hamiltonian path
         for(Edge e : graph[src]){
            if(e.nbr == startPoint){
               isCycle = true;
               break;
            }
         }

         if(isCycle){
            System.out.println(psf + "*");
         }else{
            System.out.println(psf + ".");
         }
         return;
      }

      visited[src] = true;
      for(Edge e : graph[src]){
         if(visited[e.nbr] != true){
            pathAndCycle(startPoint, e.nbr, graph, visited, psf + e.nbr);
         }
      }
      visited[src] = false;
   }
}
