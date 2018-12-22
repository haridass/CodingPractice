import java.util.ArrayList;

public class AllMathExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = allExp("12345",0);
		for(String str:al)
			System.out.println(str);
	}
	public static ArrayList<String> allExp(String str,int n){
		if(n==str.length()){
			return new ArrayList<String>();
		}
		ArrayList<String> sublist = allExp(str,n+1);
		String newExp;
		if(n==0){
			newExp = str;
		}else{
			newExp = str.substring(0,n) +'+'+str.substring(n);
		}
		sublist.add(newExp);
		return sublist;
	}

}
