import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class StandingOvation {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        PrintWriter writer=null;
		try {
			writer = new PrintWriter("StandingOvation.txt", "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
		for(int i=1;i<=T;i++){
			
			int len = in.nextInt();
			String pattern = in.next();
			
//			int lastZero=0;
//			for(int k=0;k<pattern.length();k++){
//				
//				if(pattern.charAt(k)==48){
//					lastZero=k;
//				}
//				
//			}
			
			int num = 0;
			int missing = 0;
			
			//int x = Math.min(0+1, len);
			
			for(int j=0;j<len;j++){
				
				
				if(j>num){
					int z = j-num;
					if(missing < z)
						missing = z;
				}
				
				num+= Character.getNumericValue(pattern.charAt(j));;
				
				
			}
			writer.println("Case #"+i+": "+ missing);
			//System.out.println("Case #"+i+": "+ missing );
			
		}
        writer.close();        
		
		
	}

}
