package Networking;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
 
class Neighbor {
    public int vertexNum;
    public Neighbor next;
    public Neighbor(int vnum, Neighbor nbr) {
    	this.vertexNum = vnum;
    	next = nbr;
    }
    public void removeN(int n){
    	 
    }
    
}
 
class Vertex {
    int id;
    Neighbor adjList;
    Vertex(int id, Neighbor neighbors) {
		this.id = id;
    	this.adjList = neighbors;
    }
    
    public void removeN(int idN){
    	for (Neighbor nbr=adjList; nbr != null; nbr=nbr.next) {
   		 	//nbr.
   	 	}
    }
    
    
}

/**
 * @author Sesh Venugopal. 
 */
public class Graph {
 
    Vertex[] adjLists;
     
    public Graph(BufferedReader in, BufferedWriter out) throws IOException {
         
	    String first = in.readLine();
	    
	    StringTokenizer params = new StringTokenizer(first, " ");
    	
    	int num_stations = Integer.valueOf(params.nextElement().toString());
    	int num_connections = Integer.valueOf(params.nextElement().toString());
	    
        //String graphType = sc.next();
        //boolean undirected=true;
//        if (graphType.equals("directed")) {
//            undirected=false;
//        }
         
        adjLists = new Vertex[num_stations+1];
 
        // read vertices
        for (int v=1; v <adjLists.length; v++) {
            adjLists[v] = new Vertex(v, null);
        }
        
        int j =0;
        // read edges
        while (j<num_connections) {
        	String edges = in.readLine();
        	// read vertex names and translate to vertex numbers
        	StringTokenizer edgesString = new StringTokenizer(edges, " ");
        	
        	int v1 = Integer.valueOf(edgesString.nextElement().toString());
        	int v2 = Integer.valueOf(edgesString.nextElement().toString());
        	
            // add v2 to front of v1's adjacency list and
            // add v1 to front of v2's adjacency list
            adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
            adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
            j++;
        }
        
        //sc.next();
        
       
    }
     
    int indexForName(int id) {
        for (int v=1; v <adjLists.length; v++) {
            if (adjLists[v].id==id) {
                return v;
            }
        }
        return -1;
    }   
     
    // recursive dfs
    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        //System.out.println("visiting " + adjLists[v].id);
        for (Neighbor nbr=adjLists[v].adjList; nbr != null; nbr=nbr.next) {
            if (!visited[nbr.vertexNum]) {
                //System.out.println("\n" + adjLists[v].id + "--" + adjLists[nbr.vertexNum].id);
                dfs(nbr.vertexNum, visited);
            }
        }
    }
     
    public void dfs() {
        boolean[] visited = new boolean[adjLists.length];
        int nC =0;
        for (int v=1; v < visited.length; v++) {
            if (!visited[v]) {
            	 nC++;
                //System.out.println("\nSTARTING AT " + adjLists[v].id);
                dfs(v, visited);
            }
           
        }
        System.out.println("#C="+nC);
    }
     
     
    public void print() {
        System.out.println();
        
        adjLists[1].removeN(1);
        
        for (int v=1; v< adjLists.length; v++) {
            System.out.print(adjLists[v].id+"-->");
            for (Neighbor nbr=adjLists[v].adjList; nbr != null;nbr=nbr.next) {
                System.out.print(adjLists[nbr.vertexNum].id+", ");
            }
            System.out.println("\n");
        }
    }
     
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    	int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int t =1;
    	
    	while(t<=T){
	    	Graph graph = new Graph(in, out);
	        //graph.print();
	        graph.print();
	    	
	    	
	    	
	    	//sc.next();
	        in.readLine();
	    	t++;
    	}
    	
    	out.flush();
 	    in.close();
 	    out.close();
    }
}