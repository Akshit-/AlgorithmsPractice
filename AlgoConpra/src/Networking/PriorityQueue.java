package Networking;
import java.util.HashMap;
import java.util.Map;

public class PriorityQueue {
	Map<Person,Integer> nodes = new HashMap<Person, Integer>();
	
	public void insert(Person from, Person to, int weight){
		if(!nodes.containsKey(to)){
			to.from = from;
			nodes.put(to, weight);
		}
		else{
			int currentWeight = nodes.get(to);
			if(weight < currentWeight){
				to.from = from;
				decreasePriority(to, weight);
			}
		}
	}
	
	public void decreasePriority(Person e, int weight){
		nodes.remove(e);
		nodes.put(e, weight);
	}
	
	public Person getMin(){
		int minimum = 0;
		Person solution = null;
		for(Person p : nodes.keySet()){
			int weight = nodes.get(p);
			if(weight < minimum || minimum == 0){
				minimum = weight;
				solution = p;
			}
			else if(weight == minimum){
				solution = solution.compareTo(p);
			}
		}
		if(solution != null){
			nodes.remove(solution);
		}
		return solution;
	}
}
