package D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class DFSApp
   {
   public static void main(String[] args) throws NumberFormatException, IOException
      {
	   
	   
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t=1;t<=T;t++){
			
			String first = in.readLine();
			
			StringTokenizer params = new StringTokenizer(first, " ");
        	
        	int stations = Integer.valueOf(params.nextElement().toString());
        	int connections = Integer.valueOf(params.nextElement().toString());

        	
        	GraphT theGraph = new GraphT(stations);
			
			for(int i=1;i<=stations;i++ ){
				theGraph.addVertex(i);
			}
			
			for(int i=1;i<=connections;i++ ){
				String edgesStr = in.readLine();
				
				StringTokenizer edges = new StringTokenizer(edgesStr, " ");

				int a = Integer.valueOf(edges.nextElement().toString());
				int b = Integer.valueOf(edges.nextElement().toString());
            	
				theGraph.addEdge(a, b);
				
			}
			
			
//			theGraph.addVertex('A');    // 0  (start for dfs)
//			theGraph.addVertex('B');    // 1
//			theGraph.addVertex('C');    // 2
//			theGraph.addVertex('D');    // 3
//			theGraph.addVertex('E');    // 4
		
//			theGraph.addEdge(0, 1);     // AB
//			theGraph.addEdge(1, 2);     // BC
//			theGraph.addEdge(0, 3);     // AD
//			theGraph.addEdge(3, 4);     // DE
		
			System.out.print("Visits: ");
			theGraph.dfs();             // depth-first search
			System.out.println();
		
		}
		
      }  
   
   }  
// end class DFSApp
////////////////////////////////////////////////////////////////