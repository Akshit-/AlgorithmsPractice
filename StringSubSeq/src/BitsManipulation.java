import java.awt.Cursor;
import java.lang.reflect.Array;
import java.util.Arrays;


public class BitsManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "this is a String";
		
		System.out.print(reverseSentance(str));
	
		
		double[] d = {5.101, 3, 2, 5.10, 6, 1};
		
		//System.out.println("sort:");
		
		for(double da:selectionSortStable(d)){
			//System.out.print(da+", ");
		}
		
		//str.compareToIgnoreCase(str)
		
	}	
	
	public static String reverseSentance(String str) {
	    StringBuilder revStr = new StringBuilder("");
	    int end = str.length(); // substring takes the end index -1
	    int counter = str.length()-1;
	    for (int i = str.length()-1; i >= 0; i--) {     
	        
	    	if (str.charAt(i) == ' ' ){
	                revStr.append(str.substring(i+1, end));
	                revStr.append(" ");
	                
	                end=i;
	        }
	        	       
	    }
	    
	    revStr.append(str.substring(0,end));
	    
	    return new String(revStr);
	}
	
	
	// Sort an array using a stable selection sort. 
	public static double[] selectionSortStable( double[] data ){
		for( int start = 0; start <1 /*< data.length - 1*/; ++start ){ 
			data = insert( data, start, findMinimumIndex( data, start ) );
		} 
		
		return data;
	}
	
	private static int findMinimumIndex( double[] data, int start ) {
		int minPos = start;
		for( int i = start + 1; i < data.length; ++i ){ 
			if( data[i] < data[minPos] ){
				minPos = i; 
			}
		}
		return minPos; 
	}
	
	// Insert the data into the array, shifting the array as necessary. 
	
	private static double[] insert( double[] data, int start, int minIndex ){
		if( minIndex > start ){
			double tmp = data[minIndex];
			System.arraycopy( data, start, data, start +1 , minIndex - start); 
			data[start] = tmp;
		
		}
		return data;
	}
	
	public static String reverseString1(String str)
	{
		char charArray[] = str.toCharArray();
	    for (int i = 0; i <str.length(); i++){
	        if(charArray[i] == ' ')
	        	return reverseString1(str.substring(i + 1)) + str.substring(0, i) + " ";
	    }

	    return str + " ";
	}
	
	
	public static String reverseString(String str, int start, int end){
		
		
		if(start>end)
			return "";
		
		int index = start;
		String temp ="";
		System.out.println(str);
		
		while(index < str.length() && str.charAt(index)!=32){
			
			temp=temp+str.charAt(index);
			index++;
		}
		
		//if(index < str.length()) 
			temp = temp + " ";
		
		System.out.println("now="+str+" temp="+temp);
		
		return reverseString(str, index, str.length()) + temp;
	}

}
