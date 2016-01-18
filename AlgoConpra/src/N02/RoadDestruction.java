package N02;

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
        	
        	int num_cities = Integer.valueOf(params.nextElement().toString());
        	int num_roads = Integer.valueOf(params.nextElement().toString());
        	
        	//int[][] adjacency_matrix = new int[n+1][n+1];
			
        	ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        	
			for (int i = 1; i <= num_roads; i++)
            {
				String ele = in.readLine();
            	StringTokenizer edges = new StringTokenizer(ele, " ");
				
            	int j=1;
            	
        		int a = Integer.valueOf(edges.nextElement().toString());
        		int b = Integer.valueOf(edges.nextElement().toString());
        		int weight = Integer.valueOf(edges.nextElement().toString())
        				     * Integer.valueOf(edges.nextElement().toString());
        		
            		
        		//adjacency_matrix[i][j] = a;
            		
        		
            	
                
            }
        	
        	
			out.write("Case #"+t+":"+"\n");
			
		}
		
		out.flush();
	    in.close();
	    out.close();

	}

}
