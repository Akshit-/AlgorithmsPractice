import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;


public class Chess {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t = Integer.valueOf(in.readLine());
	    
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		
		for(int i=1;i<=t;i++){
			
			int numSchool = Integer.valueOf(in.readLine());

			List<List<Integer>> teams = new ArrayList<List<Integer>>();
			
			for(int j=1;j<=numSchool;j++){
				
				List<Integer> teamSkills = new Vector<>(5);
				
				StringTokenizer posPlsString = new StringTokenizer(in.readLine(), " ");
				
				
				while (posPlsString.hasMoreElements()) {
					
					teamSkills.add(Integer.valueOf(posPlsString.nextElement().toString()));
				}
					
				Collections.sort(teamSkills, Collections.reverseOrder());
				
				teams.add(teamSkills);
				
			}
			
			Collections.sort(teams,comparator_teams);
			
			out.write("Case #"+i+":\n");
			for(List<Integer> l: teams){
				int len = l.size();
				for(int z=0; z<len-1;z++){
					out.write(l.get(z)+" ");
				}
				out.write(l.get(len-1)+"\n");
			}
			
			in.readLine();
		}
		
		out.flush();
	    in.close();
	    out.close();
	}
	
	static Comparator<List<Integer>> comparator_teams = new Comparator<List<Integer>>() {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
        	
        	int i = o1.get(0);
        	int j = o2.get(0);
        			
        			
        	if(j==i){
        		
        		for(int z=1;z<5;z++){
        			int ii = o1.get(z);
                	int jj = o2.get(z);
                	
        			if(ii==jj){
        				continue;
        			}else{
        				return jj-ii;
        			}
        				
        		}
        		
        	}
            return  j - i;
        }

    };

}
