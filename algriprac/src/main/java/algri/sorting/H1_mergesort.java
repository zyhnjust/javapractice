package algri.sorting;

import java.util.Arrays;


/*
Homer works for now 0611
 */
public class H1_mergesort {



    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        int[] result= mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }

        int q = start+(end-start)/2;
//        int q = (start+end)/2;
        mergeSort(array, start, q);
        mergeSort(array, q+1, end);
        merge(array, start, q, end);
        return array;
    }

    private static void merge(int[] array, int start, int q, int end) {
        int i=start;
        int j=q+1;
        int k=0;
        int[] tmp = new int[end-start+1];
        while(i<=q && j<= end){
            if(array[i]<=array[j]){
                tmp[k++]=array[i++];
            }else{
                tmp[k++]=array[j++];
            }
        }
        int from=0;
        int to=0;
        if(j<=end){
            from=j;
            to = end;
        }
//        if(i<=q){
//        会出来 1332 什么的， 就是说如果后面大的没有赋值给to。 这是不对的。
        if(i<=q){
            from=i;
            to=q;
        }

        while(from <= to){
            tmp[k++] = array[from++];
        }

        //copy back
//        for(i=0; i< end-start; i++){
        for(i=0; i<= end-start; ++i){
            array[start+i]= tmp[i];
        }
    }

}
