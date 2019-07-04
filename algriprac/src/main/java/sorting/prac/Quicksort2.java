package sorting.prac;

public class Quicksort2 {

    public static void main(String[]  args){
        int[] list = {8,2,3,5,7,3,4,1,10};
        printList(list);
        System.out.println();
        quickSort(list);
        printList(list);

    }

    private static void printList(int[] list) {
        for(int i=0; i<list.length; i++){
            System.out.print(list[i]+" ");
        }
    }
    private static boolean isEmpty(int[] n) {
        return n == null || n.length == 0;
    }

    // ///////////////////////////////////////////////////
    /**
     * 快速排序算法思想——挖坑填数方法：
     *
     * @param n 待排序的数组
     */
    public static void quickSort(int[] n) {
        if (isEmpty(n))
            return;
        quickSort(n, 0, n.length - 1);
    }

    public static void quickSort(int[] n, int l, int h) {
        if (isEmpty(n))
            return;
        if (l < h) {
            int pivot = partion(n, l, h);
            quickSort(n, l, pivot - 1);
            quickSort(n, pivot + 1, h);
        }
    }

    private static int partion(int[] n, int start, int end) {
        int tmp = n[start];
        while (start < end) {
            while (n[end] >= tmp && start < end)
                end--;
            if (start < end) {
                n[start++] = n[end];
            }
            while (n[start] < tmp && start < end)
                start++;
            if (start < end) {
                n[end--] = n[start];
            }
        }
        n[start] = tmp;
        return start;
    }
}