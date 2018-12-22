import java.lang.reflect.Array;
import java.util.Arrays;

public class Ele implements Comparable<Ele>{

	String acStr = null;
	String sortedStr = null;
	Ele(String str){
		acStr = str;
		sortedStr = storString(str);
	}
	
	private String storString(String str){
		char[] chrArry = str.toCharArray();
		Arrays.sort(chrArry);
		sortedStr = chrArry.toString();
		return sortedStr;
	}
	
	@Override
	public int compareTo(Ele oele){
		return oele.sortedStr.compareTo(this.sortedStr);
	}
	
	@Override
	public int hashCode(){
		int sum = 0;
		char[] chrArry = acStr.toCharArray();
		for(int i=0;i<10;i++){
			sum = chrArry[i] + sum;
		}
		return sum;
	}
	@Override 
	public boolean equals(Object obj){
		if(!(obj instanceof Ele)){
			return false;
		}
		Ele tObj = (Ele)obj;
		if(tObj.acStr.compareTo(acStr) ==0)
			return true;
		else
			return false;
		
	}

	
}
