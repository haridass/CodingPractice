
class RetEle{
	int[] arr;
	int count;
	RetEle(int[] arr,int count){
		this.arr= arr;
		this.count = count;
	}	
}
public class CountingInversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static RetEle mergeCount(int[] arr,int left,int right){
		if(left>=right){
			int[] a = new int[0];
			return new RetEle(a,0);
		}
		if(right-left == 1){
			int[] res = {arr[left]};
			return new RetEle(res,0);
		}
//		if(right-left == 2){
//			
//		}
		int count =0;
		int mid = (left+ right)/2;
		RetEle leftE = mergeCount(arr,left,mid);
		RetEle rightE = mergeCount(arr,mid+1,right);
		int ptrL =0, ptrR=0;
		int[] mrgdArr = new int[leftE.arr.length + rightE.arr.length];
		int ptrM=0;
		while(ptrL<leftE.arr.length && ptrR<rightE.arr.length){
			if(leftE.arr[ptrL] < rightE.arr[ptrR]){
				mrgdArr[ptrM] = leftE.arr[ptrL];
			}else{
				mrgdArr[ptrM]= rightE.arr[ptrR];
				count = count + (leftE.arr.length -1-ptrL)
			}
			
			ptrM++;
		}
		
		return count;
	}
	


}

