import java.util.*;
public class MedianFindingAlgo {
	/********************************
	 * MedianFindALoAttempt2 has better implementation
	 */
	
//	static PriorityQueue<Integer> lowheap = new PriorityQueue<Integer>(new Comparator<Integer>(){
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			// TODO Auto-generated method stub
//			return o2-o1;
//		}
//	});
//	static PriorityQueue<Integer> highheap = new PriorityQueue<Integer>(new Comparator<Integer>(){
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			// TODO Auto-generated method stub
//			return o1-o2;
//		}}
//	);
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		
//		for(int i=10;i>0;i--){
//			insertRandom(i);
//			System.out.println(getMedin());
//		}
//	}
//	
//	public static void insertRandom(int ele){
//		if(ele ==4){
//			System.out.println("tst");
//		}
//		int lowheapSize = lowheap.peek()==null?0:lowheap.size();
//		int highheapSize = highheap.peek()==null?0:highheap.size();
//		if(lowheap.isEmpty()){
//			lowheap.add(ele);
//			return;
//		}
//		if(ele < lowheap.peek()){
//			//insert into lowheap
//			//check size, pop and push if size greater
//			if(lowheapSize > highheapSize){
//				highheap.add(lowheap.poll());
//			}
//			lowheap.add(ele);
//			
//		}else{
//			//if highheap peek is null, insert to high heap
//			if(highheap.peek()==null){
//				highheap.add(ele);
//				return;
//			}
//			//check if size to cross check balance
//			if(highheapSize > lowheapSize){
//				// Size already greater, check to see if top of heap has to be pushed to lowpq or ele has to be pushed
//				if(ele > highheap.peek()){
//					lowheap.add(highheap.poll());
//					highheap.add(ele);
//				} else{
//					lowheap.add(ele);
//				}
//			}else{
//				highheap.add(ele);
//			}
//		}
//	}
//	
//	public static double getMedin(){
//		double median = 0;
//		int lowheapSize = lowheap.peek()==null?0:lowheap.size();
//		int highheapSize = highheap.peek()==null?0:highheap.size();
//		if((highheapSize+lowheapSize)%2==0)
//			median= ((highheap.peek()==null?0:highheap.peek()) + (lowheap.peek()==null?0:lowheap.peek()))/2.0;
//		else{
//			median= (highheapSize>lowheapSize?highheap.peek():lowheap.peek());
//		}
//		return median;
//	}
//	


}
