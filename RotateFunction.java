package Math;

import java.util.Arrays;

/*
 * 396. Rotate Function
 * https://leetcode.com/problems/rotate-function/description/
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * Note: n is guaranteed to be less than 105.
 * Example: A = [4, 3, 2, 6]
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * Code and Explanation from: https://leetcode.com/problems/rotate-function/discuss/87853/Java-O(n)-solution-with-explanation
 */

public class RotateFunction {

	public static int maxRotateFunction(int[] A) {
		int allSum = 0;
		int len = A.length;
		int F = 0;
		
		System.out.println(Arrays.toString(A));
		
		for(int i=0; i<len; i++) {
			System.out.println("i: "+i+" A[i]: "+A[i]);
			
		    F = F + i * A[i];
		    System.out.println("F: "+F);
		    
		    allSum = allSum + A[i];
		    System.out.println("allSum: "+allSum);
		}
		
		System.out.println("F: "+F+" allSum: "+allSum);
		
		int max = F;
		for(int i=len-1; i>=1; i--) {
			System.out.println("i: "+i+" A[i]: "+A[i]+" max: "+max+" len: "+len);
			
		    F = F + allSum - len * A[i];
		    
		    System.out.println("F: "+F+" max: "+max);
		    max = Math.max(F, max);
		}
		System.out.println("max: "+max);
		
		return max;   
    }
	
	public static void main(String[] args) {
		int[] A = {4, 3, 2, 6};
		System.out.println(maxRotateFunction(A));
	}	

}
