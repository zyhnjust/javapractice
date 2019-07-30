package algri.binarytree.round2;

import java.util.Stack;

/**
 * @program: algriprac
 * @description:
 * @author: hzhang
 * @create: 2019-07-16 07:56
 *
 *
 *
 *  前序。
 *      一个stack 先打， 然后右边放进来 然后左边放进来。
 *   中序
 *      cur 和stack
 *      cur 不为空或者stack 不是空就放上去。
 *
 *   后序， 就是说找两个stack
 *      第一个先放一个。
 *      然后拿出来放到2， 对第一个左边有就放， 右边有也放。 循环
 *      最后二 倒序一下。
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
        System.out.println("\npost order no rec - n2");
        post_order_norecur2(n1);
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
//        if(n1 == null){
//            return;
//        }
//        Node tmp = n1;
//        System.out.println(n1.left);
//        while(n1.left != null){
//            tmp = tmp.left;
//            System.out.print(tmp.value);
//            if(tmp.right != null){
//
//            }
//        }
        if(n1 == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(n1);
        while(stack.size()!=0 ) {
            Node tmp = stack.pop();
            System.out.print(tmp.getValue());
            if (tmp.getRight() != null) {
                stack.push(tmp.getRight());
            }
            if (tmp.getLeft() != null) {
                stack.push(tmp.getLeft());
            }
        }

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
//        if(n1== null) return;
//
//        Stack<Node> stack = new Stack<>();
//        stack.push(n1);
//        while(stack.size() != 0){
//            while(n1.left !=null){
//                stack.push(n1.left);
//            }
//            Node tmp = stack.pop();
//            System.out.println(tmp.getValue());
//            if(n1.right != null){
//                stack.push(n1.right);
//            }
//
//        }
        if(n1 == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = n1;
        while(!stack.isEmpty() || cur!= null){

            if(cur != null){
                stack.push( cur);
                cur = cur.getLeft();
            }else{
                cur = stack.pop();
                System.out.print(cur.getValue());
                cur=cur.getRight();

            }

        }



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

        if(n1 == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(n1);
        while( !s1.isEmpty()){
            Node tmp = s1.pop();
            s2.push(tmp);
            if(tmp.left != null){
                s1.push(tmp.left);
            }
            if(tmp.right != null){
                s1.push(tmp.right);
            }

        }
        while(!s2.isEmpty()){
            Node tmp = s2.pop();
            System.out.print(tmp.getValue());
        }

    }


    private static void post_order_norecur2(Node n1) {
        if(n1 == null) return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(n1);
        while(!s1.isEmpty()){
            Node tmp = s1.pop();
            s2.push(tmp);
            if(tmp.left != null){
                s1.push(tmp.left);
            }
            if(tmp.right != null){
                s1.push(tmp.right);
            }

        }

        while(!s2.isEmpty()){
            Node tmp = s2.pop();
            System.out.print(tmp.value);
        }

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
