
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(palindromeString("ahedha"));
	
	}
	
	public static boolean palindromeString(String str){
		
		
		if(str.length()==1)
			return true;
		
		if(str.length()==2 && str.charAt(0) == str.charAt(1))
			return true;
		
		int end = str.length() - 1;
			
		if(str.charAt(0) == str.charAt(end)){
			System.out.println(str.substring(1, end));
			return palindromeString(str.substring(1, end));
			
		}
				
		String s1 = "hell";
		
		String s2 = "hello";
		
		
		
		
		return false;
		
	}

}
