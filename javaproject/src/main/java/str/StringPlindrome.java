package str;

public class StringPlindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ertyuytredfdfgfderewredcvcde213";
		String bigstr= getBigPlindrome(str);
		System.out.println("The biggest plindrome string is: " + bigstr);
	}

	private static String getBigPlindrome(String str) {
		String targetstr="";
		for(int i=0; i< str.length()-1; i++){
			for(int j=i+1; j<str.length(); j++){
				String str1=str.substring(i, j);
				if(isPin(str1) && targetstr.length()<str1.length()){
					targetstr=str1;
				}
			}
		}
		return targetstr;
	}
	
	private static boolean isPin(String st){
		int length = st.length();
		for(int i =0; i<length/2; i++){
			if(st.charAt(i)!=st.charAt(length-i-1)){
				return false;
			}
		}
		return true;
	}

}
