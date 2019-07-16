import java.util.HashSet;
import java.util.Iterator;

/**
 * @program: algriprac
 * @description:
 * @author: hzhang
 * @create: 2019-07-07 10:02
 **/
public class H_349_intersection {


    public static void main(String[]  args){
        int[] nums1 = new int[]{1,2,2,1}, nums2 = new int[]{2,2};
        HashSet set  = getinter(nums1, nums2);
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println((int)it.next());
        }

    }

    private static HashSet getinter(int[] nums1, int[] nums2) {
        HashSet base = new HashSet();
        HashSet result = new HashSet();

        for(int i=0; i< nums1.length; i++){
            base.add(nums1[i]);
        }
        for(int i=0; i< nums2.length; i++){
            if(base.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        return result;

    }
}
