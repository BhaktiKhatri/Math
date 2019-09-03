package Math;

import java.util.Arrays;

/*
 * 313. Super Ugly Number
 * https://leetcode.com/problems/super-ugly-number/
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * Example: Input: n = 12, primes = [2,7,13,19]; Output: 32 
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19] of size 4.

 */

public class SuperUglyNumber {

	public static int nthSuperUglyNumber(int n, int[] primes) {
	    int [] res = new int[n];
	    res[0] = 1;
	    int [] cur = new int[primes.length];
	    
	    System.out.println("n: "+n+" primes: "+Arrays.toString(primes));
	    
	    for(int i=1; i<n; i++) {
	        res[i] = Integer.MAX_VALUE;
	        for(int j = 0; j < primes.length; j++) {
	        	System.out.println("i: "+i+" j: "+j+" primes[j]: "+primes[j]+" cur[j]]: "+cur[j]+" res[cur[j]]: "+res[cur[j]]+" res[i-1]: "+res[i-1]);
	        	
	            if (primes[j] * res[cur[j]] == res[i-1]) {
	                cur[j]++;
	            }
	            System.out.println("res[i]: "+res[i]);
	            
	            res[i] = Math.min(res[i], primes[j] * res[cur[j]]);
	        }
	    }
	    return res[n-1];
	}

	public static void main(String[] args) {
		int n = 12;
		int[] primes = {2,7,13,19};
		
		System.out.println(nthSuperUglyNumber(n, primes));
	}
}