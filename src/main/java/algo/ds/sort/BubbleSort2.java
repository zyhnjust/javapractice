package algo.ds.sort;

public class BubbleSort2 {

	/**
	 * 冒泡排序的第一种实现, 没有任何优化
	 * @param a
	 * @param n
	 */
	public static void bubbleSort1(int [] a, int n){
	    int i, j;

	    for(i=0; i<n; i++){//表示n次排序过程。
	        for(j=1; j<n-i; j++){
	            if(a[j-1] > a[j]){//前面的数字大于后面的数字就交换
	                //交换a[j-1]和a[j]
	                int temp;
	                temp = a[j-1];
	                a[j-1] = a[j];
	                a[j]=temp;
	            }
	        }
	    }
	}// end
	
	/**
	 * 设置一个标志，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
	 * @param a
	 * @param n
	 */
	public static void bubbleSort2(int [] a, int n){
	    int j, k = n;
	    boolean flag = true;//发生了交换就为true, 没发生就为false，第一次判断时必须标志位true。
	    while (flag){
	        flag=false;//每次开始排序前，都设置flag为未排序过
	        for(j=1; j<k; j++){
	            if(a[j-1] > a[j]){//前面的数字大于后面的数字就交换
	                //交换a[j-1]和a[j]
	                int temp;
	                temp = a[j-1];
	                a[j-1] = a[j];
	                a[j]=temp;

	                //表示交换过数据;
	                flag = true;
	            }
	        }
	        k--;//减小一次排序的尾边界
	    }//end while
	}//end
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] arr = {1,1,2,0,9,3,12,7,8,3,4,65,22};

	    BubbleSort2.bubbleSort1(arr, arr.length);

	    //优化了一下， 就是加了个flage
	    BubbleSort2.bubbleSort2(arr, arr.length);

	    for(int i:arr){
	        System.out.print(i+",");
	    }
	}

}
