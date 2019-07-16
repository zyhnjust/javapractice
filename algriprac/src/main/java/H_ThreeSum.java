import sorting.H1_InsertSort;
import sorting.H1_quicksort;

import java.util.*;

/**
 * @program: algriprac
 * @description:  第一遍错了很多
         * 1 -1  -1  2
         * 	- 多次使用一个的时候。
         * 2
         * -6  2  4
         * -6  2  4
         * 还是有重复的呢。
         *
         * 3 怎么搞
 * @author: hzhang
 * @create: 2019-07-05 08:39
 **/
public class H_ThreeSum {


    private static HashSet getThreeSums_1(int[] list) {
        HashSet resultSet = new HashSet<>();
        if(list.length<3) return resultSet;

        for(int i=0; i< list.length; i++){
            int target = 0-list[i];
            int[] three= getTwoSum(list, i, target);
            if(three != null){
                int[] tmp = sortIn(three);
                resultSet.add(three);
            }
        }
        return resultSet;
    }

    private static int[] sortIn(int[] three) {
        return (int[]) H1_InsertSort.insertSort(three);
    }



    private static int[] getTwoSum(int[] list, int i, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        // how to put
        for(int j=0; j< list.length; j++){
            map.put(list[j], 0);
        }
        for(int k=0; k< list.length; k++){
            int tmp = target - list[k];
            if(map.get(tmp) != null){
                return new int[]{list[i], list[k], tmp};
            }

        }
        return null;

    }


    public static void main(String[] args){
        int[] list= new int[]{2,4,1,-2,-1,9,5,-6,7,3,-7};
        HashSet tuples = getThreeSums_1(list);
        Iterator it = tuples.iterator();
        while(it.hasNext()){
            int[] print = (int[]) it.next();
            System.out.println(print[0] + "  " + print[1] + "  " + print[2]);
        }
    }

}
