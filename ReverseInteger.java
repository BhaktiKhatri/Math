package Math;

public class ReverseInteger {

	public static int reverse(int x) {
		int result = 0;
		int xRemaining = Math.abs(x);
		
		while(xRemaining != 0) {
			result = result * 10 + xRemaining % 10;
			xRemaining = xRemaining / 10;
		}
		
		return x < 0 ? -result : result;
	}
	
	public static int reverse1(int x) {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            
            System.out.println("newResult: "+newResult+" tail: "+tail+" result: "+result);
            
            if((newResult - tail) / 10 != result)
            { 
            	return 0; 
            }
            
            result = newResult;
            x = x / 10;
            
            System.out.println("newResult: "+newResult+" tail: "+tail+" result: "+result);
        }

        return result;
    }
	
	//Refer this
	public static int reverse2(int number) {
        if(number >= -9 && number <= 9) {
			return number;
		}

		int reverseNum = 0;	
		int sign = number < 0 ? -1 : 1;
		number = Math.abs(number);
		
		System.out.println("number: "+number+" sign: "+sign);
		
		while(number > 0) {
			
			int tail = number % 10;	
			number = number / 10;
			
			if(reverseNum > Integer.MAX_VALUE/10 || (reverseNum == Integer.MAX_VALUE/10 && tail > 7)) {
				return 0;
			}
			
			reverseNum = reverseNum * 10 + tail;
		}
		return reverseNum*sign;
    }
	
	public static void main(String[] args) {
		int x = -2147483648;
		System.out.println(reverse2(x));
	}

}
