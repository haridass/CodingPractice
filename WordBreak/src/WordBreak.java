import java.util.ArrayList;
import java.util.HashMap;
/*****************************************************
 * Let OPT(i) denote the optimum minimum number of total character at i 
 * OPT(i) = min(OPT(j) + OPT(i-1)+1
 * where ji is some word in the dictionary in reverse order, Since J already has the
 * 
 * @author sriram
 *
 */
class Result{
	public int totalMinInvalidChars = 0;
	public int prevSplitIndx = 0;
	Result(int minValid, int prevSplit){
		this.totalMinInvalidChars = minValid;
		this.prevSplitIndx = prevSplit;
	}
	Result(){};
}
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> reversedWords = new ArrayList<String>();
//		reversedWords.add("dekool");
//		reversedWords.add("tsuj");
//		reversedWords.add("ekil");
//		reversedWords.add("reh");
//		reversedWords.add("rehtorb");
//		reversedWords.add("siht");
//		reversedWords.add("si");
//		breakWord("TIMlookedjustlikeherbrotherJIM",reversedWords);
//		reversedWords.add("si");
//		reversedWords.add("lubnatsi");
//		reversedWords.add("siht");
//		breakWord("thistanbul",reversedWords);
		reversedWords.add("elppa");
		reversedWords.add("nep");
		breakWord("ipappapple123123appleapple",reversedWords);
	}
	
	public static void breakWord(String str, ArrayList<String> lst){
		Result[] opt = new Result[str.length()+1];
		opt[0] =new Result(0,-1);
		for(int i = 0;i<str.length();i++){
			int optIIndx = i+1;
			int subStringEndIndx = i+1;
			int minTotalInvalidChars = Integer.MAX_VALUE;
			Result res = new Result();
			for(String dictWord:lst){
				int subStringStIndx = i-(dictWord.length()-1);
				if(subStringStIndx <0)
					continue;
				String reversedSubString = reverseString(str.substring(subStringStIndx,subStringEndIndx));
				int optJindx = optIIndx - dictWord.length();
				if(reversedSubString.equals(dictWord)){
					int currentTotalInvalidChars = opt[optJindx].totalMinInvalidChars;
					/// update current optimal value to min
					if(currentTotalInvalidChars < minTotalInvalidChars){
						minTotalInvalidChars = currentTotalInvalidChars;
						res.totalMinInvalidChars = minTotalInvalidChars;
						res.prevSplitIndx= optJindx;
					}
				}
			}
			int optI_1Indx = optIIndx-1;
			if(opt[optI_1Indx].totalMinInvalidChars+1 < minTotalInvalidChars){
				minTotalInvalidChars = opt[optI_1Indx].totalMinInvalidChars+1;
				res.totalMinInvalidChars = minTotalInvalidChars;
				res.prevSplitIndx= optI_1Indx;
			}
			opt[optIIndx] = res;
		}
		for(Result res:opt){
			System.out.print(res.totalMinInvalidChars);
		}
		System.out.println("");
		for(Result res:opt){
			System.out.print(res.prevSplitIndx);
		}
		System.out.println("");
		StringBuffer bf = new StringBuffer();
		ArrayList<Integer> subStringIndices = new ArrayList<Integer>();
		subStringIndices.add(str.length());
		int indx = opt[opt.length-1].prevSplitIndx;
		while(indx >=0){
			subStringIndices.add(indx);
			indx = opt[indx].prevSplitIndx;
		}
		for(int i = subStringIndices.size()-2;i >=0;i--){
			bf.append(str.subSequence(subStringIndices.get(i+1), subStringIndices.get(i)));
			bf.append(" ");
		}
		System.out.println(bf.toString());
		
	}
	
	public static String reverseString(String st){
		return new StringBuffer(st).reverse().toString();
	}

}
