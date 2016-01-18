import java.lang.reflect.Array;
import java.util.ArrayList;


public class SubSeq {

	static int[] a;
	
	public static void main(String[] args) {
		
		
		String s1 = "AXY";
		String s2 = "YADXCPY";
		
		 a = new int[s1.length()];
		
		System.out.println("="+s1.substring(0, 0));
		 
		subseq(s1, s2, 0);
		System.out.println("now=");
		for(int i=0;i<a.length;i++){
			System.out.print((char)a[i]+", ");

		}
		
		ArrayList<String> str = permutation("ab");
		
		System.out.println("permutation ="+str.size());

		for(int i=0; i<str.size(); i++){
			
			System.out.println("finally="+str.get(i));
		}
		
		
		char[] inputStringChars = "abcdef\0".toCharArray();
		
		System.out.println("reverse="+reverseString("abcdefg\0"));
		
		//System.out.println(isUniqueChars("abcdefghijkA"));
		
		System.out.println("removeduplicates="+removeDuplicatesEff("No, I am going to Microsoft".toCharArray()));
		
		
		System.out.println("anagram="+anagramCheck("geeksforgeeks", 0, "forgeeksgeeks"));
	
		
		permutation1("AB");
		
	}
	
	public static void permutation1(String str) { 
	    permutation1("", str); 
	}

	private static void permutation1(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation1(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

	
	
	
	public static boolean anagramCheck(String str, int i, String anagram){
		System.out.println("str.lenght-"+str.length()+" and i="+i);
		
		if(str.length()!=anagram.length()) return false;
		
		if(i == str.length()-1 && str.charAt(i) == anagram.charAt(i)) return true;
		
		for(int j=i; j<str.length();j++){
			if(anagram.charAt(i)==str.charAt(j)){
				str = swapCharsAt(str, i, j);
				System.out.println("swap="+str+", at char="+str.charAt(i)+" and i="+i);
				return anagramCheck(str, i+1, anagram);
				//str = swap(str, i, j); 
			}
			
		}
		
		return false;
	}
	
	public static String swapCharsAt(String str, int i, int j){
		
		char[] charArray = str.toCharArray();
		
		char temp = charArray[j];
		charArray[j] = charArray[i];
		charArray[i] = temp;
		
		str = new String(charArray);
		
		return str;
		
	}
	
	
	public static char[] removeDuplicatesEff(char[] str) {
		if (str == null) return null;
		int len = str.length;
		if (len < 2) return str;

		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;

		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
		
		return str;
	}
	
	public static String removeDuplicates(String str){
			
		int checker = 0;
		String duplicated="";
		
		for(int i=0;i<str.length();i++){
			
			int val = str.charAt(i) -'a'; 
			
			if((checker & (1 << val)) == 0){
				System.out.println("here="+str.charAt(i));
				duplicated = duplicated.concat(""+(char)str.charAt(i));
				System.out.println(duplicated);
				checker = checker | (1 << val);
				
			}
			
			
			
		}
		
		return duplicated;
	}

	public static String reverseString(String input){
		
		if(input.length()==1) return "\0";
		
		if(input.length()==2) return input+"\0";
		
		int len = input.length() - 2;
		
		input = swap(input, 0, len);
		
		System.out.println("After swap="+input);
		
		return input.charAt(0) + reverseString(input.substring(1, len)+"\0") + input.charAt(len)+"\0";
		
	}
	
	public static String swap(String str, int i, int j){
		
		char a = str.charAt(i);
		char b = str.charAt(j);
		
		String swapped = b + "" + str.substring(i+1, j) + a + "\0";
		System.out.println("swap="+swapped);
		return swapped;
	}
	
	public static boolean isUniqueChars(String str) {
	    if (str.length() > 256) { // NOTE: Are you sure this isn't 26?
	        return false;
	    }
	    int checker = 0;
	    for (int i = 0; i < str.length(); i++) {
	        int val = str.charAt(i) - 'a';
	        System.out.println("val="+Integer.toBinaryString(val));
	        if ((checker & (1 << val)) > 0) return false;
	        checker |= (1 << val);
	        System.out.println("checker="+Integer.toBinaryString(checker));
	    }
	    return true;
	}
	
	
	public static ArrayList<String> permutation(String str){
		
		int n = str.length() -1;
		
		if(n==0) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(str);
			
			System.out.println("permutation return="+temp);
			return temp;
		}
		
		return mergeString(permutation(str.substring(0, n)), str.charAt(n));
		
	}
	
	public static ArrayList<String> mergeString(ArrayList<String> s1, char s2){
		
		//String[] permu = new String[10];
		
		ArrayList<String> permu = new ArrayList<String>();
		
		for(int i=0; i<s1.size(); i++){
			
			for(int j=0; j<=s1.get(i).length();j++){
				permu.add(insertCharAt(s1.get(i), j, s2));
			}
			
		}
		
		return permu;
	}
	
	public static String insertCharAt(String str, int index, char toAdd){
				
		
		String extra = str.subSequence(0, index) +""+ toAdd + str.subSequence(index, str.length());
		System.out.println("curiois="+str.subSequence(0, index));
		System.out.println("Index="+index+", insertcharat returns="+extra);
		
		return extra;
		
	}
	
	public static void subseq(String s1, String s2, int k){
				
		for(int i=0; i<s2.length(); i++){
			
			if(s1.charAt(0) == s2.charAt(i)){
				if(s1.length()==1){
					a[k] = s1.charAt(0);
					return;
				}
				
				a[k] = s1.charAt(0);
				
				s1 = (String) s1.subSequence(1, s1.length());
				s2 = (String) s2.subSequence(i+1, s2.length());
				System.out.println("s1="+s1 +" at k="+k);
				System.out.println("s2="+s2 +" at k="+k);
				
				subseq(s1, s2, k+1);
				break;
			}
							
			
		}
		
		//System.out.println(a[0] +  a[1] +  a[2]);
				
	}

}
