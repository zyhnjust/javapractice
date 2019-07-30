package algri.string;

/**
 * created by hzhang on 10:05 AM$  6/26/2019
 **/
public class LongestCommonPre_H_01 {



    // Driver program to test above function
    public static void main(String args[])
    {
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.length;

        String ans = commonPrefix(arr, n);

        if (ans.length() > 0)
            System.out.println("The longest common"
                    + " prefix is " + ans);
        else
            System.out.println("There is no common"
                    + " prefix");
    }

    private static String commonPrefix(String[] arr, int n) {
        if (n==0) return "";

        // 用哪种思路呢， 暴力的。 每个比较的那个
        String tmp = arr[0];
        for (int i=1; i< n; i++){
            tmp = getCommon(tmp, arr[i]);

        }
        return tmp;
    }

    private static String getCommon(String tmp, String s) {
        int i=0;
        while (i<tmp.length() && i<s.length() && tmp.charAt(i)==s.charAt(i)){
            i++;
        }
        return tmp.substring(0,i+1);
    }
}
