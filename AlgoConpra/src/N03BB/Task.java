package N03BB;

import java.util.ArrayList;
import java.util.List;

public class Task {
	public int id;
	public int timeUnits;
	public boolean taskDone;
	public List<Task> inComingTasks = new ArrayList<Task>();
	public List<Task> outgoingTasks = new ArrayList<Task>();

	
	public Task(int id){
		this.id = id;
		this.taskDone = false;
		this.timeUnits = 0;
	}
	
	public boolean checkIfAllOutgoingCompleted(){
		boolean finish = true;
		for (Task t : outgoingTasks){
			if(!t.taskDone){
				finish = false;
			}
		}
		return finish;
	}
	
	public void executeTask(int tUnit, List<Task> q){
		if((timeUnits-tUnit) == 0){
			timeUnits = 0;
			taskDone=true;
			for(Task t : inComingTasks){
				if(t.checkIfAllOutgoingCompleted()){
					q.add(t);
				}
			}
		}
		else{
			this.timeUnits = this.timeUnits - tUnit;
		}
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
