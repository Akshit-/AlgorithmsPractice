package Road;
import java.util.HashMap;
import java.util.Map;

public class PlacesPQueue {
	Map<Place,Integer> places = new HashMap<Place, Integer>();
	public void insert(Place from, Place next, int weight){
		if(!places.containsKey(next)){
			places.put(next, weight);
		}
		else{
			int currentWeight = places.get(next);
			if(weight > currentWeight){
				increasePriority(next, weight);
			}
		}
	}
	
	public void increasePriority(Place e, int weight){
		places.remove(e);
		places.put(e, weight);
	}
	
	public int getWeightOfAndRemoveIt(Place e){
		int weight = places.get(e);
		places.remove(e);
		return weight;
	}
	
	public Place getPlaceWithMaxW(){
		int maximum = 0;
		Place solution = null;
		for(Place p : places.keySet()){
			int weight = places.get(p);
			if(weight > maximum){
				maximum = weight;
				solution = p;
			}
		}
		return solution;
	}
}
