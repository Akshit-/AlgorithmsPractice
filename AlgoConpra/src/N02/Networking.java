package N02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Networking {

	 
	public static void main(String[] args) throws IOException {
						
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t=1;t<=T;t++){
			
			int n = Integer.valueOf(in.readLine());
			
			int[][] adjacency_matrix = new int[n+1][n+1];
			
			for (int i = 1; i <= n; i++)
            {
				String ele = in.readLine();
            	StringTokenizer edges = new StringTokenizer(ele, " ");
				
            	int j=1;
            	
            	while(edges.hasMoreElements()){
            		
            		int a = Integer.valueOf(edges.nextElement().toString());
            		
            		adjacency_matrix[i][j] = a;
            		
            		j++;
            		
            	}
                
            }
			
			PrimsTraversal prims = new PrimsTraversal(n);
            prims.primsAlgorithm(adjacency_matrix);
            List<List<Integer>> spannedE = prims.sortMST();
			
			out.write("Case #"+t+":"+"\n");
			
			for(List<Integer> l: spannedE){
				int len = l.size();
				for(int z=0; z<len-1;z++){
					out.write(l.get(z)+" ");
				}
				
				out.write(l.get(len-1)+"\n");
			}
			
			if(t!=T){
				out.write("\n");
				in.readLine();
			}
			
		}
				
		out.flush();
	    in.close();
	    out.close();

	}

}

//Source: adapted from http://www.sanfoundry.com/java-program-find-mst-using-prims-algorithm/
class PrimsTraversal{
	private boolean unsettled[];
    private boolean settled[];
    private int numberofvertices;
    private int adjacencyMatrix[][];
    private int key[];
    public static final int INFINITE = 99999;
    private int parent[];
    
    List<List<Integer>> spanningTreeEdges = new ArrayList<List<Integer>>();
 
	PrimsTraversal(int numberofvertices)
    {
        this.numberofvertices = numberofvertices;
        unsettled = new boolean[numberofvertices + 1];
        settled = new boolean[numberofvertices + 1];
        adjacencyMatrix = new int[numberofvertices + 1][numberofvertices + 1];
        key = new int[numberofvertices + 1];
        parent = new int[numberofvertices + 1];
    }
 
    public int getUnsettledCount(boolean unsettled[])
    {
        int count = 0;
        for (int index = 0; index < unsettled.length; index++)
        {
            if (unsettled[index])
            {
                count++;
            }
        }
        return count;
    }
 
    public void primsAlgorithm(int adjacencyMatrix[][])
    {
        int evaluationVertex;
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                this.adjacencyMatrix[source][destination] = adjacencyMatrix[source][destination];
            }
        }
 
        for (int index = 1; index <= numberofvertices; index++)
        {
            key[index] = INFINITE;
        }
        key[1] = 0;
        unsettled[1] = true;
        parent[1] = 1;
 
        while (getUnsettledCount(unsettled) != 0)
        {
            evaluationVertex = getMimumKeyVertexFromUnsettled(unsettled);
            unsettled[evaluationVertex] = false;
            settled[evaluationVertex] = true;
            evaluateNeighbours(evaluationVertex);
        }
        
        for (int vertex = 2; vertex <= numberofvertices; vertex++)
        {
        	List<Integer> list = new ArrayList<Integer>();
        	list.add(parent[vertex]);
        	list.add(vertex);
        	Collections.sort(list);
        	
        	spanningTreeEdges.add(list);
        	
            //System.out.println(parent[vertex] + "\t:\t" + vertex +"\t=\t"+ adjacencyMatrix[parent[vertex]][vertex]);
        }
        
        
    } 
 
    private int getMimumKeyVertexFromUnsettled(boolean[] unsettled2)
    {
        int min = Integer.MAX_VALUE;
        int node = 0;
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
        {
            if (unsettled[vertex] == true && key[vertex] < min)
            {
                node = vertex;
                min = key[vertex];
            }
        }
        return node;
    }
 
    public void evaluateNeighbours(int evaluationVertex)
    {
 
        for (int destinationvertex = 1; destinationvertex <= numberofvertices; destinationvertex++)
        {
            if (settled[destinationvertex] == false)
            {
               if (adjacencyMatrix[evaluationVertex][destinationvertex] < key[destinationvertex])
                {
                    key[destinationvertex] = adjacencyMatrix[evaluationVertex][destinationvertex];
                    parent[destinationvertex] = evaluationVertex;
                }
                unsettled[destinationvertex] = true;
            }
        }
    }
 
    public List<List<Integer>> sortMST(){
    	
    	Collections.sort(spanningTreeEdges, comparator_teams);
    	
    	return spanningTreeEdges;
    }

    public Comparator<List<Integer>> comparator_teams = new Comparator<List<Integer>>() {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
        	
        	int i = o1.get(0);
        	int j = o2.get(0);
        			
        			
        	if(i==j){
        		
        		int ii = o1.get(1);
        		int jj = o2.get(1);
                	
				return ii-jj;
        				
    		}
            return  i - j;
        }

    };

 }
