package jksj.linkedlist;

public class H1_stackViaLinkedList {
    private Node top =null;

    public void push(int value){
        Node newNode = new Node(value);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop(){
        if(top == null)
        {return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public void printAll(){
        Node p = top;
        while(p!= null){
            System.out.print(p.data + " ");
            p=p.next;
        }
        System.out.println();

    }

    public static void main(String[]  args){
        H1_stackViaLinkedList list = new H1_stackViaLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.printAll();
        list.pop();
        list.printAll();
        list.pop();
        list.printAll();
        list.pop();

    }
    private static class Node{
        private int data;
        private Node next;
        public void Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData(){
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
