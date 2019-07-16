package binarytree.round2;

/**
 * @program: algriprac
 * @description:
 * @author: hzhang
 * @create: 2019-07-16 07:56
 **/
public class PreOrder {

/*
        4
       / \
      5   2
       \ / \
       6 1  3
 */
    public static void main(String[]  args){
        Node n1 = new Node(4);
        Node n2 = new Node(5);
        Node n3 = new Node(6);
        Node n4 = new Node(1);
        Node n5 = new Node(2);
        Node n6 = new Node(3);
        n1.left = n2;
        n1.right = n5;
        n2.right = n3;
        n5.left = n4;
        n5.right = n6;

        System.out.println("\nleft rec");
        pre_order_recur(n1);
        System.out.println("\nleft no rec");
        pre_order_norecur(n1);
        System.out.println("\nin order rec");
        in_order_recur(n1);
        System.out.println("\nin order no rec");
        in_order_norecur(n1);
        System.out.println("\npost order rec");
        post_order_recur(n1);
        System.out.println("\npost order no rec");
        post_order_norecur(n1);
        System.out.println();


    }

    private static void pre_order_recur(Node n1) {
        System.out.print(n1.value);
        if(n1.left != null){
            pre_order_recur(n1.left);
        }
        if(n1.right != null){
            pre_order_recur(n1.right);
        }

    }

    private static void pre_order_norecur(Node n1) {
        


    }

    private static void in_order_recur(Node n1) {
        if(n1.left != null){
            in_order_recur(n1.left);
        }
        System.out.print(n1.value);
        if(n1.right != null){
            in_order_recur(n1.right);
        }
    }

    private static void in_order_norecur(Node n1) {
    }

    private static void post_order_recur(Node n1) {
        if(n1.left != null){
            post_order_recur(n1.left);
        }
        if(n1.right != null){
            post_order_recur(n1.right);
        }
        System.out.print(n1.value);
    }

    private static void post_order_norecur(Node n1) {
    }




    static class Node{
        int value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
