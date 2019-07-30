package algri.sorting;

import java.util.Arrays;

public class H1_InsertSort {


    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        int[] result= insertSort(array);
        System.out.println(Arrays.toString(result));

        int[] array1 = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        int[] result1= insertSort2(array1);
        System.out.println(Arrays.toString(result1));

    }

    // self write first time
    public static int[] insertSort(int[] array) {
        int n = array.length;
        for(int i=1; i< n; i++){
            int j =0;
            while(array[j]< array[i] && j<i){
                j++;
            }
            int tmp = array[i];
            for(int k=i;k>j;k--){
                array[k]=array[k-1];
            }
            array[j]=tmp;
        }
        return array;
    }

    //自己那个不好有很大的冗余， 因为对比和交换可以一轮做。 这样写的好很多。
    private static int[] insertSort2(int[] array){
        int n= array.length;
        for(int i=1; i<n; i++){
            int value = array[i];
            int j=0;
            for(j=i-1; j>=0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = value;
        }
        return array;
    }

}
