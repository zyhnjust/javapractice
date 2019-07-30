package algri.string;

/**
 * created by hzhang on 11:04 AM$  6/28/2019
 **/
public class H_Regex_Copy {
    public static void main(String[] args){
        String regex = "ab*ac*a.b";
        String[] strList = {"aaab", "abbbaaub","abacac",""};
        for(int i=0; i< strList.length; i++){
            System.out.println("Str " + strList[i] +" match regex [" + regex + "] " + match(regex.toCharArray(), strList[i].toCharArray()));
        }

    }
    public static boolean match(char[] str, char[] pattern)
    {
        int sindex = 0, pindex = 0;
        return matchCore(str, sindex, pindex, pattern);
    }
    public static boolean matchCore(char[] str, int sindex, int pindex, char[] pattern){
        if(sindex >= str.length && pindex == pattern.length)
            return true;
        if(pindex >= pattern.length && sindex < str.length)
            return false;
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){
                return matchCore(str, sindex, pindex+2, pattern) ||
                        matchCore(str, sindex+1, pindex+2, pattern ) ||
                        matchCore(str, sindex+1, pindex, pattern);
            }else{
                return matchCore(str, sindex, pindex+2, pattern);
            }
        }
        if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex+1, pindex+1, pattern);
        return false;
    }
}
