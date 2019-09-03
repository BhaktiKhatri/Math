package Math;

/*
 * 372. Super Pow
 * https://leetcode.com/problems/super-pow/description/
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * Example1: a = 2; b = [3]; Result: 8
 * Example2: a = 2; b = [1,0]; Result: 1024
 * Explanation and Code from: https://leetcode.com/problems/super-pow/discuss/84472/C++-Clean-and-Short-Solution
 * Medium
 */

public class SuperPow {

	public static int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }
    
    public static int superPow(int a, int[] b, int length, int k) {
        if (length == 1) {
            return powMod(a, b[0], k);
        }
        
        return powMod(superPow(a, b, length - 1, k), 10, k) * powMod(a, b[length - 1], k) % k;
    }
    
    
    //x^y mod k
    public static int powMod(int x, int y, int k) {
        x = x % k;
        int pow = 1;
        
        for(int i = 0; i < y; i++) {
            pow = (pow * x) % k;
        }
        return pow; 
    }
	
	public static void main(String[] args) {
		int a = 2;
		int[] b = {3};
		System.out.println(superPow(a, b));
	}

}
