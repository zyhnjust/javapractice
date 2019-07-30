package algri.string;

import java.util.Arrays;

/**
 * created by hzhang on 9:58 AM$  6/26/2019
 **/
public class LongestCommonPre_one {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        Arrays.sort(strs);
        char [] first = strs[0].toCharArray();
        char [] last = strs[strs.length - 1].toCharArray();
        StringBuffer res = new StringBuffer();
        int len = first.length < last.length ? first.length : last.length;
        int i = 0;
        while(i < len){
            if(first[i] == last[i]){
                res.append(first[i]);
                i++;
            }
            else
                break;
        }
        return res.toString();
    }
    public static void main(String[]  args){

    }

}
