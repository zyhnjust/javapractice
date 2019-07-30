package algri.sorting.prac;

public class QuickSort_anotherTwoSide {
    public static void main(String[]  args){
//        int[] list = {8,2,3,5,7,3,4,1,10};
        int[] list = {8,2,5,7,3,4,1,10};
        printList(list);
        System.out.println();
        quickSort(list, 0, list.length-1);
        printList(list);

    }

    private static void quickSort(int[] list, int from, int to) {
        if(from < to){
            int pivot = findPivot(list, from, to);
//            int pivot = partition(list, from, to);
            quickSort(list, from, pivot-1);  // 为什么要-1 呢， 这个是key。
//            quickSort(list, from, pivot);
            quickSort(list, pivot+1, to);
        }
    }

    private static int findPivot(int[] list, int from, int to) {
        // two sides
        int pivot = list[to];
        while (from < to) {
            while (list[from] <= pivot && from < to) {
                from++;
            }
            if (from < to) {
                int temp = list[from];
                list[from] = list[to];
                list[to] = temp;
                to--;
            }
//            while (list[to] > pivot && from < to) {
            while (list[to] >= pivot && from < to) {
                to--;
            }
            if (from < to) {
                int temp = list[from];
                list[from] = list[to];
                list[to] = temp;
                from++;
            }
        }
//        return from;
        return to;
    }

    private static void printList(int[] list) {
        for(int i=0; i<list.length; i++){
            System.out.print(list[i]+" ");
        }
    }
    
    
}
