import java.util.Scanner;


public class HelloWorld {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i=1;i<=t;i++){
			
			String name = in.next();
			
			System.out.println("Case #"+i+": Hello "+name+"!");
			
		}
		
		in.close();

	}

}
