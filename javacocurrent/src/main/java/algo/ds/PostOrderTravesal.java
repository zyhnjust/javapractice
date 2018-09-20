package algo.ds;

import java.util.Stack;

public class PostOrderTravesal {
	Node root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostOrderTravesal tree = new PostOrderTravesal();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(51);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(1);
		tree.iteratorPostorder();
	
	}

	private void iteratorPostorder() {

		Node current = root;
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		if (current == null){
			return;
		}
		s1.push(current);
		while (!s1.isEmpty()){
			current = s1.pop();
			s2.push(current);
			if(current.left !=null){
				s1.push(current.left);
			}
			if (current.right != null){
				s1.push(current.right);
			}
		}
		while(!s2.isEmpty()){
			System.out.println(s2.pop().data);
		}
		
	}

}
