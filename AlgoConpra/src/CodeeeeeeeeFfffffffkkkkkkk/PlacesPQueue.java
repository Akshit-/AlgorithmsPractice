package CodeeeeeeeeFfffffffkkkkkkk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlacesPQueue {
	List<Node> places = new ArrayList<Node>();
	
	public void insert(Node from, Node next){
		if(!places.contains(next)){
			places.add(next);
		}
	}
	
	public Node  getFirst(){
		Node solution = null;
		
		if(places.isEmpty()){
			solution = places.get(0);
			places.remove(solution);
			
		}
		
		return solution;
	}
}
