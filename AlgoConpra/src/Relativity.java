import java.math.BigInteger;
import java.util.Scanner;


public class Relativity {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		BigInteger c = new BigInteger("299792458");
		
		c = c.multiply(c);		
		
		for(int i=1;i<=t;i++){
			
			String m = in.next();
			
			System.out.println("Case #"+i+": "+c.multiply(new BigInteger(m)));
			
		}
		
		in.close();

	}

}
