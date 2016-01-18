import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class WordNode{
    String word;
    int numSteps;
    WordNode parent;
 
    public WordNode(String word, int numSteps, WordNode parent){
        this.word = word;
        this.numSteps = numSteps;
        this.parent = parent; //to track the parent node
    }
}
 
//Problem description
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//result: shortest path plus its length

public class Solution {
    
	public static WordNode ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1, null));
        
        wordDict.add(endWord);
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)){
                return top;
            }
            
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1, top));
                        //wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return null;
    }
    
    public static void main(String[] args) {
		
    	Set<String> wordDict = new HashSet<>();
    	
    	wordDict.add("hot");
    	wordDict.add("dot");
    	wordDict.add("dog");
    	wordDict.add("lot");
    	wordDict.add("log");
    	//["hot","dot","dog","lot","log"]
    	
    	WordNode end = ladderLength("hit", "cog", wordDict);
    	WordNode temp = end;
    	int count = 0;
    	
    	System.out.print("Path:");
    	while(temp!=null){
    		count++;
    		System.out.print(temp.word+"->");
    		temp = temp.parent;
    		
    	}
    	System.out.println();
    	System.out.print("len:"+count);;
    	
	}
}