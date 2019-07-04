package string;

/**
 * created by hzhang on 7:53 AM$  6/21/2019
 **/
public class H_replaceSpace {

    public static String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for(int i = len; i >= 0; i--){
            if(str.charAt(i) == ' ')
                res.append("02%");
            else
                res.append(str.charAt(i));
        }
        return res.reverse().toString();
    }
    public static String replaceSpaceFromFirst(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for(int i = 0; i <= len; i++){
            if(str.charAt(i) == ' ')
                res.append("%20");
            else
                res.append(str.charAt(i));
        }
        return res.toString();
    }
    public static void main(String[]  args){
        String str = "we are happy!";
        System.out.println(replaceSpace(new StringBuffer(str)));
        System.out.println(replaceSpaceFromFirst(new StringBuffer(str)));

        System.out.println(replace_space_new(str));


    }

    public static String replace_space_new(String str){
        int length = str.length();
        int spaceCount =0;
        for(int i=0; i< length; i++){
            if(str.charAt(i) ==' '){
                spaceCount ++;
            }
        }
        int newLength = length+ spaceCount*2;

        char[] newStrArray = new char[newLength];

        int j=newLength-1;
        for(int i=length-1; i>=0; i--){
            if(str.charAt(i) == ' '){
                newStrArray[j]='0';
                newStrArray[j-1]='2';
                newStrArray[j-2]='%';
                j=j-3;
            }else{
                newStrArray[j--]=str.charAt(i);
            }

        }
        return new String(newStrArray);
    }

}
