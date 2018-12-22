import java.util.BitSet;

public class BitSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitSet[] bsArry = new BitSet[10];
		for(int i=0;i<bsArry.length;i++){
			bsArry[i] = new BitSet(2147483647);
		}
		bsArry[0].set(2147483647);
		System.out.println(bsArry[0].get(10));
	}

}
