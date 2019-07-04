package string;

/**
 * created by hzhang on 9:25 AM$  6/25/2019
 **/
public class H_KMP {


    /*

     */
    private static int getPosition(String parent, String subStr) {
        if (parent ==null || subStr == null|| parent.length()<subStr.length()){
            return -1;
        }
        for(int i=0; i< parent.length(); i++){
            int point = i;
            int j=0;
            while(point<parent.length() && j<subStr.length() && parent.charAt(point) == subStr.charAt(j) ){
                if(j==subStr.length()-1){
                    return point-subStr.length()+1;
                }
                point ++;
                j++;
            }
        }
        return -1;
    }

    private static int getKMPPosition(String parent, String subStr) {

        int[] next = getNext(subStr);

        if (parent ==null || subStr == null|| parent.length()<subStr.length()){
            return -1;
        }
        for(int i=0; i< parent.length(); ){
            int point = i;
            int j=0;
            while(point<parent.length() && j<subStr.length() && parent.charAt(point) == subStr.charAt(j) ){
                if(j==subStr.length()-1){
                    return point-subStr.length()+1;
                }
                point ++;
                j++;
            }
            if(j==0){
                i++;
            }else{
                i = i+ j - next[i];
            }
        }
        return -1;
    }

    private static int[] getNext(String subStr) {
        int[] next = new int[subStr.length()];
        for(int i=0; i< subStr.length() ; i++){

            String[] frontStrList = new String[i+1];
            String[] endStrList = new String[i+1];
            for(int j=0;j<i+1; j++){
                frontStrList[j]=subStr.substring(0, j+1);
                endStrList[j]=subStr.substring(subStr.length()-j-1, subStr.length());
            }
            int number = getCommonNumber(frontStrList, endStrList);
            next[i] = number;
            System.out.print(next[i]);
        }
        return next;
    }

    private static int getCommonNumber(String[] frontStrList, String[] endStrList) {
        int number =0;
        for(int i=0; i< frontStrList.length; i++){
            for(int j=0; j<endStrList.length; j++){
                if (frontStrList[i].equals(endStrList[j])){
                    number++;
                }
            }
        }
        return number;
    }


    public static void main(String[] args){
        String parent = "abbdfabsdfewrjljkfdsafa";
        String subStr = "absd";
        System.out.println("String " + subStr +" in parent " + parent + " is " + getPosition(parent, subStr)) ;
        System.out.println("KMP String " + subStr +" in parent " + parent + " is " + getKMPPosition(parent, subStr)) ;

    }



}
