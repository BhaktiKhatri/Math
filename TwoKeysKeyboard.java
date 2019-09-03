package Math;

public class TwoKeysKeyboard {

	public static int minSteps(int n) {
        int ans = 0;
        int d = 2;
        
        while(n > 1) {
            while(n % d == 0) {
                ans = ans + d;
                n = n / d;
            }
            d++;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int n = 3;
		
		System.out.println(minSteps(n));
	}

}
