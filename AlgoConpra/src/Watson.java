import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;


public class Watson {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t = Integer.valueOf(in.readLine());
	    
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
				
		for(int i=1;i<=t;i++){
			
			String str = in.readLine();
			str = str.replaceAll("plus", " + ")
				.replaceAll("minus", " - ")
				.replaceAll("times", " * ")
				.replaceAll("tothepowerof", " ^ ");
			
			String[] exp = str.split(" ");

			Stack<String> operations = new Stack<String>();
			Stack<Integer> values = new Stack<Integer>();
			
			for(int j = 0; j < exp.length; j++) {
                String s = exp[j];
                                
                if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("^")){
                	operations.add(s);
                }else{
                	values.add(Integer.parseInt(s));
                	
                	if(!operations.isEmpty()){
                		String operation = operations.pop();
                		
                		int x = values.pop();
            			int y = values.pop();
            			
                		if(operation.equals("+"))
                			values.push(x+y);
                		
                		if(operation.equals("-"))
                			values.push(y-x);
            				
                		if(operation.equals("*"))
                			values.push(x*y);
                		
                		if(operation.equals("^"))
                			values.push((int) Math.pow(y, x));
                		
                	}
                } 
                
			}
			
			out.write("Case #"+i+": "+values.pop()+"\n");			
			
			
		}
		
		out.flush();
	    in.close();
	    out.close();	
	    
	}


}
