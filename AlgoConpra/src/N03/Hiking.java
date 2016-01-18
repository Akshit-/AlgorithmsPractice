package N03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Hiking {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t=1;t<=T;t++){
			
			String garbledMsg = in.readLine();
			
			StringTokenizer posPlsString = new StringTokenizer(garbledMsg, " ");

			int n = Integer.valueOf(posPlsString.nextElement().toString());
			int m = Integer.valueOf(posPlsString.nextElement().toString());

//			for(int i=0;i<n;i++){
//				 Vertex v = new Vertex();
//				 
//			}
//			
//			// mark all the vertices 
//	        Vertex A = new Vertex("A");
//	        Vertex B = new Vertex("B");
//	        Vertex D = new Vertex("D");
//	        Vertex F = new Vertex("F");
//	        Vertex K = new Vertex("K");
//	        Vertex J = new Vertex("J");
//	        Vertex M = new Vertex("M");
//	        Vertex O = new Vertex("O");
//	        Vertex P = new Vertex("P");
//	        Vertex R = new Vertex("R");
//	        Vertex Z = new Vertex("Z");
//
//	        // set the edges and weight
//	        A.adjacencies = new Edge[]{ new Edge(M, 8) };
//	        B.adjacencies = new Edge[]{ new Edge(D, 11) };
//	        D.adjacencies = new Edge[]{ new Edge(B, 11) };
//	        F.adjacencies = new Edge[]{ new Edge(K, 23) };
//	        K.adjacencies = new Edge[]{ new Edge(O, 40) };
//	        J.adjacencies = new Edge[]{ new Edge(K, 25) };
//	        M.adjacencies = new Edge[]{ new Edge(R, 8) };
//	        O.adjacencies = new Edge[]{ new Edge(K, 40) };
//	        P.adjacencies = new Edge[]{ new Edge(Z, 18) };
//	        R.adjacencies = new Edge[]{ new Edge(P, 15) };
//	        Z.adjacencies = new Edge[]{ new Edge(P, 18) };
//
//
//	        computePaths(A); // run Dijkstra
//	        System.out.println("Distance to " + Z + ": " + Z.minDistance);
//	        List<Vertex> path = getShortestPathTo(Z);
//	        System.out.println("Path: " + path);
			
			
			
			out.write("Case #"+t+": "+"\n");
			
			
		}
				
		out.flush();
	    in.close();
	    out.close();
		
	}

}
