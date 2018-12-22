import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithOutRepetation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestSequenceWithOutRepetation("abcde1234567890aklb"));
		//System.out.println("ab".substring(0, 2));
	}
	public static String longestSequenceWithOutRepetation(String str){
		HashMap<Character,Integer> mp = new HashMap<Character,Integer>();
		int startIndx = 0;
		//substringIndicies will keep track of longestsubstring without repetition.
		int[] substringIndices = {0,0};
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(mp.containsKey(ch)){
				int prevDupCharIndx = mp.get(ch);
				int lenSubString = i-startIndx;
				int maxStringLen = substringIndices[1] - substringIndices[0];
				if(lenSubString>maxStringLen){
					substringIndices[0] = startIndx;
					substringIndices[1] = i;
				}
				//Remove all reference in hashmap that occur before previous duplicate value and they cannot be part
				//of longest substring
				while(startIndx <= prevDupCharIndx){
					mp.remove(startIndx);
					startIndx++;
				}	
			}
			//always update the map with latest index for character
			mp.put(ch, i);
		}
		if(substringIndices[1]==0 )
			substringIndices[1]= str.length();
		return str.substring(substringIndices[0],substringIndices[1]);
	}
	
}
