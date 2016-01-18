
public class Node {
	
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
	Node(Node n){
		this.data = n.data;
		this.next = null;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Node){
			Node n = (Node)obj;
			if(n.data == data)
				return true;
			else 
				return false;
		}
		
		return false;
		
	}
	
	@Override
	public int hashCode() {
		int result = 0;
	    result = (int)(data/12) + data;
	    return result;
		
	}
	
}
