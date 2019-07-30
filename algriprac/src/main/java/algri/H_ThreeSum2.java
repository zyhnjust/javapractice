package algri;

import java.util.*;

/**
 * @program: algriprac
 * @description: 
 * @author: hzhang
 * @create: 2019-07-05 08:39
 **/
public class H_ThreeSum2 {
    

    public static void main(String[] args){
        int[] list= new int[]{2,4,1,-2,-1,9,5,-6,7,3,-7};
        List tuples = getThreeSums_1(list);
        Iterator it = tuples.iterator();
        while(it.hasNext()){
            ArrayList print = (ArrayList) it.next();
            System.out.println(print);
        }
    }

    private static List getThreeSums_1(int[] list) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(list);

        for( int i=0; i< list.length-2; i++){
            int target = 0 - list[i];
            if(i>0 && list[i] == list[i+1]){  // http://www.goodtecher.com/zh/leetcode-15-3sum-%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C/ i-1 should be incorrect

                continue;
            }
            int left = i+1;
            int right = list.length-1;
            getTwoSum(list, results, target, left, right);
        }
        return results;
    }

    private static void getTwoSum(int[] list, List<List<Integer>> results, int target, int left, int right) {
        while(left < right){
            if(list[left] + list[right] == target){
                ArrayList res = new ArrayList();
                res.add(-target);
                res.add(list[left]);
                res.add(list[right]);
                results.add(res);
                left++;
                right--;
                while(left < right && list[left]==list[left-1]){
                    left ++;
                }
                while(left < right && list[right] == list[right-1]){
                    right--;
                }

            }else if (list[left] + list[right] > target) {
                right--;
            } else if (list[left] + list[right] < target) {
                left++;
            }
        }

    }

}
