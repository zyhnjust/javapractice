package algo;

public class PalindromeDP {
	
	public String lognestPalindrome(String s){
		if(s==null || s.length()<=1)
			return s;
		
		int len = s.length();
		int maxLen = 1;
		boolean [][] dp = new boolean [len][len];
		
		String longest = null;
		for(int k=0; k< len-1; k++){
			for(int i=0; i< len-k; i++){
				int j=i+k;
				System.out.println("i: " + i);
				System.out.println("j: " + j);
				System.out.println("l: " + k);

				if(s.charAt(i) == s.charAt(j) && (j-i<=2|| dp[i+1][j-1])){
					dp[i][j] = true;
					if(j-i+1 > maxLen){
						maxLen = j-i +1;
						longest = s.substring(i, j+1);
					}
				}
			}
			
			
		}
		
		
		return longest;
		
		
		
	}
	

	public static void main(String[] args) {
		String s = "banana";
		String ret = new PalindromeDP().lognestPalindrome(s);
		System.out.println(ret);
	}

}
