import java.util.*;
public class MedianFindAloAttempt2 {
	
	public static PriorityQueue<Integer> lowpq = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer o1,Integer o2){
			return o2-o1;
		}
	});
	public static PriorityQueue<Integer> highpq = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer o1,Integer o2){
			return o1-o2;
		}
	});
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5,1,2,6,7,8,9,4,10};
		for(int i=0;i<10;i++){
			insertIntoQueue(arr[i]);
			System.out.println(getMedin());
		}
	}
	
	public static void insertIntoQueue(int ele){
		int lowSize = lowpq.peek()==null?0:lowpq.size();
		int highSize = highpq.peek()==null?0:highpq.size();
		
		if(lowpq.peek() ==null){
			lowpq.add(ele);
			return;
		}
		
		if(ele <= lowpq.peek()){
			// element should go to low pq, but should check size and pop elements if needed
			if(lowSize > highSize){
				// Low size is greated need to pop element and put it in high pq
				highpq.add(lowpq.poll());
			}
			//Low pq is ready to accept new elemensts
			lowpq.add(ele);
		}
		if(highpq.peek() ==null){
			highpq.add(ele);
			return;
		}
		if(ele >= highpq.peek()){
			// element has to go to high pq, check is high pq size is greater
			if(highSize > lowSize){
				lowpq.add(highpq.poll());
			}
			// highpq is ready for insertion
			highpq.add(ele);
		}
		// Condition where element is in between or equal
		if(ele > lowpq.peek() && ele < highpq.peek()){
			//It can go to either queue which is not larger
			if(highSize > lowSize)
				lowpq.add(ele);
			else
				highpq.add(ele);
		}
		
	}
	
	public static double getMedin(){
		double median = 0;
		int lowpqSize = lowpq.peek()==null?0:lowpq.size();
		int highpqSize = highpq.peek()==null?0:highpq.size();
		if((highpqSize+lowpqSize)%2==0)
			median= ((highpq.peek()==null?0:highpq.peek()) + (lowpq.peek()==null?0:lowpq.peek()))/2.0;
		else{
			median= (highpqSize>lowpqSize?highpq.peek():lowpq.peek());
		}
		return median;
	}
	

}
