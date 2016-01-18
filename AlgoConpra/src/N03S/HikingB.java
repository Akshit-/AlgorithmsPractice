package N03S;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HikingB {
	private static Scanner s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t=1;t<=T;t++){
			
			String params = in.readLine();
			
			StringTokenizer posPlsString = new StringTokenizer(params, " ");

			int n = Integer.valueOf(posPlsString.nextElement().toString());
			int m = Integer.valueOf(posPlsString.nextElement().toString());
						
			List<Vertex> listVertices = new ArrayList<Vertex>();
						
			for(int i = 1; i <= n; i++){
				Vertex v = new Vertex(i);
				if(i == 1)
					v.dist = 0;
				
				listVertices.add(v);
			}
			
			
			for(int i=1;i<=m;i++){
				String edges = in.readLine();
				
				StringTokenizer edgesStr = new StringTokenizer(edges, " ");
				
				//NOTE: -1 is due to index in list which always start from 0
				int v1 = Integer.valueOf(edgesStr.nextElement().toString()) -1; 
				int v2 = Integer.valueOf(edgesStr.nextElement().toString()) -1;
				int len = Integer.valueOf(edgesStr.nextElement().toString());
				
				Vertex vFrom = listVertices.get(v1);
				Vertex vTo = listVertices.get(v2);

				WalkingTracks r1 = new WalkingTracks();
				r1.from = vFrom;
				r1.to = vTo;
				r1.length = len;
				vFrom.tracks.add(r1);
				
				WalkingTracks r2 = new WalkingTracks();
				r2.from = vTo;
				r2.to = vFrom;
				r2.length = len;
				vTo.tracks.add(r2);
			}
			
			dijsktra(listVertices);
			Vertex end = listVertices.get(listVertices.size() - 1);

	        out.write("Case #" + t + ": " + end.dist+"\n");
	        if(t!=T){
				in.readLine();
			}
			
		}
				
		out.flush();
	    in.close();
	    out.close();
	}

	private static void dijsktra(List<Vertex> listVertices) {
		Vertex source = listVertices.get(0);
		Queue<Vertex> priorityQueue = new Queue<Vertex>();
		
		priorityQueue.add(source);
		while(!priorityQueue.vertexList.isEmpty()){
			Vertex curr = priorityQueue.poll();
			
			for(WalkingTracks adjTrack : curr.tracks){
				Vertex adj = adjTrack.to;
				int distance = adjTrack.length + curr.dist;
				if(distance < adj.dist){
					priorityQueue.vertexList.remove(adj);
					adj.dist = distance;
					adj.parent = curr;
					priorityQueue.add(adj);
				}
			}
		}
	}
	
	
}

class Queue<T> {
	List<T> vertexList = new ArrayList<T>();

	public void add(T e) {
		if (!vertexList.contains(e)) {
			vertexList.add(e);
		}
	}

	public T poll() {
		T ele = null;
		if(!vertexList.isEmpty()){
			ele = vertexList.get(0);
			vertexList.remove(ele);
		}
		return ele;
	}
}
