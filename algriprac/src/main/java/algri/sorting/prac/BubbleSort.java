package algri.sorting.prac;

import java.lang.reflect.Array;
import java.util.Arrays;

import static jdk.nashorn.internal.objects.Global.print;

public class BubbleSort {

    public static void main(String[]  args){
        int[] list = {8,2,3,5,7,3,4,1,10};
        printList(list);
        System.out.println();
        bubbleSort(list, list.length);
        printList(list);

    }

    private static void printList(int[] list) {
        for(int i=0; i<list.length; i++){
            System.out.print(list[i]+" ");
        }
    }

    private static void bubbleSort(int[] list, int length) {

        for(int i=0; i< length-1; i++){
            boolean flag= false;
            for(int j=0; j< length-1-i; j++)
                if(list[j]>list[j+1]){
                    int tmp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=tmp;
                    flag=true;
            }
            if(!flag )break;

        }
    }

}
