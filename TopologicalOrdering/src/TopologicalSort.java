//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Map.Entry;
//import java.util.Queue;
//
//class Dependecies{
//	int startVertex;
//	int endVertex;
//	public Dependecies(int startVertex,int endVertex){
//		this.startVertex = startVertex;
//		this.endVertex = endVertex;
//	}
//}
//class Vertex{
//	int inVetexCount = 0;
//	ArrayList<Vertex> outVer = new ArrayList<Vertex>();
//	int value;
//	public Vertex(int value){
//		this.value = value;
//	}
//	
//	@Override
//	public int hashCode(){
//		return value;
//	}
//	@Override
//	public boolean equals(Object o2){
//		if(!(o2 instanceof Vertex)){
//			return false;
//		}else{
//			Vertex v2 = (Vertex)o2;
//			return v2.value == value;
//		}
//	}
//}
//
//class Graph{
//	public HashMap<Integer,Vertex> indicesMap = new HashMap<Integer,Vertex>();
//	
//	public void buildGraph(int[] vertices,ArrayList<Dependecies> dpList){
//		for(int i=0;i<vertices.length;i++){
//			if(!indicesMap.containsKey(vertices[i])){
//				indicesMap.put(vertices[i],new Vertex(vertices[i]));
//			}
//		}
//		for(Dependecies d :dpList){
//			if(indicesMap.containsKey(d.startVertex) && indicesMap.containsKey(d.endVertex) ){
//				Vertex v1 = indicesMap.get(d.startVertex);
//				Vertex v2 = indicesMap.get(d.endVertex);
//				v1.outVer.add(v2);
//				v2.inVetexCount++;
//			}
//		}
//	}
//}
//public class TopologicalSort {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] vertices = {2,3,1,4,5,6,7};
//		ArrayList<Dependecies> dpList = new ArrayList<Dependecies>();
//		dpList.add(new Dependecies(2,3));
//		dpList.add(new Dependecies(3,4));
//		dpList.add(new Dependecies(3,5));
//		dpList.add(new Dependecies(4,5));
//		dpList.add(new Dependecies(5,6));
//		dpList.add(new Dependecies(5,7));
//		dpList.add(new Dependecies(6,7));
//		dpList.add(new Dependecies(1,4));
//		dpList.add(new Dependecies(1,5));
//		dpList.add(new Dependecies(1,7));
//		dpList.add(new Dependecies(2,5));
//		dpList.add(new Dependecies(2,6));
//		Graph graph = new Graph();
//		graph.buildGraph(vertices, dpList);
//		ArrayList<Vertex> sortedVertices = topologicalSort(graph);
//		for(Vertex v :sortedVertices){
//			System.out.println(v.value);
//		}
//	}
//	
//	public static ArrayList<Vertex> topologicalSort(Graph gp){
//		ArrayList<Vertex> orderedVertices = new ArrayList<Vertex>();
//		Queue<Vertex> que  = new LinkedList<Vertex>();
//		Iterator<Entry<Integer,Vertex>> itr = gp.indicesMap.entrySet().iterator();
//		while(itr.hasNext()){
//			Entry<Integer,Vertex> entry = itr.next();
//			Vertex v = entry.getValue();
//			if(v.inVetexCount==0)
//				que.add(v);
//		}
//		while(!(que.isEmpty())){
//			Vertex v = que.poll();
//			orderedVertices.add(v);
//			for(Vertex adjV:v.outVer){
//				adjV.inVetexCount--;
//				if(adjV.inVetexCount==0){
//					que.add(adjV);
//				}
//			}
//		}
//		if(que.isEmpty() &&(orderedVertices.size()!=gp.indicesMap.size())){
//			System.out.println("graph has cycle");
//		}
//		return orderedVertices;
//	}
//
//}
