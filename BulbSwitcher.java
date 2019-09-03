package Math;

/*
 * 319. Bulb Switcher
 * https://leetcode.com/problems/bulb-switcher/description/
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. 
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. 
 * For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * Example: Given n = 3. 
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].  So you should return 1, because there is only one bulb is on.
 * Explanation and Code from: https://leetcode.com/problems/bulb-switcher/discuss/77104/Math-solution..
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/grandyang/p/5100098.html&prev=search
 * Medium
 */

public class BulbSwitcher {

	//A bulb ends up on iff it is switched an odd number of times => So bulb i ends up on if and only if it has an odd number of divisors =>
	//So bulb i ends up on if and only if i is a square as only square numbers have odd number of divisors =>
	//So count number of squares upto n
	public static int bulbSwitch(int n) {
        //return (int)Math.sqrt(n);
		
		int squareCount = 1;
		while(squareCount * squareCount <= n) {
			squareCount++;
		}
		
		return squareCount - 1;
    }
	
	public static void main(String[] args) {
		int n = 9;
		System.out.println(bulbSwitch(n));
	}

}
