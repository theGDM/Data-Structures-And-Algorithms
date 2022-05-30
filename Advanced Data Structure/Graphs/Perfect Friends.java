import java.io.*;
import java.util.*;

public class Main {
   
   public static class Edge{
      int src;
      int nbr;
      Edge(int src, int nbr){
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      //creating graph, which is Array of ArrayList of type Edge
      ArrayList<Edge>[] graph = new ArrayList[n];

      //putting empty AL in the graph
      for(int v = 0; v < n; ++v){
         graph[v] = new ArrayList<>();
      }

      //making edges
      for(int e = 0; e < k; ++e){
         String line = br.readLine();
         String[] parts = line.split(" ");

         //vertex
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);

         //edges creation
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      //Components AL
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[n];

      for(int v = 0; v < n; ++v){
         if(visited[v] != true){
           ArrayList<Integer> comp = new ArrayList<>(); //component Al
           getComponent(v, graph, visited, comp);
           comps.add(comp);
         }
      }
      
      //No of ways we can select two student from diff clubs
      int pairs = 0;
      for(int i = 0;i < comps.size(); ++i){
         for(int j = i + 1; j < comps.size(); ++j){
            pairs += comps.get(i).size() * comps.get(j).size();
         }
      }
      
      System.out.println(pairs);
   }

   public static void getComponent(int src, ArrayList<Edge>[] graph, boolean[] visited, ArrayList<Integer> comp){
      visited[src] = true;//mark visited
      comp.add(src);//add in comp

      //iterate over its nbrs
      for(Edge e : graph[src]){
         if(visited[e.nbr] != true){
            getComponent(e.nbr, graph, visited, comp);
         }
      }
   }
}
