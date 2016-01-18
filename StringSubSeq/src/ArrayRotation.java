
public class ArrayRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[][] = {{1,2,3},{4,5,6}, {7,8,9}};
		
		System.out.println("rotate="+rotateArray(arr, 1));
	}

	
	public static int[][] rotateArray(int[][] arr, int i){
		
		int numOfRotations = arr.length - i;
		
		if(numOfRotations<1) return arr;
		
		
		arr = performRotations(arr, numOfRotations);
		
		return rotateArray(arr, i+2);
		
	}

	private static int[][] performRotations(int[][] arr, int numOfRotations) {
		
		
		return arr;
	
	}
	
	
	public static int[][] transposeMatrix(int[][] arr){
	
		
		//1 2 3     1 4 7            7 4 1
		//4 5 6  =  2 5 8   reverse= 8 5 2
		//7 8 9     3 6 9            9 6 3 
		
		return arr;
	}
	
}
