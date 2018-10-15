package algo.ds.sort;

import java.util.Arrays;

public class InsertSort {


    public static void main(String[] args) {
        int a[] = { 49,38,65,97,76,13,27,49 };
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

	private static void insertSort(int[] a) {
		// TODO Auto-generated method stub
		if (a== null || a.length <=1){
			return;
		}

		int i,j, insertNote;
		for(i=1; i< a.length;i++){
			insertNote=a[i];
			j=i-1;
			while(j>=0 && insertNote<a[j]){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=insertNote;
		}
		
//		int currentIndex =0;
//		for(int i=1; i< a.length; i++){
//			for(int j=i; j < a.length; j++){
//				while(a[i] < a[j]){
//					j--;
//				}
//				for(int k=0; k<j; k++){
//					
//				}
//			}
//		}
	}
    
}
