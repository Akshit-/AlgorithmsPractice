import java.util.Stack;


public class StackSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack = new Stack<Integer>();
		

		stack.push(3);
		stack.push(1);
		stack.push(5);
		stack.push(2);
		stack.push(4);
		
		
		stack = sortStack(stack);
		
		int i = 0;
		
		for(Integer zz : stack){
			
			System.out.print(zz);
		}

		
	}

	private static Stack<Integer> sortStack(Stack<Integer> stack) {

		Stack<Integer> secondary = new Stack<Integer>();

		
		while (!stack.isEmpty() )
		{
		    // Pop top element from stack S1
			int x =  stack.pop();
		  
		    //Store x into S2 into its position in sorted stack
		    while( (!secondary.isEmpty()) && ( secondary.peek() < x ) )
		    {
		        // Pop all the elements off the S2 that are 
		        // smaller than x and push them on S1
		         stack.push( secondary.pop() );    
		    }
		    
		    System.out.println(x);
		    //push x on S2. Now x will be at its right position in sorted stack. 
		    secondary.push(x);
		    
		    
		}
		
		System.out.println(secondary.toString());
		return secondary;
		
	}
	
	

}
