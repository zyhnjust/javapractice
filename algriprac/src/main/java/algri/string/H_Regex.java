package algri.string;

/**
 * created by hzhang on 9:27 AM$  6/28/2019
 **/
public class H_Regex {



    private static boolean isMatch(String regex, String s) {
        if(s==null || s == ""){
            return false;
        }
        int i=0;
        int j=0;
        while( j<s.length() && i<regex.length()) {
                if( regex.charAt(i) == '.' ){
                    i++;
                    j++;
                    continue;
                }
                if((i<regex.length()-1) && regex.charAt(i+1)=='*') {
                    char tmp = regex.charAt(i);
                    i = i + 2;
                    if (s.charAt(j) != tmp) {
                        continue;
                    } else {
                        j++;
                        while (s.charAt(j) == tmp) {
                            j++;
                        }
                    }
                }else if(s.charAt(j) == regex.charAt(i)){
                    i++;
                    j++;
                }else {
                    break;
                }
        }
        if(j==s.length() ){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args){
        String regex = "ab*ac*a.b";
        String[] strList = {"aaab", "abbbaaub","abacac",""};
        for(int i=0; i< strList.length; i++){
            System.out.println("Str " + strList[i] +" match regex [" + regex + "] " + isMatch(regex, strList[i]));
        }

    }
}
