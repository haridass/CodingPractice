
public class MatchNutsAndBolts {
/********
 * Refer to PartitionSub
 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] nuts  = {5,4,2,1,3,6};
//		int[] bolts = {1,2,5,6,3,4};
//		matchNutsBolts(nuts,bolts,0,nuts.length);
//		//int part =partition(nuts,0,nuts.length,3);
//		for(int i=0;i<nuts.length;i++)
//			System.out.println("nuts" + nuts[i] + ": boolts " + bolts[i]);
//			//System.out.println("nuts" + nuts[i]);
//		//System.out.println(part);
//	}
//	
//	public static int partition(int[] arr, int left, int right, int pivot){
//		right = right-1;
//		int pivoteleInx = 0;
//		while(true){
//			while(left < right && arr[left]<=pivot){
//				//Left should eventually see pivot element
//				if(arr[left]==pivot)
//					pivoteleInx = left;
//				left++;
//			}
//			while(right>left && arr[right]>pivot)
//				right--;
//			
//			if(left>=right){
//				//swap(arr,pivoteleInx,left-1);
//				return left;
//			}
//			
//			swap(arr,left,right);
//		}
//	}
//	
//	
//	public static void swap(int[] arr,int indx1, int indx2){
//		int tmp = arr[indx1];
//		arr[indx1]= arr[indx2];
//		arr[indx2]= tmp;
//	}
//	
//	public static void matchNutsBolts(int[] nuts, int[] bolts,int left, int right){
//		System.out.println("left:" + left);
//		System.out.println("right:"+ right);
//		if(left>=right){
//			return;
//		}
//		int randPivotIndx = left + (int)Math.round(Math.random()*(right-1-left));
//		int partitionIndx = partition(nuts,left,right,bolts[randPivotIndx]);
//		partition(bolts,left,right,nuts[partitionIndx]);
//		matchNutsBolts(nuts,bolts, left, partitionIndx);
//		matchNutsBolts(nuts,bolts,partitionIndx+1,right);
//	}

}
