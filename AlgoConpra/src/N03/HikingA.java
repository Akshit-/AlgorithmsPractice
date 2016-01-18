package N03;
import java.io.*;
import java.util.*;
 

//Solution for this adapted from http://rosettacode.org/wiki/Dijkstra's_algorithm#Java
public class HikingA {
 
   public static void main(String[] args) throws IOException {
	   
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t=1;t<=T;t++){
			
			String params = in.readLine();
			
			StringTokenizer posPlsString = new StringTokenizer(params, " ");

			int n = Integer.valueOf(posPlsString.nextElement().toString());
			int m = Integer.valueOf(posPlsString.nextElement().toString());
			
			
			List<Graph_Heap.Edge> lEdges = new ArrayList<>();
			
			for(int i=0;i<m;i++){
				String edges = in.readLine();
				
				StringTokenizer edgesStr = new StringTokenizer(edges, " ");
				int v1 = Integer.valueOf(edgesStr.nextElement().toString());
				int v2 = Integer.valueOf(edgesStr.nextElement().toString());
				int dist = Integer.valueOf(edgesStr.nextElement().toString());

				lEdges.add(new Graph_Heap.Edge(v1, v2, dist));
			}
			
			int START = 1;
			int END = n;
			
			Graph_Heap g = new Graph_Heap(lEdges);
			g.dijkstra(START);
//			g.printPath(END);
			
			Integer d = g.distToVertex(END);
			
			out.write("Case #"+t+": "+d+"\n");
			
			if(t!=T){
				//out.write("\n");
				in.readLine();
			}
			
		}
				
		out.flush();
	    in.close();
	    out.close();
      
      
   }
}
 
class Graph_Heap{
   private final Map<Integer, Vertex> graph; // mapping of vertex names to Vertex objects, built from a set of Edges
 
   /** One edge of the graph (only used by Graph constructor) */
   public static class Edge {
      public final int v1, v2;
      public final int dist;
      public Edge(int v1, int v2, int dist) {
         this.v1 = v1;
         this.v2 = v2;
         this.dist = dist;
      }
   }
 
   /** One vertex of the graph, complete with mappings to neighbouring vertices */
   public static class Vertex implements Comparable<Vertex> {
      public final int id;
      public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
      public Vertex previous = null;
      public final Map<Vertex, Integer> neighbours = new HashMap<>();
 
      public Vertex(int id) {
         this.id = id;
      }
 
      private void printPath() {
         if (this == this.previous) {
            System.out.printf("%s", this.id);
         } else if (this.previous == null) {
            System.out.printf("%s(unreached)", this.id);
         } else {
            this.previous.printPath();
            System.out.printf(" -> %s(%d)", this.id, this.dist);
         }
      }
      
      public int compareTo(Vertex other) {
         return Integer.compare(dist, other.dist);
      }
   }
 
   /** Builds a graph from a set of edges */
   public Graph_Heap(List<Graph_Heap.Edge> edges) {
      graph = new HashMap<>(edges.size());
 
      //one pass to find all vertices
      for (Edge e : edges) {
         if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
         if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
      }
 
      //another pass to set neighboring vertices
      for (Edge e : edges) {
    	  
    	  Map<Vertex, Integer> map = graph.get(e.v1).neighbours;
    	  
    	  boolean alreadyPresent = false;
    	  
		  for (Map.Entry<Vertex, Integer> a : map.entrySet()) {
            Vertex v = a.getKey(); //the neighbor in this iteration
            if(v.id==e.v2){
            	if(e.dist<a.getValue()){
            		graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
       		  		graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist);// also do this for an undirected graph
            	}
            	alreadyPresent = true;
            	break;
            }	
		  }
    	  
		  if(!alreadyPresent){
			  graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
			  graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
		  }
      }
   }
 
   /** Runs dijkstra using a specified source vertex */ 
   public void dijkstra(int startID) {
      if (!graph.containsKey(startID)) {
         System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startID);
         return;
      }
      final Vertex source = graph.get(startID);
      NavigableSet<Vertex> q = new TreeSet<>();
 
      // set-up vertices
      for (Vertex v : graph.values()) {
         v.previous = v == source ? source : null;
         v.dist = v == source ? 0 : Integer.MAX_VALUE;
         q.add(v);
      }
 
      dijkstra(q);
   }
 
   /** Implementation of dijkstra's algorithm using a binary heap. */
   private void dijkstra(final NavigableSet<Vertex> q) {      
      Vertex u, v;
      while (!q.isEmpty()) {
 
         u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
         //if (u.dist == Integer.MAX_VALUE) break; // we can ignore u (and any other remaining vertices) since they are unreachable
 
         //look at distances to each neighbour
         for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
            v = a.getKey(); //the neighbour in this iteration
 
            int alternateDist = u.dist + a.getValue();
            if (alternateDist < v.dist) { // shorter path to neighbour found
               q.remove(v);
               v.dist = alternateDist;
               v.previous = u;
               q.add(v);
            } 
         }
      }
   }
 
   /** Prints a path from the source to the specified vertex */
   public void printPath(int endID) {
      if (!graph.containsKey(endID)) {
         System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endID);
         return;
      }
 
      graph.get(endID).printPath();
      System.out.println();
   }
   
   /** Distance to a specified vertex from start */
   public int distToVertex(int endID) {
	   if (graph.containsKey(endID)) {
		   return graph.get(endID).dist;
	   }
	   
      return Integer.MAX_VALUE;
      
   }
   
   /** Prints the path from the source to every vertex (output order is not guaranteed) */
   public void printAllPaths() {
      for (Vertex v : graph.values()) {
         v.printPath();
         System.out.println();
      }
   }
}