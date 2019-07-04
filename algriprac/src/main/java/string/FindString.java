package string;

public class FindString {


    public static void main(String[] args){
        int[] list= new int[]{1,4,5,7,9,11};
        int target = 6;
        int position = findPosition(list, target);
        System.out.println("positions is: " + position);
    }

    private static int findPosition(int[] list, int target) {
        int from=0;
        int to=list.length-1;
        while (from < to) {
            int tmp = (from + to) / 2;
            if (list[tmp] < target) {
                from = tmp + 1;
            } else if (list[tmp] > target) {
                to = tmp - 1;
            } else {
                return tmp;
            }
        }
        return from;
    }
}
