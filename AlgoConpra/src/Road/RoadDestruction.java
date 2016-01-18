package Road;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class RoadDestruction {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	    
		for(int t=1;t<=T;t++){
			
			String first = in.readLine();
			
			StringTokenizer params = new StringTokenizer(first, " ");
        	
        	int nCities = Integer.valueOf(params.nextElement().toString());
        	int nRoads = Integer.valueOf(params.nextElement().toString());

			List<Place> cityNodes = new ArrayList<Place>();
			for(int index =0;index < nCities; index++){
				cityNodes.add(new Place(index+1));
			}
			int i = 0;
			
			int totalDistance = 0;
			while(i < nRoads){
				
				String edges = in.readLine();
				
				StringTokenizer edgesStr = new StringTokenizer(edges, " ");
	        	
	        	int a = Integer.valueOf(edgesStr.nextElement().toString());
	        	int b = Integer.valueOf(edgesStr.nextElement().toString());
	        	int w = Integer.valueOf(edgesStr.nextElement().toString())
	        			* Integer.valueOf(edgesStr.nextElement().toString());
	        	
				Place from = cityNodes.get(a -1);
				Place to = cityNodes.get(b -1);
				from.roadsFromTheCity.add(new Connection(to, w));
				to.roadsFromTheCity.add(new Connection(from, w));
				
				totalDistance += w;
				
				i++;
			}
			
			Place currentNode = cityNodes.get(0);
			cityNodes.remove(currentNode);

			
			PlacesPQueue priorityQueue = new PlacesPQueue();
			while(cityNodes.size() > 0){
				for(Connection r : currentNode.roadsFromTheCity){
					if(cityNodes.contains(r.to))
						priorityQueue.insert(currentNode, r.to, r.weight);
				}
				Place next = priorityQueue.getPlaceWithMaxW(); 
				if(next != null){
					cityNodes.remove(next);
					totalDistance -= priorityQueue.getWeightOfAndRemoveIt(next);;
					currentNode = next;
				}
				else{
					break;
				}
			}
			
			if(cityNodes.size() > 0)
				out.write("Case #" + t + ": impossible"+"\n");
			else{
				out.write("Case #" + t + ": " + totalDistance+"\n");
			}
			
			in.readLine();
		}
		out.flush();
	    in.close();
	    out.close();	
	}
}
