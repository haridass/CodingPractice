import java.util.*;

class wordNode{
	String word;
	wordNode prevNode;
	int distance;
	wordNode(String word,wordNode prevNode,int distance){
		this.word=word;
		this.prevNode = prevNode;
		this.distance = distance;
	}
}
public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		hs.add("hot");
		hs.add("dot");
		hs.add("dog");
		hs.add("lot");
		hs.add("log");
		hs.add("cog");
		wordLadder(hs,"hit","cog");
	}
	public static void wordLadder(HashSet<String> dict, String startWord, String endWord){
		ArrayList<String> wordList = new ArrayList<String>();
		Queue<wordNode> queue = new LinkedList<wordNode>();
		wordNode st = new wordNode(startWord,null,0);
		queue.add(st);
		while(!queue.isEmpty()){
			wordNode n = queue.poll();
			//System.out.println(n.word);
			if(n.word.equalsIgnoreCase(endWord)){
				System.out.println(n.distance);
				printPath(n);
				return;
			}
			String str = n.word;
			for(int i=0;i<str.length();i++){
				for(char ch='a';ch<'z';ch++){
					String replacedStr = str.substring(0,i) + ch + str.substring(i+1,str.length());
					if(dict.contains(replacedStr)){
						dict.remove(replacedStr);
						//System.out.println(replacedStr);
						wordNode newNode = new wordNode(replacedStr,n,n.distance+1);
						queue.add(newNode);
					}
				}
			}
		}
	}

	public static void printPath(wordNode endNode){
		wordNode wn = endNode;
		while(wn!=null){
			System.out.println(wn.word);
			wn = wn.prevNode;
		}
	}
}
