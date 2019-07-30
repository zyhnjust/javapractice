package algri;

/**
 * @program: algriprac
 * @description:
 * @author: hzhang
 * @create: 2019-07-12 08:54
 **/
public class H_binarySearch01 {

    public static void main(String[] args){
        int[] list = new int[]{1,2,4,5,6,7,8,9};
        int target =6;
        System.out.println(binarysearch(list, list.length, target));
    }

    private static int binarysearch(int[] list, int length, int target) {


        int low =0;
        int high = length-1;
        while(low <= high){
            int n = low+(high-low)/2;
            if(list[n] == target){
                return n;
            }else if(list[n] < target){
                low = n;
//                n = (high - n)/2 + n;
            }else{
                high = n;
//                n = low + (n-low)/2;
            }
        }
        return -1;
    }

}
