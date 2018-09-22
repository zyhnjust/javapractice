package algo.ds.linklist;


class Node{
	Node next;
	int data;
	public Node(int number){this.data=number;next=null;}
}

public class reverselist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node a = new Node(5);
		Node b = new Node(1);
		Node c = new Node(9);
		a.next =b;
		b.next =c;
		printLinkedNode(a);
		Node reverseNode = reverseLinkedList(a);

		System.out.println("After reverse ");
		printLinkedNode(reverseNode);
	}

	private static void printLinkedNode(Node a) {
		if(a==null)return;
		System.out.println(a.data);
		while (a.next != null ) {
			a = a.next;
			System.out.println(a.data);
		}
	}

	private static Node reverseLinkedList(Node a) {
		if(a==null || a.next==null){
			return a;
		}
		
		Node pre = null;
		Node curr = a;
		Node next = null;
		while(curr !=null){
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}

}
