import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {1,3,5,2,6,4,1,3,9};
		int windowSize=3;
		ArrayList<Integer> al = maxSlidingWindow(arry,windowSize);
		for(int ele:al)
			System.out.println(ele);
	}
	public static ArrayList<Integer> maxSlidingWindow(int[] arry,int windowSize){
		ArrayList<Integer> al = new ArrayList<Integer>();
		Deque<Integer> dq = new LinkedList<Integer>();
		for(int i=0;i<windowSize;i++){
			if(dq.isEmpty()){
				dq.addLast(arry[i]);
				continue;
			}
			while( !dq.isEmpty()  && dq.peekLast() < arry[i])
				dq.pollLast();
			dq.add(arry[i]);
		}
		al.add(dq.peekFirst());
		// second part start
		for(int i=windowSize;i<arry.length;i++){
			if(dq.isEmpty()){
				dq.addLast(arry[i]);
				continue;
			}
			/************************************************************************************
			 * It is important to only with less than so that duplicate elements are not dropped
			 ************************************************************************************/
			while(!dq.isEmpty() && dq.peekLast() < arry[i] )
				dq.pollLast();
			/*************************************************************
			 * Need to drop off the element that sliding window has passed
			 *************************************************************/
			if(!dq.isEmpty() && dq.peekFirst() == arry[i-windowSize]){
				dq.pollFirst();
			}
			dq.add(arry[i]);
			al.add(dq.peekFirst());
		}
		return al;
	}

}
