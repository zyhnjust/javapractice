package algri.offer;

/**
 * @program: algriprac
 * @description:
 * @author: hzhang
 * @create: 2019-07-16 07:30
 * https://www.weiweiblog.cn/find2array/
 *  意思差不多。
 **/
public class H_searchTwoDimen_03 {
    public static void main(String[]  args){
        int[][] target = new int[][]{{1,2,3,5,6}, {7,8,9,11,12},{17,18,19,21,22}, {37,38,39,31,32}, {47,48,49,51,52}};
        for(int i = 0; i< target.length; i++){
            for(int j=0; j< target[0].length; j++){
                if(j==0){
                    System.out.println();
                }
                System.out.print(target[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println(target);

        int number  = 5;
        System.out.println(exist(target, number));
        System.out.println(exist(target, 47));
        System.out.println(exist(target, 40));
    }

    private static boolean exist(int[][] target, int number) {
        if (target.length ==0 || target[0].length == 0){ //后面这个判断真的有意义么
            return false;
        }
        int k = 0;
        int l = target[0].length-1;
        while(0<=k && k<target.length && 0<=l && l<target[0].length){
            System.out.println(target[k][l]);
            if(number > target[k][l]){
                k+=1;
            }else if(number<target[k][l]){
                l-=1;
            }else{
                return true;
            }
        }
        return false;
    }

    //copy
    public boolean Find(int target, int [][] array) {
        if(array.length==0 || array[0].length==0)
            return false;
        int m = array[0].length-1;
        int n = 0;
        int temp = array[n][m];
        while(target != temp){
            if(m>0 && n<array.length-1){
                if(target>temp){
                    n = n + 1;
                }else if(target<temp){
                    m = m - 1;
                }
                temp = array[n][m];
            }else{
                return false;
            }
        }
        return true;
    }


}
