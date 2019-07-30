package algri.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class H1_preOrder {


    public static void preOrderRecur(Node node){
        if(node!=null){
            System.out.print(node.getData());
            preOrderRecur(node.leftChild);
            preOrderRecur(node.rightChild);
        }
    }

    public static void preOrderNoRecu(Node node){
        if(node == null){
          System.out.println("No record");
          return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while(stack.size()>0) {
            Node tmp = stack.pop();
            System.out.print(tmp.getData() + " ");
            if (tmp.getRightChild() != null) {
                stack.add(tmp.getRightChild());
            }
            if (tmp.getLeftChild() != null) {
                stack.add(tmp.getLeftChild());
            }
        }

    }

    public static void inOrder(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        Node cur = root;
        while( !stack.isEmpty() || cur != null){
            if(cur!= null){
                stack.push(cur);
                cur = cur.getLeftChild();
            }else {
                cur = stack.pop();
                System.out.println(cur.getData());
                cur=cur.getRightChild();
            }

        }

    }

    public static void postOrder_twoStack(Node node) {
        if (node == null) return;
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            Node tmp = stack1.pop();
            stack2.add(tmp);
            if (tmp.getLeftChild() != null) {
                stack1.push(tmp.getLeftChild());
            }
            if (tmp.getRightChild() != null) {
                stack1.push(tmp.getRightChild());
            }
        }
        while (!stack2.isEmpty()) {
            Node tmp = stack2.pop();
            System.out.print(tmp.getData());
        }
    }

//    public List<Integer> postorderTraversal(Node root) {
//        LinkedList<Integer> result = new LinkedList<>();
//        Stack<Node> stack = new Stack<Node>();
//        Node p = root;
//        while(!stack.isEmpty() || p != null) {
//            if(p != null) {
//                stack.push(p);
//                result.addFirst(p.val);  // Reverse the process of preorder
//                p = p.getRightChild();             // Reverse the process of preorder
//            } else {
//                Node node = stack.pop();
//                p = node.getLeftChild();           // Reverse the process of preorder
//            }
//        }
//        return result;
//    }

    public static void main(String[]  args){
        Node hNode = new Node(1);
        Node a1Node = new Node(2);
        Node a2Node = new Node(3);
        Node a3Node = new Node(4);
        Node a4Node = new Node(5);
        hNode.setLeftChild(a1Node);
        hNode.setRightChild(a2Node);
        a1Node.setLeftChild(a3Node);
        a1Node.setRightChild(a4Node);

        //     1
        //   /  \
        //   2   3
        //  / \
        // 4   5
//        preOrderRecur(hNode);
//        System.out.println();
//
//        preOrderNoRecu(hNode);

//        inOrder(hNode);

        postOrder_twoStack(hNode);
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
