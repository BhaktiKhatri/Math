package Math;

import java.util.Arrays;

/*
 * 264. Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/description/
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly
 * numbers. Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 * Explanation from: https://www.geeksforgeeks.org/ugly-numbers/
 * Code from: https://leetcode.com/problems/ugly-number-ii/discuss/69364/My-16ms-C++-DP-solution-with-short-explanation
 * 
 */

public class UglyNumber2 {

	public static int nthUglyNumber(int n) {
        if(n <= 0) 
        	return 0; 				// get rid of corner cases 
        
        if(n == 1) 
        	return 1; 				// base case
        
        int t2 = 0, t3 = 0, t5 = 0; //pointers for 2, 3, 5
        int[] k = new int[n];
        k[0] = 1;
        
        System.out.println("n: "+n);
        
        for(int i=1; i<n; i++)
        {
        	System.out.println("i: "+i+" k[i]: "+k[i]+" t2: "+t2+" k[t2]: "+k[t2]+" t3: "+t3+" k[t3]: "+k[t3]+" t5: "+t5+" k[t5]: "+k[t5]+" k: "+Arrays.toString(k));
            k[i] = Math.min(k[t2]*2, Math.min(k[t3]*3, k[t5]*5));
            
            if(k[i] == k[t2]*2) 
            	t2++; 
            
            if(k[i] == k[t3]*3) 
            	t3++;
            
            if(k[i] == k[t5]*5) 
            	t5++;
        }
        System.out.println(Arrays.toString(k));
        return k[n-1];
    }
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println(nthUglyNumber(n));
	}

}