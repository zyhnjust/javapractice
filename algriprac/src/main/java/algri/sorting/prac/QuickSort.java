package algri.sorting.prac;


//自己写了， 然后参考一个 也是不行的。
public class QuickSort {
    public static void main(String[]  args){
//        int[] list = {8,2,3,5,7,3,4,1,10};
        int[] list = {8,2,5,7,3,4,1,10};
        printList(list);
        System.out.println();
        quickSort(list, 0, list.length-1);
        printList(list);

    }

    private static void printList(int[] list) {
        for(int i=0; i<list.length; i++){
            System.out.print(list[i]+" ");
        }
    }

    private static void quickSort(int[] list, int from, int to) {
        if(from < to){
            int pivot = findPivot(list, from, to);
//            int pivot = partition(list, from, to);
            quickSort(list, from, pivot);
            quickSort(list, pivot+1, to);
        }

    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];//取第一个元素为基准值

        while (true) {
            //从左往右扫描
            while (arr[left] <= pivot) {
                left++;
                if (left == right) {
                    break;
                }
            }

            //从右往左扫描
            while (pivot < arr[right]) {
                right--;
                if (left == right) {
                    break;
                }
            }

            //左右指针相遇
            if (left >= right) {
                break;
            }

            //交换左右数据
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        //将基准值插入序列
        int temp = arr[startIndex];
        arr[startIndex] = arr[right];
        arr[right] = temp;
        return right;
    }

    private static int findPivot(int[] list, int from, int to) {
        int pivot = (from + to)/2;
        int value = list[pivot];
        while(from < to){
            while(list[from]< value && from < to){
                from ++;
            }
            while(list[to]> value && from < to){
                to--;
            }
                int tmp=list[from];
                list[from]=list[to];
                list[to]=tmp;
        }
        int tmp=list[from];
        list[from]=list[to];
        list[to]=tmp;
//        return pivot; //this is not correct  1 2 3 4 5 3 7 8 10
        return from;
    }



}
