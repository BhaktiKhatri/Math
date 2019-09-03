package Math;

import java.util.LinkedList;

/*
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/description/
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive. Given k will be between 1 and n! inclusive.
 * Example 1: Input: n = 3, k = 3; Output: "213"
 * Example 2: Input: n = 4, k = 9; Output: "2314"
 * Explanation and Code from: https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
 * Time Complexity: O(n); Space Complexity: O(n)
 * Twitter
 * Medium
 */

public class PermutationSequence {

	public static String getPermutation(int n, int k) {
        
		StringBuilder sb = new StringBuilder();
        LinkedList<Integer> num = new LinkedList<Integer>();
        
        System.out.println("n: "+n+" k: "+k);
        
        int fact = 1;
        for(int i=1; i<=n; i++) {
        	System.out.println("i: "+i+" fact: "+fact);
            fact = fact * i;
            num.add(i);
            System.out.println("num: "+num);
        }
        
        System.out.println("num: "+num);
        
        for(int i=0, l=k - 1; i<n; i++) {
        	System.out.println("i: "+i+" l: "+l+" fact: "+fact);
            fact = fact / (n - i);
            System.out.println("fact: "+fact);
            
            int index = (l / fact);
            System.out.println("index: "+index);
            
            sb.append(num.remove(index));
            System.out.println("sb: "+sb);
            
            l = l - index * fact;
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		int n = 4;
		int k = 14;
		System.out.println(getPermutation(n, k));
	}

}
