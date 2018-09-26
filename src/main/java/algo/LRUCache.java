package algo;

import java.util.HashMap;

class Node{
	int key;
	int value;
	Node pre;
	Node next;
	public Node(int key, int value) {
		this.key =key;
		this.value = value;
	}
}

public class LRUCache {
	Node head;
	Node next;
	HashMap map = new HashMap();
	int maxLen=10;
	
	public void set(int key, int value) {
		if(map.containsKey(key)) {
			Node node = (Node) map.get(key);
			node.value = value;
			remove(node);
			addhead(node);
		}else {
			Node node = new Node(key, value);
			// here need to check cap
			if(map.size() >= maxLen){
				map.remove(next.key);
				remove(next);
				addhead(node);
			}else {
				addhead(node);
			}
			// remember to put it 
			map.put(key, node);
		}
	}
	
	public int get(int key) {
//		int value=-1;
		if(map.containsKey(key)) {
			Node node = (Node) map.get(key);
			// remember to replace
			remove(node);
			addhead(node);
			return node.value;
		}else {
			return -1;
		}
	}

	private void addhead(Node node) {
		// so here do not check 
		node.next = head;
		node.pre = null;
		if(head != null) {
			head.pre = node;
		}
		head = node;
		// maybe this is also necessary
		if (next == null) {
			next = head;
		}
		
//		if(map.size()>maxLen) {
//			Node endNode = next;
//			next.pre.next= null;
//			map.remove(endNode.key);
//			node.next= head;
//			head.pre= node;
//			head = node;
//		}else {
//			if(head==null) {
//				head = node;
//			}else {
//				node.next = head;
//				head.pre = node;
//				head = node;
//			}			
//		}
	}

	private void remove(Node node) {
		if(node.pre == null) {
			head = node.next;
		}else {
			node.pre.next = node.next;
		}
		
		if(node .next != null) {
			node.next.pre= node.pre;
		}else {
			next = node.pre;
//			next.next = null;// 我觉这应该加上， 当然node 本身就是null
		}
		
//		if(node.next==null) {
//			node.pre.next=null;
//			but next does not update
//		}else {
//			node.next.pre = node.pre;
//		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		LRUCache lrucache = new LRUCache();
		lrucache.set(1, 1);
		lrucache.set(10, 15);
		lrucache.set(15, 10);
		lrucache.set(10, 16);
		lrucache.set(12, 15);
		lrucache.set(18, 10);
		lrucache.set(13, 16);

		System.out.println(lrucache.get(1));
		System.out.println(lrucache.get(10));
		System.out.println(lrucache.get(15));

		/*
		 * 1
		 * 16
		 * 10
		 * 
		 * if max is 4
		 * -1
		 * 16
		 * -1
		 */
	}

}
