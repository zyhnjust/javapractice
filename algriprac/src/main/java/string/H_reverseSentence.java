package string;

/**
 * created by hzhang on 9:13 AM$  6/27/2019
 **/
public class H_reverseSentence {


    private static String reverseSentence(String ori) {
        if (ori == null || ori.trim().length() == 0) {
            return ori;
        }

        String[] tmp = ori.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            sb.append(tmp[i]); // still a space in the last one.
            if (i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }


    public static void main(String[] args){
        String ori = "I am a student. ";
        String resStr = reverseSentence(ori);
        System.out.println("After reverse, " + ori + " will be changed to " + resStr);

        String leftStr = LeftRotateString(ori, 3);
        System.out.println("After left reverse, " + ori + " will be changed to " + leftStr);

    }


    public static String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0)
            return "";
        n = n % len;
        String s1 = str.substring(n, len);
        String s2 = str.substring(0, n);
        return s1+s2;
    }

}

//public class Solution {
//    public String ReverseSentence(String str) {
//        if(str.trim().length() == 0)
//            return str;
//        String [] temp = str.split(" ");
//        String res = "";
//        for(int i = temp.length - 1; i >= 0; i--){
//            res += temp[i];
//            if(i != 0)
//                res += " ";
//        }
//        return res;
//    }
//}
