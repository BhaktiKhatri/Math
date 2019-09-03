package Math;

/*
 	50. Pow(x, n)
	https://leetcode.com/problems/powx-n/description/
	Implement pow(x, n).
	
	Example 1:
	Input: 2.00000, 10
	Output: 1024.00000

	Example 2:
	Input: 2.10000, 3
	Output: 9.26100
	
	Explanation and Code from: https://leetcode.com/problems/powx-n/solution/ 
	https://translate.google.com/translate?hl=en&sl=zh-CN&u=
	http://www.cnblogs.com/grandyang/p/4383775.html&prev=search
 	https://zichenwang.gitbooks.io/algorithms-summary/50-powx-n.html
 */

public class Powxn {

	/*
	 * The basic idea is to decompose the exponent into powers of 2, so that you can keep dividing the problem in half. For example, lets say

		N = 9 = 2^3 + 2^0 = 1001 in binary. Then:
		x^9 = x^(2^3) * x^(2^0)
		
		We can see that every time we encounter a 1 in the binary representation of N, we need to multiply the answer with x^(2^i) where i
		is the ith bit of the exponent. Thus, we can keep a running total of repeatedly squaring x - (x, x^2, x^4, x^8, etc) and multiply it
		by the answer when we see a 1.
		
		To handle the case where N=INTEGER_MIN we use a long (64-bit) variable. Below is solution:
		
		Yes, since you're dividing N by 2 every iteration that's why it is O(Log N). However, since N is a fixed number of bits (32) you could
		view it as O(1) where the maximum number iterations is 32. Hope this helps.
		
		We can treat n as binary and pick corresponding value into result when corresponding digit is 1. For example, if n = 19,
		it’s binary presentation is 10011, which means we can only pick x^(2^0), x^(2^1) and x^(2^4) into result.
	 */
	public static double myPow(double x, int n) {
		if(n == 0)
			return 1;
		else if(n == 1)
			return x;
		
		System.out.println("x: "+x+" n: "+n);
		
        long N = n;
        
        System.out.println("N: "+N);
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double ans = 1;
        System.out.println("ans: "+ans+" x: "+x);
        
        for (long i = N; i > 0; i = i / 2) {
        	System.out.println("i: "+i+" (i % 2): "+(i % 2));
        	
            if ((i % 2) == 1) {
                ans = ans * x;
            }
            System.out.println("ans: "+ans+" x: "+x);
            
            x = x * x;
            System.out.println("ans: "+ans+" x: "+x);
        }
        
        return ans;
    }
	
	public static void main(String[] args) {
		double x = 2;
		int n = -2;
		
		System.out.println(myPow(x, n));	
	}

}
