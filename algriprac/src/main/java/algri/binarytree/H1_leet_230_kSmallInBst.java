package algri.binarytree;

import java.util.Stack;

/**
 * @program: algriprac
 * @description:
 * @author: hzhang
 * @create: 2019-07-18 08:18
 **/
public class H1_leet_230_kSmallInBst {


    public static void main(String[]  args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n6.setLeftChild(n4);
        n6.setRightChild(n7);
        n4.setLeftChild(n2);
        n4.setRightChild(n5);
        n2.setLeftChild(n1);
        n2.setRightChild(n3);
        n6.setRightChild(n7);
        n7.setRightChild(n8);

        try{
            System.out.println(((Node)kthSmallest(n6, 4)).getData());
            System.out.println(((Node)kthSmallest(n6, 2)).getData());
            System.out.println(((Node)kthSmallest(n6, 6)).getData());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static Node kthSmallest(Node n6, int k) {

        if(n6== null) return null;
        Stack<Node> stack = new Stack<>();

        int i=0;
        Node cur = n6;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
//                System.out.print(cur.getData());
                stack.push(cur);
                cur = cur.getLeftChild();

            }else{
                cur = stack.pop();
//                System.out.print(cur.getData());
                i=i+1;
                if(i == k){
                    return cur;
                }
                cur = cur.getRightChild();
            }

        }

        return null;
    }

    private static class Node{
        private Node leftChild;
        private Node rightChild;
        private int data;

        public Node(int data){
            this.leftChild=null;
            this.rightChild=null;
            this.data= data;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

}
