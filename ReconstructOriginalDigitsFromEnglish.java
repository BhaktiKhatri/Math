package Math;

/*
 * 423. Reconstruct Original Digits from English
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/description/
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * Note: Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1: Input: "owoztneoer"; Output: "012"
 * Example 2: Input: "fviefuro"; Output: "45"
 * Explanation and Code from: https://leetcode.com/problems/reconstruct-original-digits-from-english/discuss/91207/one-pass-O(n)-JAVA-Solution-Simple-and-Clear
 * Medium
 */

public class ReconstructOriginalDigitsFromEnglish {

	public static String originalDigits(String s) {
	    int[] count = new int[10];
	    
	    System.out.println("s: "+s);
	    
	    for(int i=0; i<s.length(); i++) {
	        
	    	char c = s.charAt(i);
	        System.out.println("c: "+c);
	        
	        if (c == 'z') 		//0
	        	count[0]++;
	        
	        if (c == 'w') 		//2
	        	count[2]++;
	        
	        if (c == 'x') 		//6
	        	count[6]++;
	        
	        if (c == 's') 
	        	count[7]++; //7-6
	        
	        if (c == 'g') 		//8
	        	count[8]++;
	        
	        if (c == 'u') 		//4
	        	count[4]++; 
	        
	        if (c == 'f') 
	        	count[5]++; //5-4
	        
	        if (c == 'h') 
	        	count[3]++; //3-8
	        
	        if (c == 'i') 
	        	count[9]++; //9-8-5-6
	        
	        if (c == 'o') 
	        	count[1]++; //1-0-2-4
	    }
	    
	    count[7] = count[7] - count[6];
	    count[5] = count[5] - count[4];
	    count[3] = count[3] - count[8];
	    count[9] = count[9] - count[8] - count[5] - count[6];
	    count[1] = count[1] - count[0] - count[2] - count[4];
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<=9; i++) {
	        for(int j=0; j<count[i]; j++) {
	            sb.append(i);
	        }
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "owoztneoer";
		System.out.println(originalDigits(s));
	}

}
