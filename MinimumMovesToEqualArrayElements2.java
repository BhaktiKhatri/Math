package Math;

import java.util.Arrays;

/*
 * 462. Minimum Moves to Equal Array Elements II
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element
 * by 1 or decrementing a selected element by 1. You may assume the array's length is at most 10,000.
 * Example: Input: [1,2,3]; Output: 2; Explanation: Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * Explanation and Code from: Approach #6 Using quick-select https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/solution/
 * Time complexity : Average Case: O(n) Quick-Select average case time complexity is O(n); Worst Case: O(n^2) In worst case quick-select can go upto n^2
 * Space complexity : O(1); No extra space required
 * Medium
 */

public class MinimumMovesToEqualArrayElements2 {

	//Find the sum of the absolute values ​​of the difference between each element of the array and the median
	
	public static void swap(int[] list, int i, int pivot_index) {
        int temp = list[i];
        list[i] = list[pivot_index];
        list[pivot_index] = temp;
    }
	
    public static int partition(int[] list, int left, int right) {
        int pivotValue = list[right];
        int i = left;
        
        System.out.println("list: "+Arrays.toString(list));
        System.out.println("left: "+left+" right: "+right+" pivotValue: "+pivotValue+" i: "+i);
        
        for (int j = left; j <= right; j++) {
        	System.out.println("list[j]: "+list[j]+" pivotValue: "+pivotValue);
        	
            if (list[j] < pivotValue) {
                swap(list, i, j);
                i++;
            }
        }
        swap(list, right, i);
        return i;
    }
    
    public static int select(int[] list, int left, int right, int k) {
    	System.out.println("list: "+Arrays.toString(list));
    	System.out.println("left: "+left+" right: "+right+" k: "+k);
    	
        if (left == right) {
            return list[left];
        }
        
        int pivotIndex = partition(list, left, right);
        System.out.println("pivotIndex: "+pivotIndex);
        
        if (k == pivotIndex) {
            return list[k];
        } 
        else if (k < pivotIndex) {
            return select(list, left, pivotIndex - 1, k);
        }
        else {
            return select(list, pivotIndex + 1, right, k);
        }
    }
    
    public static int minMoves2(int[] nums) {
        int sum = 0;
        
        System.out.println("nums: "+Arrays.toString(nums));
        int median = select(nums, 0, nums.length - 1, nums.length / 2);
        
        System.out.println("median: "+median+" list: "+Arrays.toString(nums));
        
        for(int num : nums) {
        	System.out.println("num: "+num+" sum: "+sum);
            sum = sum + Math.abs(median - num);
        }
        return sum;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 8, 2, 5, 1, 4, 7, 6};
		System.out.println(minMoves2(nums));
	}

}
