
public class EditDistance {
    public static int computeEditDistance(String s1, String s2)
    {
	int n = s1.length() + 1;
	int m = s2.length() + 1;
	int [][] e = new int[n][m];
	for(int i=0; i<n; i++)
	    {
		e[i][0] = i;
	    }
	for(int j=0; j<m; j++)
	    {
		e[0][j]=j;
	    }
	for( int i=1; i<n; i++){
	    for(int j=1; j<m; j++)
		{
		    e[i][j] = computeMin( 1 + e[i-1][j] , 1 + e[i][j-1],
					  e[i-1][j-1] + (s1.charAt(i-1) == s2.charAt(j-1)? 0:1) );
			}
	}
	return e[n-1][m-1];   
    }

    public static int computeMin(int a, int b, int c)
    {
	return Math.min(Math.min(a,b),c);
    }
    
    public static void main(String[] args)
    {
	// Test cases1
	String s1 = "cats";
	String s2 = "cat";
	int result = computeEditDistance(s1,s2);
	System.out.println("Edit Distance:" + result);

	// Test Case2
	s1 = "cats1";
	s2 = "cats1";
	result = computeEditDistance(s1,s2);
	System.out.println("Edit Distance:" + result);

	//Test Case3
	s1 = "cat";
	s2 = "networks";
	result = computeEditDistance(s1,s2);
	System.out.println("Edit Distance:" + result);

	
	
	
	System.out.println("0"+Integer.toBinaryString(0x55555555)+"\n"+Integer.toBinaryString(0xaaaaaaaa));

	
    }


}
