package sorting;

import java.util.Arrays;

public class H_quicksort2 {



    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        int[] result= quicksort(array, 0, array.length-1);
        System.out.println(Arrays.toString(result));
    }

    private static int[] quicksort(int[] array, int start, int end) {
        if(start < end){
            int index = partition(array, start, end);
            quicksort(array, start, index);
            quicksort(array, index+1, end);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
        int from = start;
        int to = end;
        while (from < to) {
            while (array[from] < pivot) {
                from++;
            }
            while (pivot < array[to]) {
                to--;
            }
            if (from < to) {
                int tmp = array[from];
                array[from] = array[to];
                array[to] = tmp;
            }
        }
        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
        return from;
    }

}
