
public class PartitionSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nuts  = {10,4,20,1,3,6};
		int[] bolts = {1,20,6,10,3,4};
		for(int j=0;j<10;j++){
		matchNutsAndBolts(nuts,bolts,0,nuts.length);
		for(int i=0;i<nuts.length;i++)
			System.out.println("nuts" + nuts[i] + " Bolts" + bolts[i]);
		}
	}
	
	public static int partition(int[] arr, int left, int right,int pivot){
		searchPivotAndSwapWithLeft(arr,left,right,pivot);
		int replacedIndx = left+1;
		for(int seenIndx = left+1;seenIndx<right;seenIndx++){
			if(arr[seenIndx]<arr[left]){
				swap(arr,seenIndx,replacedIndx);
				replacedIndx++;
			}
		}
		swap(arr,replacedIndx-1,left);
		return replacedIndx-1;
	}
	
	public static void swap(int[] arr,int indx1, int indx2){
		int temp = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2] = temp;
	}
	
	public static void searchPivotAndSwapWithLeft(int[] arr,int left, int right, int pivot){
		for(int i=left;i<right;i++){
			if(arr[i] == pivot)
				swap(arr,left,i);
				
		}
	}
	
	public static void matchNutsAndBolts(int[] nuts, int[] bolts, int left, int right){
		if(left>= right)
			return;
		int randPivot= left + (int)Math.round(Math.random()*(right-1-left));
		int nutsPartitionIndx = partition(nuts,left,right,bolts[randPivot]);
		partition(bolts,left,right,nuts[nutsPartitionIndx]);
		matchNutsAndBolts(nuts,bolts,left,nutsPartitionIndx);
		matchNutsAndBolts(nuts,bolts,nutsPartitionIndx+1,right);
	}

}
