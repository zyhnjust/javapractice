package algri.string;

import java.util.HashMap;

/**
 * @program: algriprac
 * @description:
 * @author: hzhang
 * @create: 2019-07-04 14:25
 **/
public class H_longestsubnoduplicate {



    public static void main(String[] args){
        String str = "weryuidsfkswrewrsdfsadnfkjewre";
        int length = getLength(str);
        System.out.println(length);
        System.out.println( getLength2(str));
        System.out.println( getLength_baoli(str));
        System.out.println( getLongestLength(str));
        System.out.println( getLongestLength_hash(str));


    }

    private static int getLongestLength(String str){
        if(str == null || str.length() == 0) return 0;

        int left =0, right =0, max=0;
        int n = str.length();
        boolean[] used = new boolean[128];
        while(right < n){
            if(used[str.charAt(right)] == false){
                used[str.charAt(right)] = true;
                right++;
            }else{
                max = Math.max(max, right - left);
                while(left<right && str.charAt(right) != str.charAt(left)){
                    used[str.charAt(left)]= false;
                    left ++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }


    private static int getLongestLength_hash(String str){
        if(str == null || str.length() == 0) return 0;

        int left =0, right =0, max=0;
        int n = str.length();
        HashMap used = new HashMap<String, Boolean>();
        while(right < n){
            if(used.get(str.charAt(right))==null){
                used.put(str.charAt(right), true);
                right++;
            }else{
                max = Math.max(max, right - left);
                while(left<right && str.charAt(right) != str.charAt(left)){
                    used.remove(str.charAt(left));
                    left ++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }

    // 这个不对， 应该从下一个开始继续循环
    private static int getLength(String str) {
        int length = 0;
        for(int i=0; i< str.length(); i++){
            StringBuilder sb = new StringBuilder();
            if(sb.toString().indexOf(String.valueOf(str.charAt(i))) != -1){
                sb.append(String.valueOf(str.charAt(i)));
            }else {
                length = sb.toString().length();
                sb = new StringBuilder();
            }
        }
        return length;
    }

    // 犯了三个错误
    /*
    1) 两层循环 才对
    2） 注意index == -1
    3) 关于Math.max
     */
    private static int getLength_baoli(String str) {
        int length = 0;
        for(int i=0; i< str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                if (sb.toString().indexOf(str.charAt(j)) == -1) {
                    sb.append(String.valueOf(str.charAt(j)));
                } else {
                    // 开始少了这个Math
                    length = Math.max(length, sb.toString().length());
                    sb = new StringBuilder();
                }
            }
        }
        return length;
    }

    // 也不对
    private static int getLength2(String str) {
        int length = 0;
        for(int i=0; i< str.length(); i++){
            for(int j=i; j< str.length(); j++) {
                StringBuilder sb = new StringBuilder();
                if (sb.toString().indexOf(String.valueOf(str.charAt(j))) != -1) {
                    sb.append(String.valueOf(str.charAt(j)));
                } else {
                    length = sb.toString().length();
                    sb = new StringBuilder();
                }
            }
        }
        return length;
    }
}
