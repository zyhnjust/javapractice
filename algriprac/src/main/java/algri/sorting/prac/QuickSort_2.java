package algri.sorting.prac;


// this evening, try it again.

//快速排序
//        1 基本思路
//        找到partition
//        可以从begin 开始
//        找到后面大于的如果
//        2 首先设置为start
//        然后呢， 后面如果有小于的， 前面有大于的， 两个交换。
//        知道最后一个和start 换一下， 这个点就是start 应该的位置。
//        -- 有没有可能正好有个
//        而且对于等值的也是好的。
public class QuickSort_2 {

    public static void main(String[]  args){
        int[] list = {8,2,3,5,7,3,4,1,10};
//        int[] list = {8,2,5,7,3,4,1,10};
        printList(list);
        System.out.println();
        quickSort(list, 0, list.length-1);
        printList(list);
    }

    private static void quickSort(int[] list, int start, int end) {
        if(start<end){
            int parttion = getPartition(list, start, end);
            quickSort(list, start, parttion-1);
            quickSort(list, parttion+1, end);
        }
    }

    private static int getPartition(int[] list, int start, int end) {
        int i=start;
        int j=end;
        int pivot = list[start];
        while(i < j){
            while(list[j]>=pivot && i<j){
                j--;
            }
            while(list[i]<=pivot && i<j) {
                i++;
            }
            int tmp=list[i];
            list[i]= list[j];
            list[j] = tmp;
        }
        list[start] = list[i];
        list[i]=pivot;
        return i;
    }

    private static void printList(int[] list) {
        for(int i=0; i<list.length; i++){
            System.out.print(list[i]+" ");
        }
    }
}
