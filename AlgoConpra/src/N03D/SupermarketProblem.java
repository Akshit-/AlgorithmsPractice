package N03D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class SupermarketProblem {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t=1;t<=T;t++){
			
			String params = in.readLine();
			
			StringTokenizer posPlsString = new StringTokenizer(params, " ");
			
			int n = Integer.valueOf(posPlsString.nextElement().toString());
			
			int mRoads = Integer.valueOf(posPlsString.nextElement().toString());
			int nSuper = Integer.valueOf(posPlsString.nextElement().toString());
			
			int leaC = Integer.valueOf(posPlsString.nextElement().toString()) -1;
			int peterC =Integer.valueOf(posPlsString.nextElement().toString()) -1;
			
			List<CityVertex> allCities = new ArrayList<CityVertex>();
			Map<Integer, Integer> supermarket_CityAndTimeMap = new HashMap<Integer, Integer>();

			for(int i = 1; i <= n; i++){
				CityVertex c = new CityVertex(i);
				c.distanceFromLea = Integer.MAX_VALUE;
				c.distanceFromPeter = Integer.MAX_VALUE;
				allCities.add(c);
			}
			// input for roads
			for(int i = 1; i <= mRoads; i++){
				String roadsParam = in.readLine();
				StringTokenizer roadsParamStr = new StringTokenizer(roadsParam, " ");
				
				int fromCity = Integer.valueOf(roadsParamStr.nextElement().toString())-1;
				int toCity = Integer.valueOf(roadsParamStr.nextElement().toString())-1;

				int dist = Integer.valueOf(roadsParamStr.nextElement().toString());

				CityVertex cityFrom = allCities.get(fromCity);
				CityVertex cityTo = allCities.get(toCity);
				//undirected case 
				cityFrom.addRoadTo(cityTo, dist);
				cityTo.addRoadTo(cityFrom, dist);
			}
			
			//input for supermarket distances
			for(int i =1; i<= nSuper; i++){
				String marketParam = in.readLine();
				StringTokenizer marketParamStr = new StringTokenizer(marketParam, " ");
				
				int city = Integer.valueOf(marketParamStr.nextElement().toString());
				int shoppingTime = Integer.valueOf(marketParamStr.nextElement().toString());
				
				if (!supermarket_CityAndTimeMap.containsKey(city)) {
					supermarket_CityAndTimeMap.put(city, shoppingTime);
				}
				else{
					//choose best shop having minimal shoppingtime
					if(shoppingTime < supermarket_CityAndTimeMap.get(city)){
						supermarket_CityAndTimeMap.put(city, shoppingTime);
					}
				}
			}
			
			CityVertex startCity = allCities.get(leaC);
			startCity.distanceFromLea = 0;
			List<CityVertex> queue= new ArrayList<CityVertex>();
			queue.add(startCity);
			
			// moving from leaCity/startCity : calc dist from lea to all others
			while(!queue.isEmpty()){
				CityVertex from = queue.get(0);
				queue.remove(from);
				for(CityVertex to : from.roadsFromThisCity.keySet()){
					Integer dist = from.roadsFromThisCity.get(to);
					int distance = dist + from.distanceFromLea;
					if(distance < to.distanceFromLea){
						queue.remove(to);
						to.distanceFromLea = distance;
						queue.add(to);
					}
				}
			}

			
			// Similarly for Peters: calc dist from Peter city to all others
			CityVertex targetCity = allCities.get(peterC);
			targetCity.distanceFromPeter = 0;
			queue.add(targetCity);
			while(!queue.isEmpty()){
				CityVertex from = queue.get(0);
				queue.remove(from);
				for(CityVertex to : from.roadsFromThisCity.keySet()){
					Integer dist = from.roadsFromThisCity.get(to);
					int distance = dist + from.distanceFromPeter;
					if(distance < to.distanceFromPeter){
						queue.remove(to);
						to.distanceFromPeter = distance;
						queue.add(to);
					}
				}
			}
			int totalTime = Integer.MAX_VALUE;
			
			//now combining shop time plus shortest path time b/w cities
			for(CityVertex city : allCities){ 
				if(supermarket_CityAndTimeMap.containsKey(city.id) 
						&& city.distanceFromLea != Integer.MAX_VALUE 
						&& city.distanceFromPeter != Integer.MAX_VALUE){
					
					int shopTime = supermarket_CityAndTimeMap.get(city.id);

					int distNew = shopTime + city.distanceFromLea + city.distanceFromPeter;
					if(totalTime>distNew)
						totalTime = distNew;
					
					
				}
			}
			if(totalTime == Integer.MAX_VALUE)
				out.write("Case #" + t + ": impossible"+"\n");
			else{

				String minutes = Integer.toString(totalTime % 60);
			    minutes = minutes.length() == 1 ? "0" + minutes : minutes;
			    String result = (totalTime / 60) + ":" + minutes;
				
				//int hours = totalTime / 60; //since both are ints, you get an int
				//int minutes = totalTime % 60;
		        out.write("Case #" + t + ": "+result+"\n");
			}
			
	        if(t!=T){
				in.readLine();
			}
			
		}
				
		out.flush();
	    in.close();
	    out.close();
	}
}
