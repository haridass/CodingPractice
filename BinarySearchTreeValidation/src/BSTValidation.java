
class Node{
	Node left;
	Node right;
	int value;
	Node(int value){
		this.value = value;
	}
	public boolean validateBST(int minValue, int maxValue){
		boolean validBST = true;
		if(left!= null)
			validBST = left.validateBST(minValue,value);
		if(!validBST)
			return false;
		if(value < minValue || value > maxValue){
			return false;
		}
		if(right!= null)
			validBST = right.validateBST(value,maxValue);
		return validBST;
	}
	public void inorderTraversal(){
		if(left != null)
			left.inorderTraversal();
		System.out.println(value);
		if(right!= null)
			right.inorderTraversal();
	}
}
public class BSTValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {1,2,3,4,5,6,7,8,9};
		Node root = buildBSTFromArry(arry,0,arry.length);
		root.value = 15;
		root.inorderTraversal();
		System.out.println(root.validateBST(Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	public static Node buildBSTFromArry(int[] arry, int left, int right){
		if(left >= right)
			return null;
		int mid = (left+right)/2;
		Node n = new Node(arry[mid]);
		n.left = buildBSTFromArry(arry, left, mid);
		n.right = buildBSTFromArry(arry,mid+1,right);
		return n;
	}

}
