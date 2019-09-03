package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0;
        int index = -1;
        
        System.out.println(Arrays.toString(nums));
        
        for(int i=0; i<n; i++) {
        	System.out.println("i: "+i+" count[i]: "+count[i]+" pre[i]: "+pre[i]);
        	
            count[i] = 1;
            pre[i] = -1;
            
            for(int j = i-1; j >= 0; j--) {
            	System.out.println("j: "+j+" nums[i]: "+nums[i]+" nums[j]: "+nums[j]+" count[j]: "+count[j]);
            	
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            
            System.out.println("max: "+max+" count[i]: "+count[i]+" index: "+index);
            
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        
        System.out.println("index: "+index);
        
        List<Integer> res = new ArrayList<>();
        while(index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        
        System.out.println("res: "+res);
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,4,8};
		System.out.println(largestDivisibleSubset(nums));
	}

}
