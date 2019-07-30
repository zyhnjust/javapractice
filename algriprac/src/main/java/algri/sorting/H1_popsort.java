package algri.sorting;

import java.util.Arrays;

public class H1_popsort {


    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        int[] result= popsort(array);
        System.out.println(Arrays.toString(result));

        int[] array1 = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        int[] result1= bubblesort(array1);
        System.out.println(Arrays.toString(result1));
    }

    // 这里可以优化 就是如果没有交换了 其实就不需要进行下一步的了。
    private static int[] bubblesort(int[] a) {
        if (a.length <= 1) return a;

        int n = a.length;
        for (int i = 0; i < n; ++i) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }

        return a;
    }

    private static int[] popsort(int[] array) {
        if(array== null || array.length <=1) return array;
        for(int i=0; i< array.length; i++){
            for(int j=i+1;j<array.length; j++){
                if(array[i]> array[j]){
                    int tmp = array[i];
                    array[i]=array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }
}
