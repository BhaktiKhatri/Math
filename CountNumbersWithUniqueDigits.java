package Math;

/*
 * 357. Count Numbers with Unique Digits
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example: Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * Code from: https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/83041/JAVA-DP-O(1)-solution.
 * Explanation from: https://translate.google.com/translate?hl=en&sl=zh-CN&u=https://www.hrwhisper.me/leetcode-count-numbers-unique-digits/&prev=search
 * Time Complexity: O(1)
 * Google
 */

public class CountNumbersWithUniqueDigits {

	public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0)     
        	return 1;
        
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        
        System.out.println("n: "+n);
        
        while(n-- > 1 && availableNumber > 0) {
        	System.out.println("n: "+n+" availableNumber: "+availableNumber+" uniqueDigits: "+uniqueDigits);
        	
            uniqueDigits = uniqueDigits * availableNumber;
            System.out.println("availableNumber: "+availableNumber+" uniqueDigits: "+uniqueDigits);
            
            res = res + uniqueDigits;
            System.out.println("res: "+res+" availableNumber: "+availableNumber+" uniqueDigits: "+uniqueDigits);
            
            availableNumber--;
            System.out.println("availableNumber: "+availableNumber);
        }
        System.out.println("res: "+res);
        
        return res;
    }
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(countNumbersWithUniqueDigits(n));
	}

}
