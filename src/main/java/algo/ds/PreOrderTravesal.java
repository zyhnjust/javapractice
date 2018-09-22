package algo.ds;

import java.util.Stack;

class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		left=right=null;
	}
}

public class PreOrderTravesal {
	Node root;

	private void iteratorPreorder() {
		iteratorPreorder(root);
	}	
	
	
	private void iteratorPreorder(Node node) {
		if(node == null){
			return;
		}
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(node);
		
		while(!nodeStack.isEmpty()){
//			option 1
//			Node myNode = nodeStack.pop();

//			option 2
			Node myNode = nodeStack.peek();
			System.out.println(myNode.data);
			nodeStack.pop();
			
			if(myNode.right != null){
				nodeStack.push(myNode.right);
			}
			if(myNode.left != null){
				nodeStack.push(myNode.left);
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreOrderTravesal tree = new PreOrderTravesal();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(51);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(1);
		tree.iteratorPreorder();
	}
}
