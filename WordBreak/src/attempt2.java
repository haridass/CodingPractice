import java.util.ArrayList;

/****************************
 * OPT(i) denote the total minimum number of invalid character till ith character in array
 * OPT is an array of length str.length+1 
 * let i indicate the current index and j indicate some index such that substring ji exists in arraylist
 * ele is an element in opt array, minInvalidChars, indicates the minimum number of invalid chars till i character in string
 * prevSplitIndx indicate the character after which the split should occur. 
 * @author sriram
 *
 */
class Value{
	int minInvalidChars;
	int prevSplitIndx;
	Value(){};
	Value(int minInvalidChars, int prevSplitIndx){
		this.minInvalidChars = minInvalidChars;
		this.prevSplitIndx = prevSplitIndx;
	}
}
public class attempt2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> reversedWords = new ArrayList<String>();
		reversedWords.add("dekool");
		reversedWords.add("tsuj");
		reversedWords.add("ekil");
		reversedWords.add("reh");
		reversedWords.add("rehtorb");
		reversedWords.add("siht");
		reversedWords.add("si");
		Value[] opt = getOptimumElements("TIMlookedjustlikeherbrotherJIM",reversedWords);
		ArrayList<Integer> indicesLst = getSplitIndices(opt);
		System.out.println(gettheSplittedString("TIMlookedjustlikeherbrotherJIM", indicesLst));
	}
	
	public static String reverseString(String str){
		return new StringBuffer(str).reverse().toString();
	}
	
	public static Value[] getOptimumElements(String str, ArrayList<String> dictionaryWords){
		Value[] opt = new Value[str.length()+1];
		Value v = new Value(0,-1);
		opt[0] = v;
		for(int i=1;i<opt.length;i++){
			int subStringEndIndx = i;
			opt[i] = new Value(); 
			opt[i].minInvalidChars = Integer.MAX_VALUE;
			for(String dictWord:dictionaryWords){
				int j = i-dictWord.length();
				int subStringStIndx = j;
				if(subStringStIndx<0)
					continue;
				String reverseOfSubString = reverseString(str.substring(subStringStIndx,subStringEndIndx));
				if(reverseOfSubString.equals(dictWord)){
					if(opt[j].minInvalidChars < opt[i].minInvalidChars){
						opt[i].minInvalidChars = opt[j].minInvalidChars;
						opt[i].prevSplitIndx = j;
					}
				}
			}
			//Comparison with opt[i-1]
			if(opt[i-1].minInvalidChars+1 < opt[i].minInvalidChars){
				opt[i].minInvalidChars = opt[i-1].minInvalidChars+1;
				opt[i].prevSplitIndx = i-1;
			}
		}
		return opt;
	}
	public static ArrayList<Integer> getSplitIndices(Value[] opt){
		ArrayList<Integer> indicesLst = new ArrayList<Integer>();
		indicesLst.add(opt.length-1);
		int prevSplitIndx = opt[opt.length-1].prevSplitIndx;
		while(prevSplitIndx >=0){
			indicesLst.add(prevSplitIndx);
			prevSplitIndx = opt[prevSplitIndx].prevSplitIndx;
		}
		return indicesLst;
	}
	public static String gettheSplittedString(String originalString, ArrayList<Integer> indices){
		StringBuffer bf = new StringBuffer();
		for(int i=indices.size()-2;i>=0;i--){
			bf.append(originalString.substring(indices.get(i+1),indices.get(i)));
			bf.append(" ");
		}
		return bf.toString();
	}
	

}
