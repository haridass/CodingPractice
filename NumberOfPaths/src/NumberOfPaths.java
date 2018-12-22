import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class res{
	ArrayList<String> path;
	Boolean hasPath= false;
	res(ArrayList<String> path, Boolean hasPath){
		this.path = path;
		this.hasPath = hasPath;
	}
}
public class NumberOfPaths {
	public static HashMap<String,Integer> countMp = new HashMap<String,Integer>();
	public static HashMap<String,ArrayList<String>> pathMp = new HashMap<String,ArrayList<String>>();
	public static HashSet<String> hs = new HashSet<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = getAPath(1,1,0,0);
		System.out.println(al);
	}
	
	
	public static int numberOfPathsFromPoint(int fx, int fy, int cx,int cy){
		if(cx > fx || cy >fy)
			return 0;
		if(cx == fx && cy == fy){
			return 1;
		}
		String hsXKey = (cx +1) +","+ cy;
		int rcnt = countMp.containsKey(hsXKey)?countMp.get(hsXKey):numberOfPathsFromPoint(fx,fy,cx+1,cy);
		countMp.put(hsXKey, rcnt);
		String hsYKey = cx +","+ (cy+1);
		int dcnt = countMp.containsKey(hsYKey)?countMp.get(hsYKey):numberOfPathsFromPoint(fx,fy,cx,cy+1);
		countMp.put(hsYKey, dcnt);
		return rcnt + dcnt;
	}
	
	public static ArrayList<String> getAPath(int fx, int fy, int cx, int cy){
		ArrayList<String> arryList = new ArrayList<String>();
		arryList.add(cx +","+ cy);
		if(cx == fx && cy == fy){
			return arryList;
		}
		String xKey = (cx+1) +","+cy;
		if(cx+1 <= fx && !hs.contains(xKey)){
			ArrayList<String> ltList = pathMp.containsKey(xKey)?pathMp.get(xKey):getAPath(fx,fy,cx+1,cy);
			if(!pathMp.containsKey(xKey)) pathMp.put(xKey, ltList);
			arryList.addAll(ltList);
		}
		
		String yKey = cx +","+ (cy+1);
		if(cy+1 <= fy && !hs.contains(yKey)){
			ArrayList<String> dwList = pathMp.containsKey(yKey)?pathMp.get(yKey):getAPath(fx,fy,cx,cy+1);
			if(!pathMp.containsKey(yKey)) pathMp.put(yKey, dwList);
			arryList.addAll(dwList);
			return arryList;
		}
		 return arryList;
	}

}
