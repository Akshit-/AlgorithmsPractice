

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import CodeeeeeeeeFfffffffkkkkkkk.Node;


public class Graph 
{
	public ArrayList<Node> nodes=new ArrayList<Node>();
	public ArrayList<Node> visited = new ArrayList<>();
	
	int size;

	public void addNode(Node n)
	{
		nodes.add(n);
	}
	
	//This method will be called to make connect two nodes
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
	
	public ArrayList<Node> getUnvisitedAdjacentEdges(Node node){
		ArrayList<Node> ret = new ArrayList<>();
		for(Node n:node.adjacentEdges){
			if(!visited.contains(n))
				ret.add(n);
		}
		return ret;
	}
	
	
	//DFS traversal of a tree is performed by the dfs() function
	private void dfs(Node start)
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
	
	public int dfsUtil(){
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
	private void clearNodes()
	{
		visited.clear();
		
	}
	
	//Utility methods for printing the node's label
	private void printNode(Node n)
	{
		System.out.print(n.id+" ");
	}
	
	public void printAdjacencyList(){
		System.out.println();
		for(Node n:nodes){
			System.out.print(n.id+"->");
			for(Node nbr:n.adjacentEdges){
				
				System.out.print(nbr.id+", ");
				
			}
			System.out.println();
			
		}
		
	}
	
	
	
	

}
