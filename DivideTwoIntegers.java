package Math;

/*
 * 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/description/
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * Explanation from: https://leetcode.com/problems/divide-two-integers/discuss/13407/Detailed-Explained-8ms-C++-solution
 * Code from: @daoheng https://leetcode.com/problems/divide-two-integers/discuss/13407/Detailed-Explained-8ms-C++-solution
 * Time complexity : O(a), Auxiliary space : O(1)
 * Medium
 */

public class DivideTwoIntegers {

	/*
	 In this problem, we are asked to divide two integers. However, we are not allowed to use division, multiplication and mod operations. So, what else can we use?
	 Yeah, bit manipulations. Let’s do an example and see how bit manipulations work.

	 Suppose we want to divide 15 by 3, so 15 is dividend and 3 is divisor. Well, division simply requires us to find how many times we can subtract the divisor 
	 from the the dividend without making the dividend negative.

	 Let’s get started. We subtract 3 from 15 and we get 12, which is positive. Let’s try to subtract more. Well, we shift 3 to the left by 1 bit and we get 6. 
	 Subtracting 6 from 15 still gives a positive result. Well, we shift again and get 12. We subtract 12 from 15 and it is still positive. We shift again, obtaining 24
	 
	 and we know we can at most subtract 12. Well, since 12 is obtained by shifting 3 to left twice, we know it is 4 times of 3. How do we obtain this 4? Well, we start from
	 1 and shift it to left twice at the same time. We add 4 to an answer (initialized to be 0). In fact, the above process is like 15 = 3 * 4 + 3. We now get part of
	 the quotient (4), with a remainder 3.

	 Then we repeat the above process again. We subtract divisor = 3 from the remaining dividend = 3 and obtain 0. We know we are done. No shift happens, so we 
	 simply add 1 << 0 to the answer. Now we have the full algorithm to perform division.

	 According to the problem statement, we need to handle some exceptions, such as overflow. Well, two cases may cause overflow:

	 divisor = 0;
	 dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1).
	 Of course, we also need to take the sign into considerations, which is relatively easy.
	
	*/
	
	public static int divide(int dividend, int divisor) {
	    if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) 
	    	return Integer.MAX_VALUE;
	    
	    System.out.println("divisor: "+divisor+" dividend: "+dividend);
	    
	    int res = 0;
	    int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
	    long dvd = Math.abs((long) dividend);
	    long dvs = Math.abs((long) divisor);
	    
	    System.out.println("sign: "+sign+" dvd: "+dvd+" dvs: "+dvs);
	    
	    while(dvs <= dvd) {
	        
	    	long temp = dvs; 
	        long mul = 1;
	        
	        System.out.println("temp: "+temp+" mul: "+mul+" dvd: "+dvd+" dvs: "+dvs);
	        
	        while(dvd >= temp << 1) {
	            temp = temp << 1;
	            mul = mul << 1;
	        }
	        dvd = dvd - temp;
	        res = (int) (res + mul);
	    }
	    return sign == 1 ? res : -res;
	}
	
	//geeksforgeeks https://www.geeksforgeeks.org/divide-two-integers-without-using-multiplication-division-mod-operator/
	/*
	 *  divisor = 0
	 	dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1)
	 	Of course, we also need to take the sign into considerations, which is relatively easy
	 */
	public static int divide1(int dividend, int divisor) {
		System.out.println("dividend: "+dividend+" divisor: "+divisor);
		
		if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) 
	    	return Integer.MAX_VALUE;
		
		System.out.println("(dividend < 0): "+(dividend < 0)+" (divisor < 0): "+(divisor < 0)+" ((dividend < 0) ^ (divisor < 0)): "+((dividend < 0) ^ (divisor < 0)));
		
        // Calculate sign of divisor i.e., sign will be negative only iff either one of them is negative otherwise it will be positive
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        System.out.println("sign: "+sign);
     
        // Update both divisor and dividend positive
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        System.out.println("dividend: "+dividend+" divisor: "+divisor);
     
        // Initialize the quotient
        int quotient = 0;
         
        while(dividend >= divisor) {
        	//System.out.println("dividend: "+dividend+" divisor: "+divisor+" quotient: "+quotient);
            
        	dividend = dividend - divisor;
            ++quotient;
        }
        System.out.println("dividend: "+dividend+" divisor: "+divisor+" quotient: "+quotient+" sign: "+sign);
     
        return sign * quotient;
    }    
	
	public static void main(String[] args) {
		System.out.println(divide1(15, 0));
	}

}
