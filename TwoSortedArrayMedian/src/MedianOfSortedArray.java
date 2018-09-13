
public class MedianOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry1 = {1};
		int[] arry2 = {4,5};
		double median = getMedian(arry1, arry2);
		System.out.println(median);
	}
	
	public static double getMedian(int[] arry1, int[] arry2){
		double median = -1;
		int total = arry1.length + arry2.length;
		if(total%2 == 0){
			//It is total/2+1 because we are trying to find out n/2th and n/2+1 order statistics
			median = getKthOrderStatistic(total/2+1, arry1,arry2,0,0) + getKthOrderStatistic(total/2, arry1,arry2,0,0);
			median = median/2.0;
		}else{
			median = getKthOrderStatistic(total/2+1, arry1,arry2,0,0);
		}
		return median;
	}
	
	public static int getKthOrderStatistic(int k, int[] arry1, int[] arry2, int indx1, int indx2){
		int KthOrderValue = -1;
		if(indx1>= arry1.length){
			//-1 is required because we are accesssing index of array
			KthOrderValue= arry2[indx2+k-1];
			return KthOrderValue;
		}
		if(indx2>= arry2.length){
			//-1 is required because we are accesssing index of array
			KthOrderValue= arry1[indx1+k-1];
			return KthOrderValue;
		}
		if(k==1){
			KthOrderValue= Math.min(arry1[indx1], arry2[indx2]);
			return KthOrderValue;
		}
		int m1 = indx1 + k/2 -1; // to find k/2th order statistic you need to look at the index k/2-1
		int m2 = indx2 + k/2-1;
		int mid1 = m1< arry1.length?arry1[m1]:Integer.MAX_VALUE;
		int mid2 = m2< arry2.length?arry2[m2]:Integer.MAX_VALUE;
		if(mid1 < mid2){
			KthOrderValue= getKthOrderStatistic(k-k/2,arry1,arry2,m1+1,indx2);
		}else{
			KthOrderValue=getKthOrderStatistic(k-k/2,arry1,arry2,indx1,m2+1);
		}
		return KthOrderValue;
	}

}
