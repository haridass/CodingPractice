
public class StocksBuyAndSell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {8,2,1,21,0,20};
		int lowestStkPrice = arry[0];
		int maxProfit = Integer.MIN_VALUE;
		for(int i=1;i<arry.length;i++){
			if(lowestStkPrice > arry[i]){
				lowestStkPrice = arry[i];
			}
			int difference = arry[i]-lowestStkPrice;
			if(maxProfit < difference){
				maxProfit = difference;
			}
		}
		System.out.println(maxProfit);
	}
	
	

}
