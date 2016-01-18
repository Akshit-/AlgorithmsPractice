package N02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class CopyOfPizzaToppings {
	
	public static ArrayList<Integer> visited;
	public static int[][] graph;
	
	public static ArrayList<ArrayList<Integer>> adjacencyList;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t=1;t<=T;t++){
			
			String ele = in.readLine();
			
			StringTokenizer posPlsString = new StringTokenizer(ele, " ");

			int n = Integer.valueOf(posPlsString.nextElement().toString());
			int m = Integer.valueOf(posPlsString.nextElement().toString());
			
			Graph3 g = new Graph3(n);
			
			for(int i=0;i<m;i++){
				
				String edges = in.readLine();
				
				StringTokenizer edgesStr = new StringTokenizer(edges, " ");
	        	
	        	int a = Integer.valueOf(edgesStr.nextElement().toString());
	        	int b = Integer.valueOf(edgesStr.nextElement().toString());
	        	
	        	a = a-1;
	        	b = b-1;
	        	
	        	//pairs.add(new Pair(a, b));
	        	
	        	g.addEdge(a,b);
	        	g.addEdge(b,a);
	        	
        	}
			ArrayList< Integer> list = new ArrayList<>();
			for(int i=0;i<n;i++){
				list = new ArrayList<>();
				int lim = n-i-1;
				
				for(int j=i;j<n;j++){
					
					if(g.adj[j].size()>=lim){
						//g.adj[j].clear();
						list.add(j);
					}
					
				}
				
				if(list.isEmpty())
					break;
				
				
			}
			
			String result = "yes";
			
			if(n>2){
				
				result = list.isEmpty()?"yes":"no";
				
			}
			out.write("Case #"+t+": "+result+"\n");
			if(t!=T)
				in.readLine();
		}
				
		out.flush();
	    in.close();
	    out.close();

	}
	
	
}

 class Graph3 {
	 
	int V;
	ArrayList<Integer> adj[];
 
	public Graph3(int V)
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
 
class Pair2 {
	int u;
	int v;
	public Pair2(int u, int v)
	{
		this.u = u;
		this.v = v;
	}
	public String toString()
	{
		return (u+1) + " " + (v+1);
	}
}
