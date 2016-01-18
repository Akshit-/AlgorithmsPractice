package N03D;

public class RoadEdge {
	CityVertex cityFrom;
	CityVertex cityTo;
	int distance;
		
	public RoadEdge(CityVertex cityFrom, CityVertex cityTo, int dist){
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.distance = dist;
	}	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof RoadEdge)){
    		return false;
    	}
		RoadEdge other = (RoadEdge)obj;
    	return cityFrom.equals(other.cityFrom) 
    			&& cityTo.equals(other.cityTo) 
    			&& distance == other.distance;
	}
}
