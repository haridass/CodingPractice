import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static Ele[] getSortedEle(ArrayList<String> al){
		ArrayList<Ele> orgEleLst = new ArrayList<Ele>();
		for(String str :al){
			orgEleLst.add(new Ele(str));
		}
		Ele[] orgEleArry = new Ele[orgEleLst.size()];
		orgEleLst.toArray(orgEleArry);
		Arrays.sort(orgEleArry);
		return orgEleArry;
	}
	
	public static splitArry(Ele[] eleArry){
		ArrayList<ArrayList<String>> finalList = new ArrayList<ArrayList<String>>();
		ArrayList<String> tmpLst = new ArrayList<String>();
		for( int i =1; i<eleArry.length;i++){
			if(eleArry[i-1].compareTo(eleArry[i]))
		}
	}

}
