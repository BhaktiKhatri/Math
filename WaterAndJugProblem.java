package Math;

/*
 * 365. Water and Jug Problem
 * https://leetcode.com/problems/water-and-jug-problem/description/
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is 
 * possible to measure exactly z litres using these two jugs.
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * Operations allowed: Fill any of the jugs completely with water. Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example) Input: x = 3, y = 5, z = 4; Output: True
 * Example 2: Input: x = 2, y = 6, z = 5; Output: False
 * Explanation and Code from: https://leetcode.com/problems/water-and-jug-problem/discuss/83715/Math-solution-Java-solution
 * https://leetcode.com/problems/water-and-jug-problem/discuss/83720/Clear-Explanation-of-Why-Using-GCD
 * Microsoft
 * Medium
 */

public class WaterAndJugProblem {

	public static boolean canMeasureWater(int x, int y, int z) {
	    //limit brought by the statement that water is finallly in one or both buckets
	    if(x + y < z) 
	    	return false;

	    //case x or y is zero
	    if(x == z || y == z || x + y == z) 
	    	return true;
	    
	    System.out.println("x: "+x+" y: "+y+" z: "+z);
	    
	    int gcd = GCD(x, y);
	    System.out.println("gcd: "+gcd);
	    
	    //get GCD, then we can use the property of Bézout's identity
	    return z % gcd == 0;
	}

	public static int GCD(int a, int b) {
		System.out.println("a: "+a+" b: "+b);
		
	    while(b != 0) {
	        int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}
	
	public static void main(String[] args) {
		int x = 3; 
		int y = 5;
		int z = 4;
		System.out.println(canMeasureWater(x, y, z));
	}

}
