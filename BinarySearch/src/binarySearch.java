
public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {10,20};
		int searchVal = search(arry,15,0,2);
		System.out.println(searchVal);
	}
	
	public static int search(int[] arry,int k, int left, int right){
		if (left==right)
			return -1;
		int mid = (left+right)/2;
		if(arry[mid]==k)
			return mid;
		if(arry[mid] < k)
			return search(arry,k,mid+1,right);
		else
			return search(arry,k,left,mid);
	}

}
