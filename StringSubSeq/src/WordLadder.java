import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> dict = new HashSet<String>();
		
		
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		//dict.add("dog");
		
		ladderLength("hit", "cog", dict);	
		
		
	}
	
	
    public static int ladderLength(String start, String end, HashSet<String> dict) {
	 
	        if (dict.size() == 0)  
	            return 0; 
	 
	        LinkedList<String> wordQueue = new LinkedList<String>();
	        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
	 
	        wordQueue.add(start);
	        distanceQueue.add(1);
	 
	 
	        while(!wordQueue.isEmpty()){
	            String currWord = wordQueue.pop();
	            Integer currDistance = distanceQueue.pop();
	 
	            if(currWord.equals(end)){
	            	System.out.println(currDistance);
	                return currDistance;
	            }
	 
	            for(int i=0; i<currWord.length(); i++){
	                char[] currCharArr = currWord.toCharArray();
	                for(char c='a'; c<='z'; c++){
	                    currCharArr[i] = c;
	 
	                    String newWord = new String(currCharArr);
	                    if(dict.contains(newWord)){
	                    	System.out.println("newWord="+newWord);
	                        wordQueue.add(newWord);
	                        distanceQueue.add(currDistance+1);
	                        dict.remove(newWord);
	                    }
	                }
	            }
	        }
	        
	        return 0;
	    }
	
}
