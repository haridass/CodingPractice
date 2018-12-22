import java.util.HashMap;

public class LRUcacheMain {
	
	static HashMap<Integer,Node> mp = new HashMap<Integer,Node>();
	static int capacity= 0;
	static int maxCapacity = 4;
	static Node head = null, tail = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String get(int key){
		String value = "";
		if(!mp.containsKey(key)){
			return "-1";
		}
		Node n  = mp.get(key);
		value = n.value;
		if(n!=head && n!= tail){
			remove(n);
			insertAtHead(n);
		}
		if(n!=head && n==tail){
			remove(n);
			insertAtHead(n);
			tail = tail.prv;
		}
		return value;
	}
	public static void put(int key, String value){
		if(capacity == maxCapacity){
			tail = tail.prv;
		}
		Node n = new Node(key,value);
		mp.put(key, n);
		insertAtHead(n);
	}
	public static void remove(Node n){
		// Link the bridge between two nodes when node is removed
		Node prvNode = n.prv;
		Node nxtNode = n.nxt;
		prvNode.nxt = nxtNode;
		nxtNode.prv = prvNode;
		n.prv = null;
		n.nxt = null;
	}
	public static void insertAtHead(Node n){
		if( capacity == 0){
			head = n;
			tail = n;
		}else{
			head.prv = n;
			n.nxt = head;
			head = n;
		}
		head.prv = null;
			
	}
//	public static void moveNodeToHead(Node n){
//		remove(n);
//		insertAtHead(n);
//	}

}
