package algri.linkedlist;

public class H1_stackViaArray {
    private String[] items;
    private int count;
    private int n;

    public H1_stackViaArray(int n){
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    public Boolean push(String value){
        if(count == n)return false;
        items[count] = value;
        ++ count;
        return true;
    }
    public String pop(){
        if(count == 0) return null;
        String tmp = items[count-1];
        count --;
        return tmp;
    }
    public void printAll(){
        if(count == 0)
            System.out.print("No records");
        for(int i=count-1; i>=0 ; i--){
            System.out.print(items[i] +" ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        H1_stackViaArray arrayStack = new H1_stackViaArray(10);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.printAll();
        arrayStack.pop();
        arrayStack.printAll();
        arrayStack.pop();
        arrayStack.printAll();
        arrayStack.pop();
        arrayStack.printAll();



    }
}
