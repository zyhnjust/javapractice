package algo.ds.tree;

import java.util.Stack;


public class InOrderTravesal {

	Node root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InOrderTravesal tree = new InOrderTravesal();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(51);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(1);
		tree.iteratorInorder();
	}

	private void iteratorInorder() {
		iteratorInorder(root);
	}

	private void iteratorInorder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node current = node;

		if(node == null){
			return;
		}
		
		// should be || rather than &&
		while(current!=null || !stack.isEmpty()){
			// heap outof memory
//			while(current.left !=null){
			while(current !=null){
				stack.push(current);
//				current = node.left;
				current = current.left;
			}
//			Node pnode = stack.pop();
			current=stack.pop();
			System.out.println(current.data);
			current=current.right;
		}
		
	}

}
