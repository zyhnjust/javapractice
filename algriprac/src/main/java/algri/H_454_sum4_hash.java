package algri;

import java.util.HashMap;

/**
 * @program: algriprac
 * @description:
 * 并没有要求把这个打印出来。 
 * @author: hzhang
 * @create: 2019-07-09 07:05
 **/
public class H_454_sum4_hash {



    public static void main(String[] args){
        int[] a = new int[]{2,3,-8,-4,-1};
        int[] b = new int[]{-2,-3,5,6,-1};
        int[] c = new int[]{2,3,4,-4,-1};
        int[] d = new int[]{1,5,-2,-4,-3};
        System.out.println(getFre(a, b, c, d));
    }

    private static int getFre(int[] a, int[] b, int[] c, int[] d) {

        HashMap ab = new HashMap();
        for(int i=0; i< a.length; i++){
            for(int j=0; j< b.length; j++){
                int sum = i+j;
                if(ab.get(sum)!=null){
                    int num = Integer.valueOf(ab.get(sum).toString());
                    num++;
                    ab.put(sum, num);

                }else{
                    ab.put(sum, 1);
                }
            }
        }
        int count=0;
        for(int i=0; i< c.length; i++){
            for(int j=0; j< d.length; j++){
                int sum = -(i+j);

                if(ab.get(sum)!=null){
                    int num = Integer.valueOf(ab.get(sum).toString());
                    count += num;
                }
            }
        }
        return count;
    }
}
