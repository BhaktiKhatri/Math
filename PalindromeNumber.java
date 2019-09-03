package Math;

/*
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/description/
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 * Explanation and Code from: https://leetcode.com/problems/palindrome-number/solution/
 * Time complexity: O(log​10n). We divided the input by 10 for every iteration, so the time complexity is O(log​10n); Space complexity : O(1).
 * Easy
 */

public class PalindromeNumber {
	/*
	 * For example, if the input is 1221, if we can revert the last part of the number "1221" from "21" to "12", and compare it with the first
	 * half of the number "12", since 12 is the same as 12, we know that the number is a palindrome.
	 */

	// Special cases:
    // As discussed above, when x < 0, x is not a palindrome.
    // Also if the last digit of the number is 0, in order to be a palindrome, 
    // the first digit of the number also needs to be 0.
    // Only 0 satisfy this property.
	public static boolean isPalindrome(int x) {
		if(x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		System.out.println("x: "+x);

		int revertedNumber = 0;
		
		System.out.println("x: "+x+" revertedNumber * 10: "+(revertedNumber * 10)+" x % 10: "+(x % 10)+" x / 10: "+(x / 10));
		
		while(x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;						// x % 10: gives the last number i.e 1221 % 10 = 1
			x = x / 10;															// x / 10: gives all numbers except the last one i.e 1221/10 = 122
		}
		
		System.out.println("x: "+x+" revertedNumber: "+revertedNumber);
		
		return x == revertedNumber || x == revertedNumber / 10;
	}
	
	public static void main(String[] args) {
		int x = 12321;
		System.out.println(isPalindrome(x));
	}

}
