import java.util.ArrayList;

class BSTMergedNode{
	BSTMergedNode left;
	BSTMergedNode right;
	int value;
	public void inorderTraversal(){
		if(left!=null)
			left.inorderTraversal();
		System.out.println(value);
		if(right!=null)
			right.inorderTraversal();
	}
	public void convertBSTToArray(ArrayList<Integer> lst){
		if(left!=null)
			left.convertBSTToArray(lst);
		lst.add(value);
		if(right!=null)
			right.convertBSTToArray(lst);
	}
}
class BSTNode{
	BSTNode left;
	BSTNode right;
	int value;
	public void convertBSTToArray(ArrayList<Integer> lst){
		if(left!=null)
			left.convertBSTToArray(lst);
		lst.add(value);
		if(right!=null)
			right.convertBSTToArray(lst);
	}
}
public class MergeTwoBST {
	static BSTMergedNode root = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArry = {1,2,3,4,5,6,7,8};
		root = convertArrayToBST(sortedArry,0,sortedArry.length);
		//System.out.println(root.left.value);
		ArrayList<Integer> lst = new ArrayList<Integer>();
		root.convertBSTToArray(lst);
		for(int i:lst){
			System.out.print(i +"\t");
		}
	}
	public static BSTMergedNode convertArrayToBST(int[] sortedArry,int left,int right){
		if(left >= right)
			return null;
		int mid = (right+left)/2;
		//During each traversal you are creating the node and returning the node after filling the left 
		//and right values
		BSTMergedNode  n = new BSTMergedNode();
		if(root==null)
			root = n;
		n.value = sortedArry[mid];
		n.left = convertArrayToBST(sortedArry,left,mid);
		n.right = convertArrayToBST(sortedArry,mid+1,right);
		return n;
	}
}
