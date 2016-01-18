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

public class PizzaToppings {
	
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
			
			Graph g = new Graph(n);
			
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
			
			adjacencyList = new ArrayList<ArrayList<Integer>>();
			
			graph = new int[n+1][n+1];
			visited = new ArrayList<>();
			
			
//			for(int i=1; i<=n;i++){
//				ArrayList<Integer> l = new ArrayList<Integer>(n+1);
//				for(int j=1; j<=n;j++){
//					graph[i][j]=1;
//				}
//				//visited[i] = 0;
//				//adjacencyList.add(l);
//			}
			
			for(int i=1; i<=n;i++){
				ArrayList<Integer> l = new ArrayList<Integer>(n+1);
				for(int j=1; j<=n;j++){
					graph[i][j]=1;
				}
				//visited[i] = 0;
				adjacencyList.add(l);
			}
			
			
			
			for(int i=0; i<m;i++){
				String ele1 = in.readLine();
				
				StringTokenizer posPlsString1 = new StringTokenizer(ele1, " ");
				
				int a = Integer.valueOf(posPlsString1.nextElement().toString());
				int b = Integer.valueOf(posPlsString1.nextElement().toString());
				
				graph[a][b]=0;
				graph[b][a]=0;
				
				adjacencyList.get(a-1).remove((Object)b);
				adjacencyList.get(b-1).remove((Object)a);
			}
			
			String result ="yes";
			
			if(n>2){
				//visited = dfs(adjacencyList,1,visited);
				dfs(1);
				
				result = visited.size()==n?"yes":"no";
				
			}
			out.write("Case #"+t+": "+result+"\n");
			if(t!=T)
				in.readLine();
		}
				
		out.flush();
	    in.close();
	    out.close();

	}
	
	
	public static void dfs(int u){
		
		Stack<Integer> stack = new Stack<>();
		stack.push(u);
		
		visited.add(u);
		
		while(!stack.isEmpty()){
			
			int top = stack.pop();
			int len = graph.length;
			
			for(int i=1;i<len;i++){
				
				if(graph[top][i]==1 && !visited.contains(i)){
					stack.push(i);
					visited.add(i);
				}
			}
			
			
		}
		
	}
	
	
}

 class Graph {
	 
	int V;
	ArrayList<Integer> adj[];
 
	public Graph(int V)
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
		return (u+1) + " " + (v+1);
	}
}
