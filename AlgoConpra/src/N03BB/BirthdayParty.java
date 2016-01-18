package N03BB;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BirthdayParty {
	private static Scanner s;

	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int numberOfCases = s.nextInt();
		int currentCase = 1;
		while (currentCase <= numberOfCases) {
			int numberOfTasks = s.nextInt();
			numberOfTasks = numberOfTasks < 0 ? 0 : numberOfTasks;

			List<Task> allTasks = new ArrayList<Task>();
			for(int i = 1; i <= numberOfTasks; i++){
				Task t = new Task(i);
				allTasks.add(t);
			}
			List<Task> onQueue = new ArrayList<Task>();
			for(int i = 1; i <= numberOfTasks; i++){
				int time = s.nextInt();
				Task h = allTasks.get(i-1);
				h.timeUnits = time;
				int nOutgoing = s.nextInt();
				for(int j = 0; j< nOutgoing; j++){
					int taskID = s.nextInt();
					Task successor = allTasks.get(taskID-1);
					h.outgoingTasks.add(successor);
					successor.inComingTasks.add(h);
				}
				if(nOutgoing == 0){
					onQueue.add(h);
				}
			}
			int time = 0;
			while(onQueue.size() > 0){
				int minimum = 0;
				System.out.println("here="+Arrays.toString(onQueue.toArray()));
				for(Task p : onQueue){
					if(p.timeUnits < minimum || minimum == 0){
						minimum = p.timeUnits;
					}
				}
				int number = onQueue.size() -1;
				for(int i = 0; i< onQueue.size(); i++){
					Task p = onQueue.get(i);
					p.executeTask(minimum, onQueue);
					if(p.taskDone){
						onQueue.remove(i);
						i--;
						number--;
					}
					if(i == number)
						break;
				}
				time += minimum;
			}
			System.out.println("Case #" + currentCase + ": " + time);
			currentCase++;
		}
	}
}
