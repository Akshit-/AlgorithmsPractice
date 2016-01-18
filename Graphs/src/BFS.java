import java.awt.HeadlessException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class BFS {


	static int rev_endianness(int num) {
		int byte0, byte1, byte2, byte3;
		byte0 = (num & 0x000000FF) >> 0 ; 
		byte1 = (num & 0x0000FF00) >> 8 ;
		byte2 = (num & 0x00FF0000) >> 16 ;
		byte3 = (num & 0xFF000000) >> 24 ;
			return((byte0 << 24) | (byte1 << 16) | (byte2 << 8) | (byte3 << 0));
	}

	
	
	public static void main(String[] args) {
		
		
		String n = "3.72";
		String bs = printBinary(n);
		System.out.println(bs);
		
		
		// TODO Auto-generated method stub
		List<String> newDown = sierpinski(4);
		int i = 0;
		for (String x : newDown){
            System.out.println(i+x);
            i++;
		}
		
		LinkedList list = new LinkedList();
		
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();	
		
		int z = 1;
		
		int zeroes = 0;
		int value = 1;
		
		int number = 8;
		
		for(int y =0; y < Integer.SIZE; y++){
			
			if((number&value) > 0)
				zeroes+=1;
			
			value <<= 1;
 			
		}
		
		System.out.println("num of zeroes="+zeroes+" Integer.SIZE="+Integer.SIZE);
		char c = (char) z;

		System.out.println("c="+(int)c);
		int a=0;
		
		for( int k=0;k<6;k++)

		{

		a= a<<1;

		a=a|1;

		}

		
		
		
		if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
			  System.out.println("Big-endian");
			} else {
			  System.out.println("Little-endian");
			}

		
		
	      // add some elements
	      //list.add("Hello");
	      //list.add(2);	
	      
		list.add(null);
		list.add(1);
		
	     System.out.println(list);
	      //list.
	      
		
	}
	
    public static List<String> sierpinski(int n)
    {
        List<String> down = Arrays.asList("*");
        String space = " ";
        for (int i = 0; i < 2; i++) {
            List<String> newDown = new ArrayList<String>();
            for (String x : down)
                newDown.add(space + x + space);
            for (String x : down)
                newDown.add(x + " " + x);
            int j=0;
            for (String x : newDown){
                System.out.println(j+x);
                j++;
    		}
            
            
            down = newDown;
            space += space;
        }
        return down;
    }

    public static String printBinary(String str){
		int intPart = Integer.parseInt(str.substring(0,str.indexOf('.')));
		double decPart = Double.parseDouble(str.substring(str.indexOf('.')));
		
		// transform int part to binary
		String int_string = "";
		while(intPart>0){
			int r = intPart%2;
			intPart>>=1;
			int_string = r+int_string;
		}
		
		// transform dec part to binary
		StringBuffer dec_string=new StringBuffer();
		while(decPart>0){
			System.out.println("here="+dec_string);
			if(dec_string.length()>32) return "ERROR!";
			
			if(decPart == 1){// exit
				dec_string.append((int)decPart);
				break;
			}
			
			double r = decPart*2;
			if(r>=1){
				dec_string.append("1");
				decPart = r-1;
			}
			else{
				dec_string.append("0");
				decPart = r;
			}
		}
		return (int_string + "." + dec_string);
	}
	

}
