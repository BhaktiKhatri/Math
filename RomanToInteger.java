package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/description/
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * Explanation and Code from: https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
 * @author NisuBhakti
 * Time Complexity: O(N)
 * Easy	
 * Facebook, Microsoft, Bloomberg, Uber, Yahoo
 */

public class RomanToInteger {

	public static int romanToInt(String s) {
        Map<Character, Integer> romeToNatural = new HashMap<Character, Integer>();
        romeToNatural.put('I', 1);
        romeToNatural.put('V', 5);
        romeToNatural.put('X', 10);
        romeToNatural.put('L', 50);
        romeToNatural.put('C', 100);
        romeToNatural.put('D', 500);
        romeToNatural.put('M', 1000);

        int result = 0;
        for(int i=0; i<s.length(); i++) {
        	System.out.println("==============i: "+i+" s.charAt(i): "+s.charAt(i));
        	
        	int current = romeToNatural.get(s.charAt(i));
        	System.out.println("current: "+current);
        	
        	if(i+1 < s.length()) {
        		System.out.println("============i+1: "+(i+1)+" s.charAt(i+1): "+s.charAt(i+1));
        		int next = romeToNatural.get(s.charAt(i+1));
        		System.out.println("next: "+next+" result: "+result);
        		
        		if(current >= next) {
        			result = result + current;
        		}
        		else {
        			result = result + next - current;	//C placed before D or M indicates a hundred less; so CM = 1000 - 100 = 900; so next-current
        			i++;								//same way I before V is 1 less; i.e. 5-1=4 so IV is 4; so next - current = 5-1 = 4
        		}
        	}
        	else {
        		result = result + current;
        		//i++; //not needed
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		String str = "MCMXCIV";
		System.out.println(str);
		System.out.println(romanToInt(str));
	}
}
