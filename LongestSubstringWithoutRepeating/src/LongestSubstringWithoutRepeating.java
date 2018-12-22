/*****************
 * Refer to next class 
 */
//import java.util.HashSet;
//
//public class LongestSubstringWithoutRepeating {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//	
//	public static int longestSubstringWithOutRepeatition(String str){
//		HashSet<Character> hs = new HashSet<Character>();
//		int size = 0;
//		int k =0;
//		for(int i=0;i<str.length();i++){
//			char c = str.charAt(i);
//			if(!(hs.contains(c))){
//				hs.add(c);
//				size = Math.max(size, hs.size());
//			}else{
//				while(k<i){
//					if(str.charAt(k)==c){
//						k++;
//						break;
//					}else{
//						hs.remove(c);
//						k++;
//					}
//
//				}
//			}
//		}
//		return size;
//	}
//
//}
//class WordNode{
//    String word;
//    int numSteps;
// 
//    public WordNode(String word, int numSteps){
//        this.word = word;
//        this.numSteps = numSteps;
//    }
//}
