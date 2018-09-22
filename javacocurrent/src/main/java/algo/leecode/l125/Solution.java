/**
 * 
 */
package java_base.algo.leecode.l125;

/**
 * @author Homer
 *
 */
public class Solution {
	public static void main(String[] args){
		String s = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		String s3 = "";
		
		System.out.println("s is: " + isPalindrome(s));
		System.out.println("s2 is: " + isPalindrome(s2));
		System.out.println("s3 is: " + isPalindrome(s3));
		
	}
    
	
	public static boolean isPalindrome(String s) {
        if(s==null){
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        if( "".equals(s)){
        	return true;
        }
        
        int length = s.length();
        int i=0;
        int j=length-1;
        boolean isPal = true;
        while(i<length/2+1 && isPal){
        	if(s.charAt(i) != s.charAt(j)){
        		isPal = false;
        	}
        	i++;
        	j--;
        }
        return isPal;
        
    }
    
    
}