package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumber2 {

	//It's figuring out if n is either 0 or an exact power of two
	public static List<String> findStrobogrammatic(int n) {
		List<String> cur, ans;
		
		System.out.println("n: "+n+" (n & 1): "+(n & 1));
		
		if(n == 0 || n % 2 == 0)  
	    	ans = new ArrayList<String>(Arrays.asList(""));
	    else 
	    	ans = new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        if(n < 2)
        	return ans;
        
        for( ;n>1; n=n-2) {
            cur = ans;
            ans = new ArrayList<String>();
            
            System.out.println("cur: "+cur);
            
            for(String i: cur) {
               
            	if(n > 3) 
                	ans.add('0' + i + '0');
                
                System.out.println("i: "+i+" n: "+n+" ans: "+ans);
                
                ans.add('1' + i + '1');
                ans.add('8' + i + '8');
                ans.add('6' + i + '9');
                ans.add('9' + i + '6');
                
                System.out.println("ans: "+ans);
            }
        }
        
        return ans;
    }
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(findStrobogrammatic(n));
	}

}
