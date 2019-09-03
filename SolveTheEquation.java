package Math;

import java.util.Arrays;

/*
 * 640. Solve the Equation
 * https://leetcode.com/problems/solve-the-equation/
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, 
 * the variable x and its coefficient.
 * If there is no solution for the equation, return "No solution".
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * Example 1: Input: "x+5-3+x=6+x-2"; Output: "x=2"
 * Example 2: Input: "x=x"; Output: "Infinite solutions"
 * Example 3: Input: "2x=x"; Output: "x=0"
 * Example 4: Input: "2x+3x-6x=x+2"; Output: "x=-1"
 * Example 5: Input: "x=x+2"; Output: "No solution"
 * Explanation and Code from: @ydeng365 https://leetcode.com/problems/solve-the-equation/discuss/105311/Concise-Java-Solution
 */

public class SolveTheEquation {

    public static String solveEquation(String equation) {
    	System.out.println("equation: "+equation);
        String[] parts = equation.split("=");
        System.out.println("parts: "+Arrays.toString(parts));
        
        int[] leftPart = evaluate(parts[0]);
        int[] rightPart = evaluate(parts[1]);
        
        System.out.println("leftPart: "+Arrays.toString(leftPart));
        System.out.println("rightPart: "+Arrays.toString(rightPart));
        
        if(leftPart[0] == rightPart[0] && leftPart[1] == rightPart[1]) {
            return "Infinite solutions";
        }
        else if (leftPart[0] == rightPart[0]) {
            return "No solution";
        }
        
        return "x="+ (rightPart[1]-leftPart[1])/(leftPart[0]-rightPart[0]);
    }
    
    private static int[] evaluate(String str) {
    	System.out.println("str: "+str);
        String[] tokens = str.split("(?=[+-])");  	// ()for match group; ?= for match and include in res; [+-] means + or -;
        int[] res = new int[2]; 					// coefficient for x;  coefficient for constant
        
        for(String token: tokens) {
            System.out.println("token: "+token+" res: "+Arrays.toString(res));
        	
        	if (token.equals("+x") || token.equals("x")) { 
            	res[0]++; // x means 1x
            }
            else if (token.equals("-x")) {
            	res[0]--;// -x means -1x
            }
            else if (token.contains("x")) {	//e.g 2x,3x
                res[0] = res[0] + Integer.parseInt(token.substring(0, token.length()-1)); 
            }
            else {	//constant
                res[1] = res[1] + Integer.parseInt(token);
            }
        	System.out.println("token: "+token+" res: "+Arrays.toString(res));
        }
        System.out.println("res: "+Arrays.toString(res));
        return res;
    }

	public static void main(String[] args) {
		String equation = "x+5-3+x=6+x-2";
		System.out.println(solveEquation(equation));
	}

}
