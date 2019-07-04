package string;

public class H_LongSubParlindrome {



        public static void main(String[] args){
            System.out.println(longestPalindrome("kijjhgfddfghuioiuy"));
        }

    private static String longestPalindrome(String s) {
            int maxPalinLength = 0;
            String longestPalindrome = null;
            for(int i=0; i< s.length(); i++){
                for(int j=i+1; j<s.length(); j++){
                    //maybe can be more small. j < length-i
                    int len = j-i;
                    String cur = s.substring(i, j+1);
                    if(isRalindrome(cur)){
                        if(len > maxPalinLength){
                            longestPalindrome = cur;
                            maxPalinLength = len;
                        }
                    }


                }
            }


            return longestPalindrome;
    }

    private static boolean isRalindrome(String cur) {
            for (int i=0; i< cur.length()-1; i++){
                if(cur.charAt(i) != cur.charAt(cur.length()-i-1)){
                    return false;
                }
            }
            return true;
    }
}
