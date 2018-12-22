
public class DutchNationalFlag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {2,3,4,5,6,7,3,8,1,3,9};
		dutchNationalFlag(arry,1);
	}
	public static void dutchNationalFlag(int[] arry, int pivotIndx){
		swap(arry,pivotIndx,0);
		int seenIndx = 1;
		int replacedIndx = 1;
		for(seenIndx=1;seenIndx<arry.length;seenIndx++){
			if(arry[seenIndx]<arry[0]){
				swap(arry,seenIndx,replacedIndx);
				seenIndx++;
				replacedIndx++;
			}
		}
		int lowerNum = replacedIndx-1;
		for(seenIndx=replacedIndx;seenIndx<arry.length;seenIndx++){
			if(arry[seenIndx] == arry[0]){
				swap(arry,seenIndx,replacedIndx);
				seenIndx++;
				replacedIndx++;
			}
		}
		swap(arry,0,lowerNum);	
		for(int i=0;i<arry.length;i++){
			System.out.print(arry[i] + "\t");
		}
	}
	public static void swap(int[] arry,int indx1, int indx2){
		int temp = arry[indx1];
		arry[indx1] = arry[indx2];
		arry[indx2] = temp;
	}

}
