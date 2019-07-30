package algri.linkedlist;

//基于单链表实现LRU

import java.util.Scanner;

public class LRUBaseLinkedList<T> {

    private final static Integer DEFAULT_CAPACITY = 10;
    private SNode<T> headNode;
    private Integer length;
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<T>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }
    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<T>();
        this.length = 0;
        this.capacity = capacity;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);
        if(preNode !=null){
            deleteElemOptim(preNode);
            intsertElemAtBegin(data);
        }else{
            if(length >= this.capacity){
                deleteElemAtEnd();
            }
            intsertElemAtBegin(data);
        }
    }

    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }
    private void intsertElemAtBegin(T data) {
        SNode tmp = new SNode(data);
        tmp.setNext(headNode.getNext());

        headNode.setNext(tmp);
        length ++;
//        SNode next = headNode.getNext();
//        headNode.setNext(new SNode(data, next));
//        length++;

    }
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while(node.getNext()!= null){
            if (data.equals(node.getNext().getElement())){
                return node;
            }
            node= node.getNext();
        }
        return null;
    }

    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        if(ptr.getNext()==null){
            return;
        }

//         其实获取的是这个的下两个是否在， 如果不在那就
        while(ptr.getNext().getNext()!=null){
            ptr = ptr.getNext();
        }
        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length --;

    }
    private void printAll() {
        SNode node = headNode.getNext();
        while(node != null){
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.print("...");
    }

    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode() {
            this.next = null;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args){
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while(true){
            list.add(sc.nextInt());
            list.printAll();
        }

    }

}
