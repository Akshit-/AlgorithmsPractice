package CodeeeeeeeeFfffffffkkkkkkk;

import java.util.ArrayList;

public class Node 
{
	public int id;
	public boolean visited=false;
	public ArrayList<Node> adjacentEdges = new ArrayList<>();
	public Node(int id)
	{
		this.id=id;
	}
	
	@Override
	public boolean equals(Object v) {
	        boolean retVal = false;

	        if (v instanceof Node){
	            Node ptr = (Node) v;
	            retVal = ptr.id == this.id;
	        }

	     return retVal;
	}
	   
}
