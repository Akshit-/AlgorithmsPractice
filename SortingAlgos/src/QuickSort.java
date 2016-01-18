import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.concurrent.Semaphore;


public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		int a[] = new int[4];
		a[0] = 5;
		a[1] = 8;
		a[2] = 12;
		a[3] = 20;
		
		ArrayList<Integer> arr = new ArrayList<Integer>(9);
		arr.ensureCapacity(9);
		arr.add(5);
		arr.add(8);
		arr.add(12);
		arr.add(20);
		
		System.out.println(arr.size());
		
			//{5, 8, 12, 20};
		int b[] = {1, 7, 10, 16, 21};
		
		mergeSortedList(a, b);
		
		ArrayList<String> array = new ArrayList<>();
		array.add("abc");
		array.add("hello");
		array.add("hey");
		array.add("bca");
		array.add("say");
		array.add("elloh");
		array.add("ays");
		array.add("eyh");
		
		
		Collections.sort(array, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				char[] o1a = o1.toCharArray();
				char[] o2a = o2.toCharArray();
				
				Arrays.sort(o1a);
				Arrays.sort(o2a);
				
				o1 = Arrays.toString(o1a);
				o2 = Arrays.toString(o2a);
				
				
				System.out.println("o1="+o1);
				System.out.println("o2="+o2);
				
				int ret = o1.compareToIgnoreCase(o2);
								
				return ret;
			}
		});
		
		
		int matrix[][] = {{1, 2, 3, 5}
						 ,{6, 8, 10, 12}
						 ,{9, 11, 13, 15}
						 };
		System.out.println("len="+matrix.length);

		System.out.println("matriz find="+matrixFind(matrix, 3-1, 0, 17, 3, 4));
		
		
		//System.out.println(array.toString());
		double a1 = 1.56789107;
		double b1 = 1.56789107;
		System.out.println(a1==b1);
		
		BitSet bitsArray = new BitSet();
		
		for(int i=1; i<5; i++) { 
			
			if(i%2==0 ) bitsArray.set(i);
			
		}
		System.out.println(bitsArray+","+ bitsArray.length());
		
		Semaphore aa = new Semaphore(0);
		
		
		 String strLine = "Java Reverse string by word example";
         
         //specify delimiter as " " space
         StringTokenizer st = new StringTokenizer(strLine, " ");
        
         String strReversedLine = "";
        
         while(st.hasMoreTokens())
         {
                 strReversedLine = st.nextToken() + " " + strReversedLine;
         }
        
         System.out.println("Reversed string by word is : " + strReversedLine);
 


		
	}
	
	public static boolean matrixFind(int matrix[][], int i, int j, int num, int N, int M){
		
		System.out.println("i="+i+", j="+j);
		
		
		if(i<0 || j>=M) return false;
		
		System.out.println(matrix[i][j]);

		
		if(matrix[i][j]==num) return true;
		
		if(matrix[i][j]>num)
			return matrixFind(matrix, i-1, j, num, N, M);
		
		
		return matrixFind(matrix, i, j+1, num, N, M);
		
		
	}
	
	public static void mergeSortedList(int[] a, int[] b){
		
		for(int i=0; i<b.length; i++){
			int num = b[i];
			System.out.println("num="+num);

			for (int j = 0; j < a.length; j++) {
				
				if(num<a[j]){
					//a.
					System.out.println("num2="+num);

					a = Arrays.copyOf(a, a.length+1); //truncating a zero at end
					
					System.arraycopy(a, j, a, j+1, a.length-j-1); //shifting from j
					
					a[j] = num;
					
					break;
					
				}
			}
		}
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+", ");
		}
		
	}
	
	
	
	public static void quickSort(int[] array, int start, int end){
		
		if(start<end){
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot-1);
			quickSort(array, pivot+1, end);
		}
		
	}

	


	private static int partition(int[] array, int start, int end) {
		
		
		

		return 0;
	}
	
}
