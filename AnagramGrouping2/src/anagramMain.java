import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class anagramMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Node> al = new ArrayList<Node>();
        String[] strArry = {"xxy", "cab", "bca", "cab", "bac", "dash", "shad"};
        for(String str:strArry){
            Node n = new Node(str);
            al.add(new Node(str));
        }
		Node[] anagramArry = al.toArray(new Node[al.size()]);
		Arrays.sort(anagramArry);
		ArrayList<ArrayList<String>>grpdList = groupAnagrams(anagramArry);
		System.out.println(grpdList);
	}
	
	public static ArrayList<ArrayList<String>> groupAnagrams(Node[] anaArry){
		ArrayList<ArrayList<String>> grpdList = new ArrayList<ArrayList<String>>();
		ArrayList<String> subList = new ArrayList<String>();
		HashSet<Node> uana = new HashSet<Node>();
		Node prevEle = anaArry[0];
		
		for(int i =1 ;i<anaArry.length;i++){
			Node currEle = anaArry[i];
			if(!(uana.contains(prevEle))){
				uana.add(prevEle);
				if(prevEle.compareTo(currEle) != 0){
					subList.add(prevEle.origStr);
					grpdList.add(subList);
					subList = new ArrayList<String>();
				}else{
					subList.add(prevEle.origStr);
				}
			}
			prevEle = currEle;	
		}
		subList.add(prevEle.origStr);
		grpdList.add(subList);
		return grpdList;
	}


}
