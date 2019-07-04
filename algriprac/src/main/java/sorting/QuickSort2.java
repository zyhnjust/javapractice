package sorting;


//first version, dead lock. 
public class QuickSort2 {

	public static void main(String[] args) {
		QuickSort2 qs = new QuickSort2();
		int[] arr = {2,7,3,1,0,9,6,5,8};
		int[] result= qs.sort(arr, 0, arr.length-1);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);			
		}
	}

	private int[] sort(int[] arr, int start, int end) {
		if(start < end) {
			int index = partition(arr, start, end);
			
			sort(arr, 0, index);
			sort(arr, index+1, end);
		}
		return arr;
	}
		
	private int partition(int[] arr, int start, int end) {
		int pivot= arr[(start+end)/2];
		int from=start;
		int to = end;
		while(from< to) {
			while(arr[from]<pivot) {
				from++;
			}
			while(pivot<arr[to]) {
				to--;
			}
			if(from<to) {
				int tmp=arr[from];
				arr[from]= arr[to];
				arr[to]= tmp;
			}
		}
		int tmp=arr[from];
		arr[from]= arr[to];
		arr[to]= tmp;

		return start;
	}

}

