package N03B;

import java.util.ArrayList;
import java.util.List;

public class Task {
	
	int id;
	int timeUnits;
	List<Task> successors;
	List<Task> parents;
	boolean taskDone;
	
	public Task(int id) {
		this.id = id;
		successors = new ArrayList<>();
		parents = new ArrayList<>();
		taskDone = false;
		this.timeUnits = 0;
	}
	
	public void executeTask(int tUnit, List<Task> q){
		if((timeUnits-tUnit) == 0){
			timeUnits = 0;
			taskDone=true;
			for(Task t : parents){
				if(t.checkIfAllOutgoingCompleted()){
					q.add(t);
				}
			}
		}
		else{
//			System.out.println("yaha3="+tUnit);
			timeUnits -= tUnit;
		}
	}
	
	public boolean checkIfAllOutgoingCompleted(){
		boolean checkSuccessorsFinish = true;
		for (Task t : successors){
			if(!t.taskDone){
				checkSuccessorsFinish = false;
			}
		}
		return checkSuccessorsFinish;
	}
		
	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Task)){
    		return false;
    	}
		Task other = (Task)obj;
    	return id == other.id;
	}

}
