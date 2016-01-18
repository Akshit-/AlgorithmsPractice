package CodeeeeeeeeFfffffffkkkkkkk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	
	public static ArrayList<Node> nodes=new ArrayList<Node>();
	public static ArrayList<Node> visited = new ArrayList<>();
	
	
	
	public void connectNode(Node start,Node end)
	{
		
		start.adjacentEdges.add(end);
		end.adjacentEdges.add(start);
		
	}
	
	public void disconnectNode(Node start,Node end)
	{
		start.adjacentEdges.remove((Object)end);
		end.adjacentEdges.remove((Object)start);
	}
	
	public static ArrayList<Node> getUnvisitedAdjacentEdges(Node node){
		ArrayList<Node> ret = new ArrayList<>();
		for(Node n:node.adjacentEdges){
			if(!visited.contains(n))
				ret.add(n);
		}
		return ret;
	}
	
	
	//DFS traversal of a tree is performed by the dfs() function
	private static void dfs(Node start)
	{
		//DFS uses Stack data structure
		Stack<Node> s=new Stack<Node>();
		s.push(start);
		visited.add(start);
		
		//printNode(start);
		
		while(!s.isEmpty())
		{
			Node curr = s.peek();
			
			ArrayList<Node> adjEdges = getUnvisitedAdjacentEdges(curr);
			
			if(!adjEdges.isEmpty()){
				for(Node neighbor:adjEdges){
					if(!visited.contains(neighbor)){
						visited.add(neighbor);
						
						//printNode(neighbor);
						s.push(neighbor);
					}
				}
			}else{
				s.pop();
			}
		
		}
			
		//clearNodes();
	}
	
	//DFS traversal of a tree is performed by the dfs() function
	private static void dfs2(Node start)
	{
		//DFS uses Stack data structure
		Stack<Node> s=new Stack<Node>();
		s.push(start);
		visited.add(start);
		
		//printNode(start);
		
		while(!s.isEmpty())
		{
			Node curr = s.peek();
			
			ArrayList<Node> adjEdges = getUnvisitedAdjacentEdges(curr);
			
			if(!adjEdges.isEmpty()){
				for(Node neighbor:adjEdges){
					if(!visited.contains(neighbor)){
						visited.add(neighbor);
						
						//printNode(neighbor);
						s.push(neighbor);
					}
				}
			}else{
				s.pop();
			}
		
		}
			
		//clearNodes();
	}
	
	public static int dfsUtil(){
		int nComponents=0;
		
		for(int i=0;i<nodes.size();i++){
			
			if(!visited.contains(nodes.get(i))){
				nComponents++;
				if(nComponents>1)
					break;
				dfs(nodes.get(i));
				
			}
		}
		clearNodes();
//		System.out.println("returning="+nComponents);
		return nComponents;
		
	}
	
	
	//Utility methods for clearing visited property of node
	private static void clearNodes()
	{
		visited.clear();
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	    
		for(int t=1;t<=T;t++){
			
			String first = in.readLine();
			ArrayList<String> list = new ArrayList<>();
			
			StringTokenizer params = new StringTokenizer(first, " ");
        	
        	int stations = Integer.valueOf(params.nextElement().toString());
        	int connections = Integer.valueOf(params.nextElement().toString());
		
        	//Graph g=new Graph();
        	
        	for(int i=1;i<=stations;i++){
        		nodes.add(new Node(i));
        	}
        	
        	for(int i=0;i<connections;i++){
				
				String edges = in.readLine();
				
				StringTokenizer edgesStr = new StringTokenizer(edges, " ");
	        	
	        	int a = Integer.valueOf(edgesStr.nextElement().toString());
	        	int b = Integer.valueOf(edgesStr.nextElement().toString());
	        	
	        	Node from = nodes.get(a-1);
				Node to = nodes.get(b-1);
				
				from.adjacentEdges.add(to);
				to.adjacentEdges.add(from);
	        	
	        	String str = Integer.toString(a)+" "+Integer.toString(b);
	        	list.add(str);
	        	
        	}
        	
        	out.write("Case #" + t + ":");
        	        	
        	String concat ="";
        	
        	for(int z=0;z<list.size();z++){
        		                
        		String str = list.get(z);
        		StringTokenizer edgesStr = new StringTokenizer(str, " ");
        		
        		int a = Integer.valueOf(edgesStr.nextElement().toString());
        		int b = Integer.valueOf(edgesStr.nextElement().toString());
        		
        		Node from = nodes.get(a-1);
				Node to = nodes.get(b-1);
				
				from.adjacentEdges.remove(to);
				to.adjacentEdges.remove(from);
				
				if(from.adjacentEdges.isEmpty() || to.adjacentEdges.isEmpty())
				{
					int temp = z+1;
                	concat = concat+" "+Integer.toString(temp);
				}
				
//                
//                if(dfsUtil()>1){
//                	int temp = z+1;
//                	concat = concat+" "+Integer.toString(temp);
//                }
//                
                from.adjacentEdges.add(to);
				to.adjacentEdges.add(from);
//                
            }
        	
        	if(concat!=""){
	        	out.write(concat);
			}
        	
        	if(t!=T){
        		in.readLine();
        		out.write("\n");
        	}
        	
        	nodes.clear();
        	
		}
		
		out.flush();
	    in.close();
	    out.close();	
	}

}
