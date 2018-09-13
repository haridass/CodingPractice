
public class LinearSearchKthStatistic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {5,1,2,7,3,6};
		System.out.println(getKthOrderStatistic( arry,0,arry.length, 10));
//		for(int i=0;i<10;i++){
//			int randIndx = (int)Math.round(Math.random()*(5));
//			System.out.println(randIndx);
//		}
	}
	
	public static int getKthOrderStatistic(int[] arry,int left, int right, int rank){
		if(left>=right)
			return -1;
		int randIndx = left + (int)Math.round(Math.random()*(right-left-1));
		int rankOfPartitioned = partition(arry,left,right, randIndx);
		// Need to get the index of Partitioned as recursion happens based on index. 
		int indxOfPartitioned = left + rankOfPartitioned-1;
		if(rank == rankOfPartitioned){
			return arry[indxOfPartitioned];
		}
		if(rankOfPartitioned > rank){
			return getKthOrderStatistic(arry,left,indxOfPartitioned,rank);
		}else{
			return getKthOrderStatistic(arry,indxOfPartitioned+1,right,rank-rankOfPartitioned);
		}	
	}
	//Returns only the rank with in the partition. 
	public static int partition(int[] arry, int left, int right, int pivot){
		int rank =-1;
		swap(arry,left,pivot);
		int replacedIndx = left+1;
		for(int seenIndx= left+1;seenIndx<right;seenIndx++){
			if(arry[seenIndx] < arry[left]){
				swap(arry,seenIndx,replacedIndx);
				replacedIndx++;
			}
		}
		swap(arry,left,replacedIndx-1);
		rank = replacedIndx-left;
		return rank;
	}
	
	
	public static void swap(int[] arry, int indx1,int indx2){
		int temp = arry[indx1];
		arry[indx1]= arry[indx2];
		arry[indx2] = temp;
	}

}
