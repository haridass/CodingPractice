import java.util.Comparator;
import java.util.PriorityQueue;

public class testPqOrder {
	static PriorityQueue<Integer> highheap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}}
	);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,4,2,5};
		for(int i=0;i<arr.length;i++)
			highheap.add(arr[i]);
		while(!highheap.isEmpty()){
			System.out.println(highheap.poll());
		}
	}

}
