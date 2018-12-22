package nby2plusonecards;

import java.util.ArrayList;
import java.util.Stack;

public class RecursiveApproach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getmajorityEle(int[] origArry, Stack<Integer> stk){
		if(stk.size() == 1){
			 if(checkMajority(origArry,stk.get(0)))
				 return stk.get(0);
			 else
				 return Integer.MIN_VALUE;
		}
		if(stk.size() == 2){
			 if(checkMajority(origArry,stk.get(0)))
				 return stk.get(0);
			 else if (checkMajority(origArry,stk.get(1)))
				 return stk.get(1);
			 else
				 return Integer.MIN_VALUE;
		}
		Stack<Integer> reducedStk = new Stack<Integer>();
		while(stk.size() > 0){
			int ele1 = stk.pop();
			int ele2 = stk.pop();
			if(ele1==ele2){
				
			}
		}
		
	}
	public static boolean checkMajority(int[] arry, int ele){
		int count =0;
		for(int i=0;i<arry.length;i++){
			if(arry[i]==ele) count++;
		}
		if(count>arry.length/2)return true;
		else return false;
	}

}
