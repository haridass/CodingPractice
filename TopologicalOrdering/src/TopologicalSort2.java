/**************
 * Initial did a mistake of not adding both startnode and endNode separately, it is best to all Node to hashmap and 
 * update those node just to make sure right nodes are updated. 
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

class Dependency{
	int startVertex;
	int endVertex;
	public Dependency(int s,int e){
		this.startVertex = s;
		this.endVertex =e;
	}
}

class Vertex{
	public int inVertexCount =0;
	public ArrayList<Vertex> outVertices = new ArrayList<Vertex>();
	int value;
	public Vertex(int v){
		this.value = v;
	}
}
public class TopologicalSort2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vertices = {3,2,1,4,5,6,7};
		ArrayList<Dependency> dpList = new ArrayList<Dependency>();
		dpList.add(new Dependency(2,3));
		dpList.add(new Dependency(3,4));
		dpList.add(new Dependency(3,5));
		dpList.add(new Dependency(4,5));
		dpList.add(new Dependency(5,6));
		dpList.add(new Dependency(5,7));
		dpList.add(new Dependency(6,7));
		dpList.add(new Dependency(1,4));
		dpList.add(new Dependency(1,5));
		dpList.add(new Dependency(1,7));
		dpList.add(new Dependency(2,5));
		dpList.add(new Dependency(2,6));
		ArrayList<Vertex> sortedVertices = getTopologicalSort(vertices,dpList);
		for(Vertex v :sortedVertices){
			System.out.println(v.value);
		}
	}
	
	public static ArrayList<Vertex> getTopologicalSort(int[] vertices,ArrayList<Dependency> dependecies){
		HashMap<Integer,Vertex> indMap = buildGraph(vertices, dependecies);
		Iterator<Entry<Integer,Vertex>> itr = indMap.entrySet().iterator();
		ArrayList<Vertex> orderedList = new ArrayList<Vertex>();
		Queue<Vertex> que = new LinkedList<Vertex>();
		while(itr.hasNext()){
			Entry<Integer,Vertex> itm = itr.next();
			Vertex v = itm.getValue();
			if(v.inVertexCount==0)
				que.add(v);
		}
		while(!que.isEmpty()){
			Vertex v = que.poll();
			orderedList.add(v);
			for(Vertex adjV:v.outVertices){
				adjV.inVertexCount--;
				if(adjV.inVertexCount <=0)
					que.add(adjV);
			}
		}
		return orderedList;
	}
	public static HashMap<Integer,Vertex> buildGraph(int[] vertices,ArrayList<Dependency> dependecies){
		HashMap<Integer,Vertex> indMap = new HashMap<Integer,Vertex>();
		for(int v:vertices){
			indMap.put(v,new Vertex(v));
		}
		for(Dependency d:dependecies){
			int stVer = d.startVertex;
			int endVer = d.endVertex;
			//Updating the start Vertex
			if(indMap.containsKey(stVer) && indMap.containsKey(endVer) ){
				Vertex s = indMap.get(stVer);
				Vertex e = indMap.get(endVer);
				s.outVertices.add(e);
				e.inVertexCount++;
			}
		}
		return indMap;
	}

}
