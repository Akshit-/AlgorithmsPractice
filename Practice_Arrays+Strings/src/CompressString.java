import java.awt.color.CMMException;


public class CompressString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String originalStr = "a";
		System.out.println("Compressed String:"+compress_string(originalStr));
		
		String str = "hello I am akshit!!!      ";
		System.out.println("%20 orig str="+str);
		System.out.println("%20 sol str="+new String(replacePercent20OnSpace(str.toCharArray())));
	}

	
	//Mistake: missed appending last char after end of loop
	private static String compress_string(String originalStr) {
		
		int len = originalStr.length();
		if(len>1){
			StringBuffer compressed = new StringBuffer();
			char current_char = originalStr.charAt(0);
			int count = 1;
			
			for(int i = 1; i < len; i++){
				
				if(current_char==originalStr.charAt(i))
					count++;
				else{
					compressed.append((char)current_char).append(count);
					current_char = originalStr.charAt(i);
					count = 1;
				}
				
			}
			compressed.append((char)current_char).append(count);
			System.out.println("comp="+compressed);
			if(compressed.length() > len)
				return originalStr;
			
			return new String(compressed);
		}
		
		return originalStr;
	}
	
	
	private static char[] replacePercent20OnSpace(char[] arr){
		
		int start = arr.length-1;
		int replace = start;
		
		if(start<0)
			return arr;
		
		while(arr[start]==' ')
			start--;
		
		//if no extra spaces at the end
		if(start==replace)
			return arr;
		
		
		for(int i = start ; i>=1; i--){
			
			if(arr[i]!=' '){
				//character case
				arr[replace--] = arr[i];
				
			}else{
				//space case: copy %20 frm replace to replace-3
				arr[replace--] = '0';
				arr[replace--] = '2';
				arr[replace--] = '%';
			}
		}
		
		return arr;
	}
	

}
