import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

class Node{
	Node nxt = null;
	int data = 0;
	Node(int data){
		this.data = data;
	}
}
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(1);
		Node n1 = new Node(2);
		n.nxt = n1;
		Node n2 = new Node(3);
		n1.nxt=n2;
		Node n3 = new Node(4);
		n2.nxt=n3;
		Node c= n;
		c =reverseLinkedList(n);
		while(c!=null){
			System.out.println(c.data);
			c = c.nxt;
		}
		   BufferedReader bf  = new BufferedReader(new FileReader(System.in));
	        String line = bf.nextLine();
		
	}
	
	public static Node reverseLinkedList(Node head){
		Node curr = head;
		Node prv = null;
		Node tmp = null;
		while(curr!=null){
			tmp = curr.nxt;
			curr.nxt = prv;
			prv = curr;
			curr = tmp;
		}
		return prv;
	}

}
