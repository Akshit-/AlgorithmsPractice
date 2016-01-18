import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
static int lonelyinteger(int[] a) {
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0;i<a.length;i++){
    	
        if(map.containsKey(a[i])){
        	map.put(a[i],map.get(a[i])+1);
         }else{
          	map.put(a[i],1);
        }
    }
     
    return (int) getKeyFromValue(map, 1);

}

public static Object getKeyFromValue(HashMap hm, Object value) {
    for (Object o : hm.keySet()) {
      if (hm.get(o).equals(value)) {
        return o;
      }
    }
    return null;
  }
    
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = lonelyinteger(_a);
        
        System.out.println(res);
        
    }
}

