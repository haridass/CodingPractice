import java.util.Arrays;

public class Node implements Comparable<Node>{
	String origStr;
	String sortedStr;
	Node(String origStr){
		this.origStr = origStr;
		char[] orgArry = origStr.toCharArray();
		Arrays.sort(orgArry);
		this.sortedStr = new String(orgArry);
	}
	
	@Override
	public int hashCode(){
		int sum = 0;
		for (char ch:this.origStr.toCharArray()){
			sum = sum + ch;
		}
		return sum;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Node))
			return false;
		Node otherObj = (Node)obj;
		if((this.origStr.compareTo(otherObj.origStr)==0))
			return true;
		else 
			return false;
	}
	
	@Override 
	public int compareTo(Node oNode){
		return this.sortedStr.compareTo(oNode.sortedStr);
	}

}
