package string;

public class H_CheckPalindrome {


    private static boolean isPalindrome(String str) {
        if(str.length() == 0){
            return true;
        }

        int l=0, r=str.length() -1;
        while(l<r){
            if(!Character.isLetterOrDigit(str.charAt(l))){
                l++;
            }else if (!Character.isLetterOrDigit(str.charAt(r))){
                r--;
            }else{
                if(Character.toLowerCase(str.charAt(l)) != Character.toLowerCase((str.charAt(r)))){
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;

    }

    public static void main(String[]  args){
        String[] strList = {"qwewq123", "rewqwer","wertRew"};

        for(int i=0; i< strList.length; i ++){
            String str = strList[i];
            boolean isPal = isPalindrome(str);
            System.out.println(str + " is palindrom? " + isPal);
        }

    }

}
