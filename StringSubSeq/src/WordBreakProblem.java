import java.util.HashSet;
import java.util.Set;


public class WordBreakProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		
		dict.add("he");
		dict.add("e");
		dict.add("h");
		
		
		stringBreak("helloworld", dict);
		
	}
	
	public static boolean stringBreak(String s, Set<String> dict) {
	    return dfs(s, 0, dict);
	}
	public static boolean dfs(String s, int i, Set<String> dict)
	{
	    if(dict.contains(s.substring(i)))
	        return true;
	 
	    for(int j = i; j < s.length(); ++j){
        	System.out.println(s.substring(i, j + 1));
	        if(dict.contains(s.substring(i, j + 1))){
	        	if(dfs(s, j + 1, dict)) {
	        		System.out.println("recurse");
	        		return true;
        		}
	        }
	    }
	 
	    return false;
	}


}
