package algri.sorting;

import java.util.Arrays;

// dead lock
public class H1_quicksort {



    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        quicksort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static int[] quicksort(int[] array, int start, int end) {
        int pivot = array[(start + end)/2];
        int from = start;
        int to = end;
        while(from < to){
            while(array[from]<pivot)
            {
                from++;
            }
            while(pivot<array[to]){
                to--;
            }
            if(from < to){
                int tmp = array[from];
                array[from]=array[to];
                array[to]=tmp;
            }

        }
        quicksort(array, start, from);
        quicksort(array, from+1, end);
        return array;
    }

}
