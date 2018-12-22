import java.util.ArrayList;
import java.util.Stack;
public class MatchingParan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(isvalid("}"));
		ParathesisMatch pm = new ParathesisMatch();
		System.out.println(pm.isvalid(""));
	}
	public static boolean isvalid(String str){
		Stack<Character> stk = new Stack<Character>();
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			char top;
			switch (ch){
				case '{': stk.push(ch);break;
				case '(': stk.push(ch);break;
				case '[': stk.push(ch);break;
				case '}': if (stk.isEmpty()) return false; top = stk.pop(); if(top!= '{') return false;break;
				case ')': if (stk.isEmpty()) return false; top = stk.pop(); if(top!= '(') return false;break;
				case ']': if (stk.isEmpty()) return false; top = stk.pop(); if(top!= ']') return false;break;
				default:return false;
			}
		}
		if(stk.isEmpty())
			return true;
		else
			return false;
	}
}
/***************************************
 * Better Implemenation uses Indices and abstracts type of parathesis;
 * @author sriram
 *
 */
class ParathesisMatch{
	ArrayList<Character> openParamAL = new ArrayList<Character>();
	ArrayList<Character> closeParamAL = new ArrayList<Character>();
	public boolean isvalid(String str){
		openParamAL.add('(');openParamAL.add('{');openParamAL.add('[');
		closeParamAL.add(')');closeParamAL.add('}');closeParamAL.add(']');
		Stack<Integer> stk = new Stack<Integer>();
		for(int i=0;i<str.length();i++){
			int openParamIndx = openParamAL.indexOf(str.charAt(i));
			int closeParamIndx = closeParamAL.indexOf(str.charAt(i));
			if(openParamIndx > -1)
				stk.push(openParamIndx);
			if(closeParamIndx >-1){
				if(stk.isEmpty())
					return false;
				int previousOpenParam = stk.pop();
				if(closeParamIndx != previousOpenParam)
					return false;
			}
		}
		if(stk.isEmpty())
			return true;
		else
			return false;
	}
	
}