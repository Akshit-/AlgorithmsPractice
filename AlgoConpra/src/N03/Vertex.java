package N03;

import java.util.List;

public class Vertex {
	
	int id;
	
	public Vertex(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public List<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    
}
