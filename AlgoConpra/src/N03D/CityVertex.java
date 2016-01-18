package N03D;

import java.util.HashMap;
import java.util.Map;

public class CityVertex {
	public int id;
	public int distanceFromLea;
	public int distanceFromPeter;
	
	//toCity and distance mapping
	public Map<CityVertex, Integer> roadsFromThisCity = new HashMap<CityVertex, Integer>();

	public CityVertex(int id){
		this.id = id;
	}
	
	public void addRoadTo(CityVertex city, int distance){
		if (!roadsFromThisCity.containsKey(city)) {
			roadsFromThisCity.put(city, distance);
		}
		else{
			if(distance < roadsFromThisCity.get(city)){
				roadsFromThisCity.put(city, distance);
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		CityVertex other = (CityVertex)obj;
		return id == other.id;
	}
}
