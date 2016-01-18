import java.util.ArrayList;


public class StacksUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[10];
		
		ArrayList<int[]> set = new ArrayList<int[]>();
		
		set.add(a);
		
		set.get(0)[0]=1;

		System.out.println("set of stacks-");;

		
		for(int i=0;i<set.size();i++){
			
			for(int j=0; j<set.get(i).length; j++){
				
				set.get(i)[j] = 10;
				
				System.out.print(set.get(i)[j]+", ");;
			
			}
			
		}
		
		StackFromArray stack = new StackFromArray(9);
		
		stack.push(0, 1);
		stack.push(1, 2);
		stack.push(2, 3);
		
		stack.push(0, 4);
		stack.push(1, 5);
		stack.push(2, 6);
		
		stack.push(0, 7);
		stack.push(1, 8);
		stack.push(2, 9);
		
		stack.push(1, 10);
		
		
		stack.pop(2);
		stack.pop(2);
		stack.pop(2);
		
		stack.pop(0);
		stack.pop(0);
		stack.pop(0);
		stack.pop(0);

		stack.displayArray();

		System.out.println(stack.isEmpty(0));
		System.out.println(stack.isEmpty(1));
		System.out.println(stack.isEmpty(2));


		
		
		AnotherStack.push(2, 4);
		System.out.println(AnotherStack.peek(2));
		AnotherStack.push(0, 3);
		AnotherStack.push(0, 7);
		AnotherStack.push(0, 5);
		
		AnotherStack.displayArray();

		
		
		//System.out.println(AnotherStack.peek(0));
		AnotherStack.pop(2);
		//System.out.println(AnotherStack.peek(0));
		AnotherStack.pop(0);
		//System.out.println(AnotherStack.peek(0));
		
		AnotherStack.push(2, 4);
		AnotherStack.push(0, 5);

		
		System.out.println();
		AnotherStack.displayArray();
		
		
	}
	
	
	public static class StackFromArray{
		
		
		int[] stackTops;
		int array[];
		int stackSize;
		
		public StackFromArray(int size) {
			
			array = new int[size];
			
			stackSize = size/3;
			
			stackTops = new int[stackSize];
			
			for(int i=0; i<stackTops.length; i++){
				stackTops[i] = stackSize * i;
			}
			
		}
		
		public  boolean push(int stackNum, int value){
		
			if(stackTops[stackNum]==(stackNum+1)*stackSize){
				System.out.println("Stack full!!");
				return false;
			}
			
			int currentTop = stackTops[stackNum];
			
			array[currentTop] = value;
			
			stackTops[stackNum] = currentTop + 1;
			
			return true;
		}
	
		public  boolean pop(int stackNum){
			
			int top = stackTops[stackNum];
			
			int boundary = top - stackSize*(stackNum);
			
			if(boundary<=0) {
				System.out.println("Stack "+(stackNum+1)+" is already empty!!");
				return false;
			}
					
			array[top-1] = 0;
				
			stackTops[stackNum] -= 1;

				
			return true;
		}
		
		public boolean isEmpty(int stackNum){
			int top = stackTops[stackNum];
			
			int boundary = top - stackSize*(stackNum);

			if(boundary==0) return true;
			
			return false;
		}
		
		public void displayArray(){
			for(int i=0;i<array.length;i++){
				System.out.print(array[i]+", ");
			}
		}
		
		
	}
	
	public static class AnotherStack{
		
		public static int stackSize = 3;
		public static int indexUsed = 0;
		public static int[] stackPointer = {-1,-1,-1};
		public static StackNode[] buffer = new StackNode[stackSize * 3];
		
		public static int[] freelist = new int[stackSize*3];
		
		public static void push(int stackNum, int value) {
			int lastIndex = stackPointer[stackNum];
			
			
			
			stackPointer[stackNum] = indexUsed;
			indexUsed++;
			buffer[stackPointer[stackNum]]=new StackNode(lastIndex,value);
		}

		public static int pop(int stackNum) {
			int value = buffer[stackPointer[stackNum]].value;
			int lastIndex = stackPointer[stackNum];
			stackPointer[stackNum]	=
				buffer[stackPointer[stackNum]].previous;
			buffer[lastIndex] = null;
			indexUsed--;
			return value;
		}

		public static int peek(int stackNum) {
			return buffer[stackPointer[stackNum]].value;
		}

		public static boolean isEmpty(int stackNum){
			return stackPointer[stackNum] == -1;
		}
		
		public static void displayArray(){
			for(int i=0;i<buffer.length;i++){
				if(buffer[i]!=null)System.out.print(buffer[i].value+", ");
				else
					System.out.print("null, ");
			}
		}
		
		static class StackNode {
			public int previous;
			public int value;
			public StackNode(int p, int v){
				value = v;
				previous = p;
			}
		}
			
		
	}
	
	

}
