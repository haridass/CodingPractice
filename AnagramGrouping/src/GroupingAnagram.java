import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class GroupingAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Node> anagramList = new ArrayList<Node>();
        String[] strArry = {"xxy", "cab", "bca", "cab", "bac", "dash", "shad"};
        for(String str:strArry){
            Node n = new Node(str);
            anagramList.add(new Node(str));
        }
         Node[] SortedList =  new Node[anagramList.size()];
         SortedList = anagramList.toArray(new Node[anagramList.size()]);
         Arrays.sort(SortedList);
        PrintAnagramGroups(SortedList);
        System.out.println("");
	}
    public static void PrintAnagramGroups(Node[] alist){
        HashSet<Node> uniqueEle = new HashSet<Node>();
        ArrayList<ArrayList<String>> outputList = new ArrayList<ArrayList<String>>();
        Node prevEle = alist[0];
        ArrayList<String> sublist = new ArrayList<String>();
        for(int i=1;i< alist.length;i++){
        	Node ele = alist[i];
        	//check for duplicates
        	if(!uniqueEle.contains(prevEle)){
        		uniqueEle.add(prevEle);
        		if(ele.compareTo(prevEle)!=0){
        			sublist.add(prevEle.orgStr);
        			outputList.add(sublist);
        			sublist = new ArrayList<String>();
        		}else{
        		sublist.add(prevEle.orgStr);
        		}
        	} 
        	prevEle = ele;
        	}
        sublist.add(alist[alist.length-1].orgStr);
        outputList.add(sublist);
        System.out.println(outputList);
    }

}

