import java.util.*;
import java.io.*;

 
public class Main {
	private static int time = 1;
	private static void doDFS(Graph2 g, int u, int[] desc, int[] low, ArrayList<Pair> bridge, int[] parent)
	{
		if(g == null)
			return;
		desc[u] = low[u] = time++;
		int size = g.adj[u].size();
		int i=0, v = -1;
		for(i=0; i<size; i++)
		{
			v = (int) g.adj[u].get(i);		
			if(desc[v] == -1)
			{
				parent[v] = u;
				doDFS(g, v, desc, low, bridge, parent);
				low[u] = Math.min(low[u], low[v]);
				if(low[v] > desc[u])
					bridge.add(new Pair(u, v));
			}
			else if(v != parent[u])
				low[u] = Math.min(low[u], desc[v]);
		}
	}
 
	private static ArrayList<Pair> getBridge(Graph2 g)
	{
		if(g == null)
			return null;
		int[] parent = new int[g.V];
		int[] desc = new int[g.V];
		int[] low = new int[g.V];
		ArrayList<Pair> bridge = new ArrayList<Pair>();
		Arrays.fill(parent, -1);
		Arrays.fill(desc, -1);
		Arrays.fill(low, -1);
		doDFS(g, 0, desc, low, bridge, parent);
		return bridge;
	}
 
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	    
		for(int t=1;t<=T;t++){
			ArrayList<Pair> pairs = new ArrayList<>();
			String first = in.readLine();
			
			StringTokenizer params = new StringTokenizer(first, " ");
        	
        	int stations = Integer.valueOf(params.nextElement().toString());
        	int connections = Integer.valueOf(params.nextElement().toString());
			
        	Graph2 g = new Graph2(stations);
        	
        	for(int i=0;i<connections;i++){
				
				String edges = in.readLine();
				
				StringTokenizer edgesStr = new StringTokenizer(edges, " ");
	        	
	        	int a = Integer.valueOf(edgesStr.nextElement().toString());
	        	int b = Integer.valueOf(edgesStr.nextElement().toString());
	        	
	        	a = a-1;
	        	b = b-1;
	        	
	        	pairs.add(new Pair(a, b));
	        	
	        	g.addEdge(a,b);
	        	g.addEdge(b,a);
	        	
        	}
        	
        	ArrayList<Pair> bridge = getBridge(g);
        	
    		out.write("Case #" + t + ":");
    		
    		String concat ="";
    		for(int i=0;i<pairs.size();i++){
    			if(bridge.contains(pairs.get(i))){
    				int temp = i+1;
    				concat = concat+" "+Integer.toString(temp);
    			}
    			
    		}
    		
    		if(concat!=""){
	        	out.write(concat);
			}
    		
    		if(t!=T){
        		in.readLine();
        		out.write("\n");
        	}
    		
    		
		}
		
		out.flush();
	    in.close();
	    out.close();
	}
}
 
class Graph2 {
 
	int V;
	ArrayList<Integer> adj[];
 
	public Graph2(int V)
	{
		this.V = V;
		adj = new ArrayList[V];
		for(int i = 0 ; i<V ; i++)
			adj[i] = new ArrayList<Integer>();
	}
 
	public void addEdge(int u, int v)
	{
		adj[u].add(v);
	}
 
	void PrintGraph()
	{
		System.out.println("No of nodes: "+V);
		for(int i = 0 ; i<V ; i++)
		{
			System.out.println(i+" -- >> " + adj[i]);
		}
	}
}
 
class Pair {
	int u;
	int v;
	public Pair(int u, int v)
	{
		this.u = u;
		this.v = v;
	}
	public String toString()
	{
		return (u+1) + " -- >> " + (v+1);
	}
	
	@Override
	public boolean equals(Object v) {
	        boolean retVal = false;

	        if (v instanceof Pair){
	            Pair ptr = (Pair) v;
	            retVal = ( (ptr.u == this.u) && (ptr.v == this.v) ) || (ptr.u == this.v) && (ptr.v == this.u);
	        }

	     return retVal;
	}
	
}