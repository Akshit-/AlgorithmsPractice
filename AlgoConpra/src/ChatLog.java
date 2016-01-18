import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class ChatLog {

	public static void main(String[] args) throws IOException {
						
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t = Integer.valueOf(in.readLine());

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i=1;i<=t;i++){
			
			String garbledMsg = in.readLine();
			
			StringTokenizer posPlsString = new StringTokenizer(garbledMsg, "#");

			int pos = Integer.valueOf(posPlsString.nextElement().toString());
			
			StringBuilder garbled = new StringBuilder(posPlsString.nextElement().toString());
						
			garbled = new StringBuilder(garbled.substring(pos)+garbled.substring(0, pos));
			
			out.write("Case #"+i+": "+garbled+"\n");
			
		}
				
		out.flush();
	    in.close();
	    out.close();

	}

}
