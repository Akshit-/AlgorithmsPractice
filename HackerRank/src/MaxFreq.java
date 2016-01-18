
public class MaxFreq {
		
	static int array[] = {1,1,1,1,4,4,4,4,8,8,8};
	
	public static void main(String[] args){
		
		int mode = array[0];
	    int currentFreq = 1;
	    int prevFreq = 1;
	    
	    for(int i=1;i<array.length;i++){
	        if(array[i-1] == array[i]){
	            currentFreq++;
	        }
	        else {
	            currentFreq = 1;
	        }
	        if(currentFreq >= prevFreq){
	            mode = array[i];
	            prevFreq = currentFreq;
	        }
	    }
		System.out.println("mode2: "+mode);
		
	}
	

	
}
