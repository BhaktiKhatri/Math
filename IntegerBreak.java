package Math;

/*
 * 343. Integer Break
 * https://leetcode.com/problems/integer-break/description/
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. 
 * Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * Explanation from: https://www.programcreek.com/2015/04/leetcode-integer-break-java/ https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/grandyang/p/5411919.html&prev=search
 * http://buttercola.blogspot.com/2016/06/leetcode-343-integer-break.html
 * Code from: https://leetcode.com/problems/integer-break/discuss/80689/A-simple-explanation-of-the-math-part-and-a-O(n)-solution
 * Time complexity is O(n), space is O(1)
 * 
 */

public class IntegerBreak {

	public static int integerBreak(int n) {
        System.out.println("n: "+n);
		
		if(n == 2) 
        	return 1;
        
        if(n == 3) 
        	return 2;
        
        int product = 1;
        
        while(n > 4) {
        	System.out.println("product: "+product+" n: "+n);
        	product = product * 3;
            n = n - 3;
        }
        System.out.println("product: "+product+" n: "+n);
        
        product = product * n;
        
        System.out.println("product: "+product+" n: "+n);
        
        return product;
    }
	
	public static void main(String[] args) {
		int n = 11;
		System.out.println(integerBreak(n));
	}

}
