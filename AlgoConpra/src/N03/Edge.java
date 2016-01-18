package N03;

public class Edge {
	
	private final Vertex destination;
	private final int weight; 
	private final Vertex source;

	  
//	public Edge(Vertex destination, double weight) {
//	    this.destination = destination;
//	    this.weight = weight;
//	}

	public Edge(Vertex source, Vertex destination, int weight) {
		this.source = source;
	    this.destination = destination;
	    this.weight = weight;
	}
	
	public Vertex getDestination() {
		return destination;
	}

	  public int getWeight() {
	    return weight;
	  }
	  
	  public Vertex getSource() {
		  return source;
	  }
	 
		  @Override
		  public String toString() {
		    return source + " " + destination;
		  }

}
