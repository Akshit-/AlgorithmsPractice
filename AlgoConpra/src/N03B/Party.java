package N03B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import N03B.Task;

public class Party {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t=1;t<=T;t++){
			
			String params = in.readLine();
			
			StringTokenizer posPlsString = new StringTokenizer(params, " ");

			int n = Integer.valueOf(posPlsString.nextElement().toString());
			
			List<Task> listTasks = new ArrayList<Task>();
			List<Task> tempQ = new ArrayList<Task>();

			for(int i = 1; i <= n; i++){
				//initialize list of tasks
				listTasks.add(new Task(i));
			}
			
			for(int i=1;i<=n;i++){
				String taskParams = in.readLine();
				
				StringTokenizer taskToken = new StringTokenizer(taskParams, " ");
				
				int timeUnit = Integer.valueOf(taskToken.nextElement().toString()); 
				int nSuccessors = Integer.valueOf(taskToken.nextElement().toString());
				
				Task taskCurr = listTasks.get(i-1);
				taskCurr.timeUnits = timeUnit;
				
				for(int j=0;j<nSuccessors;j++){
					
					int successorID = Integer.valueOf(taskToken.nextElement().toString());
					Task succTask = listTasks.get(successorID-1);

					taskCurr.successors.add(succTask);
					succTask.parents.add(taskCurr);
					
				}
				if(nSuccessors == 0){
					//WE START from end and traverse back using parents
					tempQ.add(taskCurr);
				}
				
			}
			
			int total = 0;
			while(tempQ.size() > 0){
				int min = 0;

				for(Task p : tempQ){
					if( min == 0 || p.timeUnits < min){
						min = p.timeUnits;
					}
				}
//				System.out.println("yaha1="+min);
				int count = tempQ.size() -1;
				for(int i = 0; i< tempQ.size(); i++){
					Task curr = tempQ.get(i);
					curr.executeTask(min, tempQ);
					if(curr.taskDone){
						tempQ.remove(curr);
						i-=1;
						count--;
					}
					if(i == count)
						break;
				}
//				System.out.println("yaha2="+min);
				total += min;
			}
			
			out.write("Case #" + t + ": " + total+"\n");
	        if(t!=T){
				in.readLine();
			}
			
		}
				
		out.flush();
	    in.close();
	    out.close();
		
	}

}