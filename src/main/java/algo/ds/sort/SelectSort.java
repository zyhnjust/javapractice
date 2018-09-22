package algo.ds.sort;

import java.util.Arrays;


//first time
public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={4,3,5,6,7,8,1,6,9};
		int length=arr.length;
		selectSort(arr,length);
//		System.out.println(arr);  // 这里错了， 不能直接打印。 

		System.out.println(Arrays.toString(arr));
		
		//or
	    for(int i:arr){
	        System.out.print(i+",");
	    }
	}

	private static void selectSort(int[] arr, int length) {
		// TODO Auto-generated method stub
		for (int i=0;i<length; i++){
			int min = i;
			for (int j=i+1; j<length; j++){
				if(arr[i]>arr[j]){
					min = j;
				}
			}
			if(min !=i){
				int tmp = arr[i];
				arr[i]=arr[min];
				arr[min]=tmp;
			}
			
		}
		
	}

}
