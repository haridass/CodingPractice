package nby2plusonecards;

import java.util.Stack;

public class Attempt2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {2,2,2,2,3,5,5,5,3};
		System.out.println(getWinner(arry));
	}
	public static int getWinner(int[] arry){
		Stack<Integer> stk = new Stack<Integer>();
		Stack<Integer> reducedStk = new Stack<Integer>();
		for(int i=0;i<arry.length;i++){
			stk.add(arry[i]);
		}
		while(stk.size() > 2){
			while(stk.size() > 0){
				int ele1 = stk.pop();
				int ele2 = stk.pop();
				if(ele1==ele2){
					reducedStk.add(ele1);
				}
				if(stk.size()==1){
					reducedStk.add(stk.pop());
				}
			}
			stk = reducedStk;
			reducedStk = new Stack<Integer>();
		}
		int ele1= Integer.MIN_VALUE,ele2=Integer.MIN_VALUE;
		if(stk.size() ==1){
			ele1 = stk.pop();
			return checkmajorityCount(arry,ele1);
		}
		if(stk.size() == 2){
			ele1 = stk.pop();
			ele2 = stk.pop();

		}
		return 0;
	}
	
	public static int checkmajorityCount(int[] arry,int ele){
		int count = 0;
		for(int i=0;i<arry.length;i++){
			if(arry[i] == ele){
				count= count +1;
			}
		}
		if(count > arry.length/2)
			return ele;
		else
			return Integer.MIN_VALUE;
	}
	public static boolean checkmajorityCount(int[] arry,int ele, int ele2){
		int count = 0;
		for(int i=0;i<arry.length;i++){
			if(arry[i] == ele){
				count= count +1;
			}
		}
		if(count > arry.length/2)
			return true;
		else
			return false;
	}

}
