/******************
 * Not Clean code, check the second attempt
 */
//package nby2plusonecards;
//
//public class Nby2plusonecards {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] arry = {2,2,2,5,5,5,5,5};
//		System.out.println(getWinner(arry,0,arry.length));
//	}
//	public static int getWinner(int[] arry, int left, int right){
//		if(left>=right)
//			return -1;
//		if(right - left ==1 ){
//			return arry[left];
//		}
//		if(right-left == 2 ){
//			if((arry[left]==arry[right-1])){
//				return arry[left];				
//			}else{
//				return Integer.MIN_VALUE;
//			}
//		}
//		int mid = (left+right)/2;
//		int leftWinner = getWinner(arry,left,mid);
//		int rightWinner = getWinner(arry,mid+1,right);
//		int leftWinnerCount = Integer.MIN_VALUE;
//		int rightWinnerCount = Integer.MIN_VALUE;
//		if(leftWinner!=Integer.MIN_VALUE){
//			leftWinnerCount = getElementCount(arry,leftWinner, left,right);
//		}
//		if(rightWinner!=Integer.MIN_VALUE){
//			rightWinnerCount = getElementCount(arry,rightWinner,left,right);
//		}
//		if(leftWinnerCount>rightWinnerCount)
//			return leftWinner;
//		else if(leftWinnerCount < rightWinnerCount)
//			return rightWinner;
////		else if()
////			return Integer.MIN_VALUE;
//	}
//	
//	public static int getElementCount(int[] arry,int element, int left, int right){
//		int eleCount = 0;
//		for(int i = left; i<right;i++){
//			if(arry[i]==element){
//				eleCount = eleCount+1;
//			}
//		}
//		return eleCount;
//	}
//
//}
