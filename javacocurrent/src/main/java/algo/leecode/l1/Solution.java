/**
 * 
 */
package java_base.algo.leecode.l1;

/**
 * @author Homer
 *
 */
public class Solution {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,2,2,3,4,5,};
		int target = 7;
		int[] res = twoSum(nums, target);
		System.out.println("res: " + res[0] + "; " + res[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0; i< nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(target == nums[i] + nums[j]){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }    
            }
        }
        return res;
    }

}
