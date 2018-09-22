package algo.ds.linklist;

public class CombineTwoLinkedList_recur {

	static class Node{
		Node next;
		int data;
		Node(int num){
			data = num;
			next = null;
		}
	}
	static Node head = null;

	public static void main(String[] args) {
		
		Node a1 = new Node(1);
		Node b1 = new Node(5);
		Node c1 = new Node(9);
		a1.next =b1;
		b1.next =c1;
		
		Node a2 = new Node(2);
		Node b2 = new Node(4);
		Node c2 = new Node(8);
		a2.next =b2;
		b2.next =c2;
		
		System.out.println("a1");
		printLinkedList(a1);
		System.out.println("a2");
		printLinkedList(a2);
		head = combineLinkedList(head, a1,a2);
		System.out.println("combine: ");
		printLinkedList(head);
	}

	private static void printLinkedList(Node head2) {
		// TODO Auto-generated method stub
		while(head2!=null){
			System.out.println(head2.data);
			head2 = head2.next;
		}
	}

	private static Node combineLinkedList(Node head, Node a1, Node a2) {
		if(a1==null){
			return a2;
		}
		if(a2==null){
			return a1;
		}
		
		if (a1.data < a2.data){
			head=a1;
			a1=a1.next;
		}else{
			head =a2;
			a2 = a2.next;
		}
		head.next = combineLinkedList(head.next, a1, a2);
		return head;
		
	}

}



