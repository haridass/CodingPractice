import java.util.ArrayList;

public class AllParathesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		getAllPerm(al,"",3,3);
		for(String str:al){
			System.out.println(str);
		}
	}
	public static void getAllPerm(ArrayList<String> fnlAl,String str,int leftRemain, int rightRemain){
		if(leftRemain>rightRemain){
			return;
		}
		if(leftRemain <0 || rightRemain <0)
			return;
		if(leftRemain ==0 && rightRemain == 0 ){
			fnlAl.add(str);
		}
		getAllPerm(fnlAl,str +"(",leftRemain-1,rightRemain);
		getAllPerm(fnlAl,str +")",leftRemain,rightRemain-1);

	}

}
