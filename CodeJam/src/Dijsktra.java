import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Dijsktra {
	
	 static PrintWriter writer=null;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int T = in.nextInt();
             
        int[][] myArray=new int[108][108];;
        
        myArray[1][1]= 1;
        myArray[1][(int)'i']= 'i';
        myArray[1][(int)'j']= 'j';
        myArray[1][(int)'k']= 'k';
        
        myArray[(int)'i'][1]= 'i';
        myArray[(int)'j'][1]= 'j';
        myArray[(int)'k'][1]= 'k';
        
        
        myArray[(int)'i'][(int)'i']= -1;
        myArray[(int)'i'][(int)'j']= 'k';
        myArray[(int)'i'][(int)'k']= -'j';
        
        myArray[(int)'j'][(int)'i']= -'k';
        myArray[(int)'j'][(int)'j']= -1;
        myArray[(int)'j'][(int)'k']= 'i';
        
        myArray[(int)'k'][(int)'i']= 'j';
        myArray[(int)'k'][(int)'j']= -'i';
        myArray[(int)'k'][(int)'k']= -1;
        
        
       
		try {
			writer = new PrintWriter("Dijsktra.txt", "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
          
        
		for(int i=1;i<=T;i++){
			int L = in.nextInt();
	        int X = in.nextInt();
	        
	        String temp=in.next();

	        if(L==1){
	        	System.out.println("Case #"+i+": NO");
	        	continue;
	        }
	        String str="";
	        for(int j=0;j<X;j++){
	        	str+=temp;
	        }
	        
	        int len = str.length();
	        if(len<3){
	        	System.out.println("Case #"+i+": NO");
	        	continue;
	        }

	        
	        ArrayList<Integer> arrI=searchForThat(str,'i', myArray);
	        boolean caseFound = false;
	        
			for(int k=0;k<arrI.size();k++){
				
				
				int startJ = arrI.get(k) +1 ;
				
				String nextStrJ = str.substring(startJ);
				
				if(nextStrJ.length()<2)
					continue;
					
				
				ArrayList<Integer> arrJ = searchForThat(nextStrJ, 'j', myArray);
				
				for(int z=0;z<arrJ.size();z++){
					
					int startK = arrJ.get(z) +1 ;
					String nextStrK = nextStrJ.substring(startK);
					
					if(nextStrK.length()<1)
						continue;
					
					ArrayList<Integer> arrK = searchForThat(nextStrK, 'k', myArray);
										
					if(!arrK.isEmpty()){
						caseFound = true;
						break;
					}
						
				}
				
				if(caseFound)
					break;
				
			}
			
			if(!caseFound)
				System.out.println("Case #"+i+": NO");
			else
				System.out.println("Case #"+i+": YES");
	        
		}
		 //writer.close();
		
		
		
	}
	
	
	public static ArrayList<Integer> searchForThat(String str,char c, int[][] myArray){
		
		int len=str.length();
		int i=0;
		char temp=1;
		int sign=0;
		ArrayList<Integer> arr = new ArrayList<>();
		
		switch(c){
			case 'k':
				while(i<len){
					
					char a = str.charAt(i);
					
					//writer.println("a="+a);
					
					if(myArray[temp][a]<0){
						sign++;
						
					}
					//writer.println("temp="+temp);
					
					temp = (char)Math.abs(myArray[temp][a]);
					
					//writer.println("newtemp="+temp);

					i++;
					
				}
				
				if (temp==c && sign%2==0){
					arr.add(i);
				}
				
				break;
			default:
				
				while(i<len){
					
					char a = str.charAt(i);
					
					
					//writer.println("a="+a);
					
					if(myArray[temp][a]<0){
						sign++;
						temp = (char)Math.abs(myArray[temp][a]);
					}else{
						temp = (char)myArray[temp][a];
					}
					//writer.println("temp="+temp);
					
					
					
					
					if (temp==c && sign%2==0){
						arr.add(i);
						
					}
					//writer.println("newtemp="+temp);
		
					i++;
					
				}
		
		}
		
		//System.out.println((int)temp);
		
		
		return arr;
	}
}
