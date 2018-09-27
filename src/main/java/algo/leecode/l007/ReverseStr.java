package algo.leecode.l007;

public class ReverseStr {

	public static int reverse(int x){
		// define is in the first. 
		boolean isNagetive = false;
		int reverse=0;
		
		if(x==0){
			return x;
		}
		
		if(x<0){
			x=-1 * x;
			isNagetive = true;
		}
		while(x>0){
			if(reverse>Integer.MAX_VALUE){
				return 0;
			}
			reverse = reverse*10 + x%10;
			x=x/10;
		}
		
		if(isNagetive){
			reverse = reverse*-1;
		}
		return reverse;
	}
	
	
	public static void main(String[] args) {
		System.out.println(reverse(1234));
		System.out.println(reverse(-124));
	}

}
