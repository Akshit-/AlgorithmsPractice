package N03S;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	public int ID;
	public Vertex parent;
	public List<WalkingTracks> tracks;
	public int dist;
	public Vertex(int ID){
		this.ID = ID;
		this.tracks = new ArrayList<WalkingTracks>();
		this.dist = Integer.MAX_VALUE;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Vertex)){
    		return false;
    	}
		Vertex other = (Vertex)obj;
    	return ID == other.ID;
	}
}
